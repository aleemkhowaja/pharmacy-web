package com.samcm.service.impl.dispatchpartydetails;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.samcm.dto.dispatchpartydetails.RequestDispatchPartyDetailsDTO;
import com.samcm.dto.dispatchpartydetails.ResponseDispatchPartyDetailsDTO;
import com.samcm.exception.CommonExceptionMessage;
import com.samcm.exception.Constraints;
import com.samcm.exception.ResourceNotFoundException;
import com.samcm.model.DispatchParty;
import com.samcm.model.DispatchPartyDetails;
import com.samcm.model.DispatchPartyLedger;
import com.samcm.repository.dispatchparty.DispatchPartyRepository;
import com.samcm.repository.dispatchpartydetails.DispatchPartyDetailsRepository;
import com.samcm.service.interfaces.dispatchpartydetails.DispatchPartyDetailsService;
import com.samcm.util.CommonConstant;
import com.samcm.util.CommonUtil;
import com.samcm.util.GridUtils;
import com.samcm.util.JQGridDTO;
import com.samcm.util.PropertiesUtil;

@Service
public class DispatchPartyDetailsServiceImpl implements DispatchPartyDetailsService
{
    @Autowired
    private DispatchPartyDetailsRepository dispatchPartyDetailsRepository;
    
    @Autowired
    private DispatchPartyRepository dispatchPartyRepository;

    @Override
    public ResponseDispatchPartyDetailsDTO create(RequestDispatchPartyDetailsDTO createDto)
    {
    	/**
    	 * retrieve Dispatch Part by id
    	 */
    	DispatchParty dispatchParty = dispatchPartyRepository.findById(createDto.getDispatchparty()).orElseThrow(
				() -> new ResourceNotFoundException(new CommonExceptionMessage(Constraints.DISPATCH_PARTY_NOT_FOUND)));
    	
    	DispatchPartyDetails dispatchPartyDetails = new DispatchPartyDetails();
    	
    	// copy properties from creat DTO to Model
    	PropertiesUtil.copyProperties(createDto, dispatchPartyDetails);
    	
    	//set dispatch party in detail object
    	dispatchPartyDetails.setDispatchParty(dispatchParty);
    	
    	// set values of created by / create date/ status while saving new record
    	CommonUtil.setSaveCreatedFieldValues(dispatchPartyDetails, CommonConstant.ACTIVE);

  		// save employeeModel in db
    	dispatchPartyDetailsRepository.save(dispatchPartyDetails);
    			
    	return detail(createDto);
    }

    @Override
    public ResponseDispatchPartyDetailsDTO findById(Integer modelId)
    {
    	DispatchPartyDetails dispatchPartyDetails = dispatchPartyDetailsRepository.findbyDispatchPartyDetailsId(modelId);
    	
    	ResponseDispatchPartyDetailsDTO responseDispatchPartyDetailsDTO = new ResponseDispatchPartyDetailsDTO();
    	
    	if(null == dispatchPartyDetails) return responseDispatchPartyDetailsDTO;
    		//throw ResourceNotFoundException(new CommonExceptionMessage(Constraints.DISPATCH_PARTY_NOT_FOUND));
    
		// copy properties from source to destinition object
		PropertiesUtil.copyProperties(dispatchPartyDetails, responseDispatchPartyDetailsDTO);
		
		/**
		 * Display Date in particular format
		 */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		responseDispatchPartyDetailsDTO.setDateOf(format.format(dispatchPartyDetails.getDateOf()));
		
		
		responseDispatchPartyDetailsDTO.setDispatchparty(dispatchPartyDetails.getDispatchParty().getDispatchPartyId());

    	return responseDispatchPartyDetailsDTO;
    }

    @Override
    public ResponseDispatchPartyDetailsDTO detail(RequestDispatchPartyDetailsDTO requestDTO)
    {
    	ResponseDispatchPartyDetailsDTO responseDispatchPartyDetailsDTO = new ResponseDispatchPartyDetailsDTO();

		// copy properties from request DTO to response DTO
		PropertiesUtil.copyProperties(requestDTO, responseDispatchPartyDetailsDTO);

		return responseDispatchPartyDetailsDTO;
    }

    @Override
    public JQGridDTO findAll(HttpServletRequest httpRequest)
    {
    	JQGridDTO<ResponseDispatchPartyDetailsDTO> jqGridDTO = new JQGridDTO<ResponseDispatchPartyDetailsDTO>();
    	
		String order = httpRequest.getParameter("sord");
		String sortingProperty = httpRequest.getParameter("sidx");
		int page = Integer.valueOf(httpRequest.getParameter("page")).intValue();
		Integer jtPageSize = httpRequest.getParameter("rows") == null ? 0 : Integer.parseInt(httpRequest.getParameter("rows"));
		Integer jtStartIndex = (page-1)*jtPageSize;
		
		
		Integer dispatchPartyId = httpRequest.getParameter("dispatchParty") != null && !httpRequest.getParameter("dispatchParty").equals("")  ? Integer.parseInt(httpRequest.getParameter("dispatchParty")) :null;
		
		
		Pageable pageable = GridUtils.buildPageable((page-1), jtPageSize,sortingProperty, order);
	
		/**
		 * retrieve all records
		 */
		Page<DispatchPartyDetails> dispatchPartyDetailsPage  = dispatchPartyDetailsRepository.filter(dispatchPartyId, pageable);
		
		/**
		 * retrieve all Count
		 */
		Long rowCount =  dispatchPartyDetailsRepository.count();
		
		List<ResponseDispatchPartyDetailsDTO> responseDispatchPartyDetailsDTOs = new  ArrayList<ResponseDispatchPartyDetailsDTO>();

		if(dispatchPartyDetailsPage.getContent() == null || dispatchPartyDetailsPage.getContent().size() <= 0) return jqGridDTO;
		
		for(DispatchPartyDetails details : dispatchPartyDetailsPage.getContent())
		{
			ResponseDispatchPartyDetailsDTO dto = new ResponseDispatchPartyDetailsDTO();
			dto.setDispatchPartyDetailsId(details.getDispatchPartyDetailsId());
			dto.setDispatchPartyDesc(details.getDispatchParty().getDispatchParty());
			
			/**
			 * Display Date in particular format
			 */
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			dto.setDateOf(format.format(details.getDateOf()));
			
			dto.setQuality(details.getQuality());
			dto.setTons(details.getTons());
			dto.setRate(details.getRate());
			dto.setAmount(details.getAmount());
			dto.setRebate(details.getRebate());
			responseDispatchPartyDetailsDTOs.add(dto);
		}
	 	jqGridDTO.setRows(responseDispatchPartyDetailsDTOs);
		jqGridDTO.setTotal(String.valueOf(Math.ceil((double) rowCount / jtPageSize)));
		jqGridDTO.setRecords(String.valueOf(rowCount));
		jqGridDTO.setPage(page);
		
		return jqGridDTO;
    }

