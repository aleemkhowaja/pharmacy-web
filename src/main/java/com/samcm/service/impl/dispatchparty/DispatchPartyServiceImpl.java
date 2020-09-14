package com.samcm.service.impl.dispatchparty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.samcm.dto.dispatchparty.RequestDispatchPartyDTO;
import com.samcm.dto.dispatchparty.ResponseDispatchPartyDTO;
import com.samcm.exception.CommonExceptionMessage;
import com.samcm.exception.Constraints;
import com.samcm.exception.ResourceNotFoundException;
import com.samcm.model.DispatchParty;
import com.samcm.model.DispatchPartyDetails;
import com.samcm.repository.dispatchparty.DispatchPartyRepository;
import com.samcm.service.interfaces.dispatchparty.DispatchPartyService;
import com.samcm.util.CommonConstant;
import com.samcm.util.CommonUtil;
import com.samcm.util.GridUtils;
import com.samcm.util.JQGridDTO;
import com.samcm.util.PropertiesUtil;

@Service
public class DispatchPartyServiceImpl implements DispatchPartyService {

	@Autowired
	private DispatchPartyRepository dispatchPartyRepository;

	@Override
	public ResponseDispatchPartyDTO create(RequestDispatchPartyDTO createDto) {
		List<DispatchPartyDetails> dispatchPartyDetailList = new ArrayList<DispatchPartyDetails>();

		// dispatchPartyDetails =
		// PropertiesUtil.copyListToList(createDto.getRequestDispatchPartyDetailsList(),
		// dispatchPartyDetails);

		DispatchParty dispatchParty = new DispatchParty();

		// copy properties from creat DTO to Model
		PropertiesUtil.copyProperties(createDto, dispatchParty);

		/**
		 * Dispatch party details DTO to model
		 */
//		createDto.getRequestDispatchPartyDetailsList().stream().forEach(dispatchPartyDetailsDTO -> {
//			DispatchPartyDetails dispatchPartyDetails = new DispatchPartyDetails();
//			PropertiesUtil.copyProperties(dispatchPartyDetailsDTO, dispatchPartyDetails);
//			dispatchPartyDetails.setDispatchParty(dispatchParty);
//
//			// set values of created by / create date/ status while saving new record
//			CommonUtil.setSaveCreatedFieldValues(dispatchPartyDetails, CommonConstant.ACTIVE);
//
//			dispatchPartyDetailList.add(dispatchPartyDetails);
//		});
//
//		dispatchParty.setRequestDispatchPartyDetailsList(dispatchPartyDetailList);

		// set values of created by / create date/ status while saving new record
		CommonUtil.setSaveCreatedFieldValues(dispatchParty, CommonConstant.ACTIVE);

		// save employeeModel in db
		dispatchPartyRepository.save(dispatchParty);

		// return details with Response DTO
		return detail(createDto);
	}

	@Override
	public ResponseDispatchPartyDTO findById(Integer modelId) {
		DispatchParty dispatchParty = dispatchPartyRepository.findById(modelId).orElseThrow(
				() -> new ResourceNotFoundException(new CommonExceptionMessage(Constraints.DISPATCH_PARTY_NOT_FOUND)));

		ResponseDispatchPartyDTO responseDispatchPartyDTO = new ResponseDispatchPartyDTO();
		// copy properties from source to destinition object
		PropertiesUtil.copyProperties(dispatchParty, responseDispatchPartyDTO);

		return responseDispatchPartyDTO;
	}

	@Override
	public ResponseDispatchPartyDTO detail(RequestDispatchPartyDTO requestDTO) {
		ResponseDispatchPartyDTO responseDispatchPartyDTO = new ResponseDispatchPartyDTO();

		// copy properties from request DTO to response DTO
		PropertiesUtil.copyProperties(requestDTO, responseDispatchPartyDTO);

		return responseDispatchPartyDTO;
	}

	@Override
	public JQGridDTO findAll(HttpServletRequest request) {
		
		JQGridDTO<ResponseDispatchPartyDTO> jqGridDTO = new JQGridDTO<ResponseDispatchPartyDTO>();
		
		String order = request.getParameter("sord");
		String sortingProperty = request.getParameter("sidx");
		int page = Integer.valueOf(request.getParameter("page")).intValue();
		Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
		Integer jtStartIndex = (page - 1) * jtPageSize;

		String dispatchParty = request.getParameter("dispatchParty");

		Pageable pageable = GridUtils.buildPageable((page-1), jtPageSize, sortingProperty, order);

		/**
		 * retrieve all records
		 */
		Page<DispatchParty> dispatchPartyPage = dispatchPartyRepository.filter(dispatchParty, null, pageable);
		
		/**
		 * retrieve all Count
		 */
		Long rowCount = dispatchPartyRepository.count();
		
		if(dispatchPartyPage.getContent() == null || dispatchPartyPage.getContent().size() <= 0) return jqGridDTO;

		List<ResponseDispatchPartyDTO> responseDispatchPartyDTOs = new ArrayList<ResponseDispatchPartyDTO>();
		
		for(DispatchParty party : dispatchPartyPage.getContent())
		{
		    ResponseDispatchPartyDTO responseDispatchPartyDTO = new ResponseDispatchPartyDTO();
		    responseDispatchPartyDTO.setDispatchPartyId(party.getDispatchPartyId());
		    responseDispatchPartyDTO.setDispatchPartyOwner(party.getDispatchPartyOwner());
		    responseDispatchPartyDTO.setDispatchParty(party.getDispatchParty());
		    responseDispatchPartyDTOs.add(responseDispatchPartyDTO);
		}
		/**
		 * JQ Grid Required parameters
		 */
		jqGridDTO.setRows(responseDispatchPartyDTOs);
		jqGridDTO.setTotal(String.valueOf(Math.ceil((double) rowCount / jtPageSize)));
		jqGridDTO.setRecords(String.valueOf(rowCount));
		jqGridDTO.setPage(page);
		return jqGridDTO;
	}
	
	@Override
	public List<ResponseDispatchPartyDTO> findAll() 
	{
		List<DispatchParty> dispatchParty = dispatchPartyRepository.findAll();
		List<ResponseDispatchPartyDTO> responseDispatchPartyDTOs = new ArrayList<ResponseDispatchPartyDTO>();
		List dispatchPartyDTOs = PropertiesUtil.copyListToList(dispatchParty,responseDispatchPartyDTOs);
		return dispatchPartyDTOs;
	}

	@Override
	public Integer delete(Integer modelId) {
		DispatchParty dispatchParty = dispatchPartyRepository.findById(modelId).orElseThrow(
				() -> new ResourceNotFoundException(new CommonExceptionMessage(Constraints.DISPATCH_PARTY_NOT_FOUND)));

		dispatchParty.setStatus(CommonConstant.DELETE);
		dispatchPartyRepository.save(dispatchParty);
		return 1;
	}

	@Override
	public DispatchParty getIfExist(Integer modelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseDispatchPartyDTO> findByParentProperties(HashMap<String, Object> prop) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}