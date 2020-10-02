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
import com.samcm.enums.TransactionType;
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

			if (transactions == null || transactions.size() < 1)
				return responseTransactionsDTO;

			Integer totalCreditAmount = 0;
			Integer totalDebitAmount = 0;
			Integer closingBalance = 0;

			for (Transactions trans : transactions) {
				ResponseTransactionsDTO dto = new ResponseTransactionsDTO();
				dto.setDate(format.parse(format.format(trans.getDate())));
				dto.setAmount(trans.getAmount());
				dto.setTransactionType(trans.getTransactionType());
				dto.setDescription(trans.getDescription());
				responseTransactionsDTOs.add(dto);

				if (trans.getTransactionType().equals(TransactionType.credit.getValue()))
					totalCreditAmount += trans.getAmount();

				if (trans.getTransactionType().equals(TransactionType.debit.getValue()))
					totalDebitAmount += trans.getAmount();

			}

			closingBalance = totalCreditAmount - totalDebitAmount;

			/**
			 * 
			 */
			responseTransactionsDTO.setTotalCreditAmount(totalCreditAmount);
			responseTransactionsDTO.setTotalDebitAmount(totalDebitAmount);
			responseTransactionsDTO.setClosingBalance(closingBalance);
			responseTransactionsDTO.setResponseTransactionsDTOs(responseTransactionsDTOs);
			
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		return responseTransactionsDTO;
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