    @Override
    public Integer delete(Integer modelId)
    {
    	DispatchPartyDetails dispatchPartyDetails = dispatchPartyDetailsRepository.findById(modelId).orElseThrow(
				() -> new ResourceNotFoundException(new CommonExceptionMessage(Constraints.DISPATCH_PARTY_NOT_FOUND)));

    	dispatchPartyDetails.setStatus(CommonConstant.DELETE);
    	dispatchPartyDetailsRepository.save(dispatchPartyDetails);
		return 1;
    }

    @Override
    public DispatchPartyDetails getIfExist(Integer modelId)
    {
	// TODO Auto-generated method stub
	return null;
    }

	@Override
	public List<ResponseDispatchPartyDetailsDTO> findAll() {
		
		List<DispatchPartyDetails> dispatchPartyDetails =  dispatchPartyDetailsRepository.findDispatchPartyDetailsWithParentProp();
		List<ResponseDispatchPartyDetailsDTO> dispatchPartyDetailsDTOs = new ArrayList<ResponseDispatchPartyDetailsDTO>();
		for(DispatchPartyDetails details : dispatchPartyDetails)
		{
			ResponseDispatchPartyDetailsDTO detailsDTO = new ResponseDispatchPartyDetailsDTO();
			detailsDTO.setDispatchparty(details.getDispatchParty().getDispatchPartyId());
			detailsDTO.setDispatchPartyDesc(details.getDispatchParty().getDispatchParty() +  " -- "+ details.getDateOf());
			dispatchPartyDetailsDTOs.add(detailsDTO);
		}
		return dispatchPartyDetailsDTOs;
	}

	@Override
	public List<ResponseDispatchPartyDetailsDTO> findByParentProperties(HashMap<String, Object> prop) {
		
//		Integer dispatchPartyId = prop.get("dispatchPartyId");
//		DispatchParty dispatchParty = dispatchPartyDetailsRepository.findDetailsByDispatchId(dispatchPartyId);
//		
//		List<ResponseDispatchPartyDetailsDTO> responseDispatchPartyDetailsDTOs = 
//				new ArrayList<ResponseDispatchPartyDetailsDTO>();
//    	
//    	if(null == dispatchParty.getRequestDispatchPartyDetailsList() || dispatchParty.getRequestDispatchPartyDetailsList().size() <= 0) return responseDispatchPartyDetailsDTOs;
//    	
//		// copy properties from source to destinition object
//		//PropertiesUtil.copyProperties(dispatchPartyDetails, responseDispatchPartyDetailsDTO);
//		
//    	for(int i=0; i<dispatchParty.getRequestDispatchPartyDetailsList().size(); i++)
//    	{
//    		ResponseDispatchPartyDetailsDTO responseDispatchPartyDetailsDTO = new ResponseDispatchPartyDetailsDTO();
//    		PropertiesUtil.copyProperties(dispatchParty.getRequestDispatchPartyDetailsList().get(i), responseDispatchPartyDetailsDTO);
//    		
//    		/**
//    		 * Display Date in particular format
//    		 */
//    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//    		responseDispatchPartyDetailsDTO.setDateOf(format.format(dispatchParty.getRequestDispatchPartyDetailsList().get(i).getDateOf()));
//    		responseDispatchPartyDetailsDTOs.add(responseDispatchPartyDetailsDTO);
//    	}
//    	
//		if(null == dispatchParty.getDispatchPartyLedgers() ||  dispatchParty.getDispatchPartyLedgers().size() <= 0) return responseDispatchPartyDetailsDTOs;
//		
//		for(DispatchPartyLedger ledger :  dispatchParty.getRequestDispatchPartyDetailsList().get(i)
//																					.getDispatchPartyLedgers())
//		{
//			responseDispatchPartyDetailsDTO.setPaidAmount(
//					ledger.getRecievedAmount()+responseDispatchPartyDetailsDTO.getPaidAmount());
//			
//			responseDispatchPartyDetailsDTO.setRemainingAmount(
//					ledger.getRemaining()+ responseDispatchPartyDetailsDTO.getRemainingAmount());
//		}
//		
//		
//    	return responseDispatchPartyDetailsDTOs;
	return null;
	}
	
}