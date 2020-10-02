package com.samcm.service.impl.dispatchpartyledger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samcm.dto.dispatchpartydetails.ResponseDispatchPartyDetailsDTO;
import com.samcm.dto.dispatchpartyledger.RequestDispatchPartyLedgerDTO;
import com.samcm.dto.dispatchpartyledger.ResponseDispatchPartyLedgerDTO;
import com.samcm.enums.TransactionType;
import com.samcm.exception.CommonExceptionMessage;
import com.samcm.exception.Constraints;
import com.samcm.exception.ResourceNotFoundException;
import com.samcm.model.DispatchParty;
import com.samcm.model.DispatchPartyLedger;
import com.samcm.model.GenLedger;
import com.samcm.model.Transactions;
import com.samcm.repository.dispatchparty.DispatchPartyRepository;
import com.samcm.repository.dispatchpartydetails.DispatchPartyDetailsRepository;
import com.samcm.repository.dispatchpartyledger.DispatchPartyLedgerRepository;
import com.samcm.repository.genledger.GenLedgerRepository;
import com.samcm.repository.transactions.TransactionsRepository;
import com.samcm.service.interfaces.dispatchpartyledger.DispatchPartyLedgerService;
import com.samcm.util.CommonConstant;
import com.samcm.util.CommonUtil;
import com.samcm.util.JQGridDTO;
import com.samcm.util.PropertiesUtil;

@Service
public class DispatchPartyLedgerServiceImpl implements DispatchPartyLedgerService
{

    @Autowired
    private DispatchPartyLedgerRepository dispatchPartyLedgerRepository;

    @Autowired
    private DispatchPartyDetailsRepository dispatchPartyDetailsRepository;

    @Autowired
    private DispatchPartyRepository dispatchPartyRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;
    
    @Autowired
    private GenLedgerRepository genLedgerRepository;

    @Override
    public ResponseDispatchPartyLedgerDTO create(RequestDispatchPartyLedgerDTO createDto)
    {

	/**
	 * retrieve Dispatch Part by id
	 */
	DispatchParty dispatchParty = dispatchPartyRepository.findById(createDto.getDispatchPartyId())
		.orElseThrow(() -> new ResourceNotFoundException(
			new CommonExceptionMessage(Constraints.DISPATCH_PARTY_DETAIL_NOT_FOUND)));

	DispatchPartyLedger dispatchPartyLedger = new DispatchPartyLedger();

	// copy properties from creat DTO to Model
	PropertiesUtil.copyProperties(createDto, dispatchPartyLedger);

	// set dispatch party details in dispatchPartyLedger object
	dispatchPartyLedger.setDispatchLedgerParty(dispatchParty);

	// set values of created by / create date/ status while saving new
	// record
	CommonUtil.setSaveCreatedFieldValues(dispatchPartyLedger, CommonConstant.ACTIVE);

	PropertiesUtil.emptyPropertiesToNull(dispatchPartyLedger);

	// Update value of ModifiedNy/Modified Date for DispatchDetails
	// CommonUtil.setSaveUpdatedFieldValues(dispatchPartyDetails,
	// CommonConstant.ACTIVE);

//    	dispatchPartyDetailsRepository.save(dispatchPartyDetails);

	// save dispatchPartyLedger in db
	dispatchPartyLedgerRepository.save(dispatchPartyLedger);

	ResponseDispatchPartyLedgerDTO ledgerDTO = new ResponseDispatchPartyLedgerDTO();

	// copy properties from request DTO to response DTO
	PropertiesUtil.copyProperties(dispatchPartyLedger, ledgerDTO);
	
	/**
	 * save transaction
	 */
	saveTransactions(dispatchPartyLedger);

	return ledgerDTO;
    }

