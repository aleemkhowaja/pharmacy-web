package com.samcm.controller.balancesheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.samcm.dto.balancesheet.RequestTransactionsDTO;
import com.samcm.dto.balancesheet.ResponseTransactionsDTO;
import com.samcm.service.interfaces.transactions.TransactionsService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionsController
{
	
	@Autowired
	private TransactionsService transactionsService;
	
	@PostMapping(value = "/findByDates")
    public ResponseEntity<ResponseTransactionsDTO> findByDates(@RequestBody RequestTransactionsDTO dto)
    {
		return new ResponseEntity<ResponseTransactionsDTO>(transactionsService.detail(dto), HttpStatus.OK);
    }

}
