package com.samcm.controller.dispatcherpartydetails;

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

import com.samcm.dto.dispatchpartydetails.RequestDispatchPartyDetailsDTO;
import com.samcm.dto.dispatchpartydetails.ResponseDispatchPartyDetailsDTO;
import com.samcm.service.interfaces.dispatchpartydetails.DispatchPartyDetailsService;
import com.samcm.util.JQGridDTO;

@RestController
@RequestMapping(value = "/dispatchpartydetails")
public class DispatchPartyDetailsController
{

    @Autowired
    private DispatchPartyDetailsService dispatchPartyDetailsService;

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseDispatchPartyDetailsDTO> create(@RequestBody RequestDispatchPartyDetailsDTO createDto)
    {
    	return new ResponseEntity<ResponseDispatchPartyDetailsDTO>(dispatchPartyDetailsService.create(createDto), HttpStatus.OK);
    }

    @PostMapping(value = "/findById")
    public ResponseEntity<ResponseDispatchPartyDetailsDTO> findById(@RequestParam int id)
    {
    	return new ResponseEntity<ResponseDispatchPartyDetailsDTO>(dispatchPartyDetailsService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping(value = "/findAll")
    public JQGridDTO findAll(HttpServletRequest request)
    {
    	return dispatchPartyDetailsService.findAll(request);
    }
    
    @PostMapping(value = "/delete")
    public ResponseEntity<Integer> delete(@RequestParam int id) {
    	return new ResponseEntity<Integer>(dispatchPartyDetailsService.delete(id), HttpStatus.OK);
    }
    
    @PostMapping(value = "/findByDispatchId")
    public ResponseEntity<ResponseDispatchPartyDetailsDTO> findByDispatchId(@RequestParam int id)
    {
    	return new ResponseEntity<ResponseDispatchPartyDetailsDTO>(dispatchPartyDetailsService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping(value = "/findDetailsByDispatchId")
    public List<ResponseDispatchPartyDetailsDTO> findDetailsByDispatchId(@RequestParam int parentId)
    {
    	HashMap<String, Object> propMap = new HashMap<String, Object>();
    	propMap.put("dispatchPartyId", parentId);
    	List<ResponseDispatchPartyDetailsDTO> responseDispatchPartyDetailsDTO = dispatchPartyDetailsService.findByParentProperties(propMap);
    	return responseDispatchPartyDetailsDTO;
    }
    
    

}