    /**
     * save transactions
     * 
     * @param dispatchPartyLedger
     * @return
     */
    private Integer saveTransactions(DispatchPartyLedger dispatchPartyLedger)
    {
	/**
	 * return General Ledger for GloCode = 4 (Income)
	 */
	GenLedger genLedger = genLedgerRepository.findGLByglCode(4);
	
	/**
	 * set transaction properties
	 */
	Transactions transactions = new Transactions();
	transactions.setAmount(dispatchPartyLedger.getRecievedAmount());
	transactions.setDescription("Amount Recieved from Dispatch Party");
	transactions.setTransactionType(TransactionType.credit.getValue());
	transactions.setDate(new Date());
	
	/**
	 * set General Ledger
	 */
	transactions.setGenLedger(genLedger);

	// set values of created by / create date/ status while saving new
	CommonUtil.setSaveCreatedFieldValues(transactions, CommonConstant.ACTIVE);

	/**
	 * save transaction
	 */
	transactions = transactionsRepository.save(transactions);

	return transactions == null ? 0 : 1;

    }

    @Override
    public ResponseDispatchPartyLedgerDTO findById(Integer modelId)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ResponseDispatchPartyLedgerDTO detail(RequestDispatchPartyLedgerDTO requestDTO)
    {

	DispatchParty dispatchParty = dispatchPartyDetailsRepository
		.findDetailsByDispatchId(requestDTO.getDispatchPartyId());

	ResponseDispatchPartyLedgerDTO responseDispatchPartyLedgerDTO = new ResponseDispatchPartyLedgerDTO();

	List<ResponseDispatchPartyDetailsDTO> responseDispatchPartyDetailsDTOs = new ArrayList<ResponseDispatchPartyDetailsDTO>();

	if(null == dispatchParty.getRequestDispatchPartyDetailsList()
		|| dispatchParty.getRequestDispatchPartyDetailsList().size() <= 0)
	    return responseDispatchPartyLedgerDTO;

	// copy properties from source to destinition object
	// PropertiesUtil.copyProperties(dispatchPartyDetails,
	// responseDispatchPartyDetailsDTO);

	for(int i = 0; i < dispatchParty.getRequestDispatchPartyDetailsList().size(); i++)
	{
	    ResponseDispatchPartyDetailsDTO responseDispatchPartyDetailsDTO = new ResponseDispatchPartyDetailsDTO();
	    PropertiesUtil.copyProperties(dispatchParty.getRequestDispatchPartyDetailsList().get(i),
		    responseDispatchPartyDetailsDTO);

	    /**
	     * Display Date in particular format
	     */
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    responseDispatchPartyDetailsDTO
		    .setDateOf(format.format(dispatchParty.getRequestDispatchPartyDetailsList().get(i).getDateOf()));
	    responseDispatchPartyDetailsDTOs.add(responseDispatchPartyDetailsDTO);
	}

	responseDispatchPartyLedgerDTO.setResponseDispatchPartyDetailsDTOs(responseDispatchPartyDetailsDTOs);

	if(null == dispatchParty.getDispatchPartyLedgers() || dispatchParty.getDispatchPartyLedgers().size() <= 0)
	    return responseDispatchPartyLedgerDTO;

	for(DispatchPartyLedger ledger : dispatchParty.getDispatchPartyLedgers())
	{
	    responseDispatchPartyLedgerDTO.setPaidAmount(
		    ledger.getRecievedAmount() + (responseDispatchPartyLedgerDTO.getPaidAmount() == null ? 0
			    : responseDispatchPartyLedgerDTO.getPaidAmount()));

	    responseDispatchPartyLedgerDTO
		    .setRemainingAmount(ledger.getRemaining() == null ? 0 : ledger.getRemaining());
	}
	
	return responseDispatchPartyLedgerDTO;
    }

    @Override
    public JQGridDTO findAll(HttpServletRequest httpRequest)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ResponseDispatchPartyLedgerDTO> findAll()
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Integer delete(Integer modelId)
    {
	DispatchPartyLedger dispatchPartyLedger = dispatchPartyLedgerRepository.findById(modelId)
		.orElseThrow(() -> new ResourceNotFoundException(
			new CommonExceptionMessage(Constraints.DISPATCH_PARTY_LEDGER_NOT_FOUND)));

	dispatchPartyLedger.setStatus(CommonConstant.DELETE);
	dispatchPartyLedgerRepository.save(dispatchPartyLedger);
	return 1;
    }

    @Override
    public DispatchPartyLedger getIfExist(Integer modelId)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ResponseDispatchPartyLedgerDTO> findByParentProperties(HashMap<String, Object> prop)
    {

	return null;
    }

}
