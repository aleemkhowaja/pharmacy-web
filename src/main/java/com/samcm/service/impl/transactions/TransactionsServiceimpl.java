package com.samcm.service.impl.transactions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samcm.dto.balancesheet.RequestTransactionsDTO;
import com.samcm.dto.balancesheet.ResponseTransactionsDTO;
import com.samcm.dto.employee.ResponseEmployeeDTO;
import com.samcm.model.Employee;
import com.samcm.model.Transactions;
import com.samcm.repository.transactions.TransactionsRepository;
import com.samcm.service.interfaces.transactions.TransactionsService;
import com.samcm.util.JQGridDTO;

@Service
public class TransactionsServiceimpl implements TransactionsService
{
    
    @Autowired
    private TransactionsRepository  transactionsRepository;

    @Override
    public ResponseTransactionsDTO create(RequestTransactionsDTO createDto)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ResponseTransactionsDTO findById(Integer modelId)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ResponseTransactionsDTO detail(RequestTransactionsDTO requestDTO)
    {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	ResponseTransactionsDTO responseTransactionsDTO = new ResponseTransactionsDTO();
	
	List<ResponseTransactionsDTO> responseTransactionsDTOs = new ArrayList<ResponseTransactionsDTO>();
	try
	{
	    Date fromDate = format.parse(format.format(requestDTO.getFromDate()));
	    Date toDate = format.parse(format.format(requestDTO.getToDate()));

	    /**
	     * return all transaction details
	     */
	    List<Transactions> transactions = transactionsRepository.findTransactionsDetail(fromDate, toDate);
	    
	    if(transactions == null || transactions.size() < 1) return responseTransactionsDTO;

	    for(Transactions trans : transactions)
	    {
		responseTransactionsDTOs = new ArrayList<ResponseTransactionsDTO>();
		ResponseTransactionsDTO dto = new ResponseTransactionsDTO();
		dto.setDate(trans.getDate());
		dto.setAmount(trans.getAmount());
		dto.setDescription(trans.getDescription());
		responseTransactionsDTOs.add(dto);
		
		responseTransactionsDTO.setResponseTransactionsDTOs(responseTransactionsDTOs);

	    }
	}
	catch(ParseException e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    public JQGridDTO findAll(HttpServletRequest httpRequest)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ResponseTransactionsDTO> findAll()
    {
	
	return null;
    }

    @Override
    public Integer delete(Integer modelId)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Transactions getIfExist(Integer modelId)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ResponseTransactionsDTO> findByParentProperties(HashMap<String, Object> prop)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ResponseTransactionsDTO> findTransactionsDetail(Date fromDate, Date toDate)
    {

	return null;
    }
    
    
    
}
