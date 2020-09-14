package com.samcm.controller.dispatcherpartyledger;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samcm.dto.dispatchpartydetails.ResponseDispatchPartyDetailsDTO;
import com.samcm.dto.dispatchpartyledger.RequestDispatchPartyLedgerDTO;
import com.samcm.dto.dispatchpartyledger.ResponseDispatchPartyLedgerDTO;
import com.samcm.service.interfaces.dispatchpartyledger.DispatchPartyLedgerService;
import com.samcm.util.JQGridDTO;

@RestController
@RequestMapping(value = "/dispatchpartyledger")
public class DispatchPartyLedgerController
{

    @Autowired
    private DispatchPartyLedgerService dispatchPartyLedgerService;

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseDispatchPartyLedgerDTO> create(@RequestBody RequestDispatchPartyLedgerDTO createDto)
    {
    	return new ResponseEntity<ResponseDispatchPartyLedgerDTO>(dispatchPartyLedgerService.create(createDto), HttpStatus.OK);
    }

    @PostMapping(value = "/findById")
    public ResponseEntity<ResponseDispatchPartyLedgerDTO> findById(@RequestParam int id)
    {
    	return new ResponseEntity<ResponseDispatchPartyLedgerDTO>(dispatchPartyLedgerService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping(value = "/findAll")
    public JQGridDTO<ResponseDispatchPartyLedgerDTO> findAll(HttpServletRequest request)
    {
    	return dispatchPartyLedgerService.findAll(request);
    }
    
    @PostMapping(value = "/delete")
    public ResponseEntity<Integer> delete(@RequestParam int id) {
    	return new ResponseEntity<Integer>(dispatchPartyLedgerService.delete(id), HttpStatus.OK);
    }
    
    @PostMapping(value = "/findDetailsByDispatchId")
    public ResponseDispatchPartyLedgerDTO findDetailsByDispatchId(@RequestParam int dispatchPartyId)
    {
    	RequestDispatchPartyLedgerDTO requestDTO = new RequestDispatchPartyLedgerDTO();
    	requestDTO.setDispatchPartyId(dispatchPartyId);
    	return dispatchPartyLedgerService.detail(requestDTO);
    }

}
