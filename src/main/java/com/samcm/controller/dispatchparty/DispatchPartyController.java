package com.samcm.controller.dispatchparty;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samcm.dto.dispatchparty.RequestDispatchPartyDTO;
import com.samcm.dto.dispatchparty.ResponseDispatchPartyDTO;
import com.samcm.service.interfaces.dispatchparty.DispatchPartyService;
import com.samcm.util.JQGridDTO;

@RestController
@RequestMapping(value = "/dispatchparty")
public class DispatchPartyController
{

    @Autowired
    private DispatchPartyService dispatchPartyService;

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseDispatchPartyDTO> create(@RequestBody RequestDispatchPartyDTO createDto)
    {
	return new ResponseEntity<ResponseDispatchPartyDTO>(dispatchPartyService.create(createDto), HttpStatus.OK);
    }

    @PostMapping(value = "/findById")
    public ResponseEntity<ResponseDispatchPartyDTO> findById(@RequestParam int id)
    {
	return new ResponseEntity<ResponseDispatchPartyDTO>(dispatchPartyService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping(value = "/findAll")
    public JQGridDTO findAll(HttpServletRequest request)
    {
	return dispatchPartyService.findAll(request);
    }
    
    @PostMapping(value = "/delete")
    public ResponseEntity<Integer> delete(@RequestParam int id) {
	return new ResponseEntity<Integer>(dispatchPartyService.delete(id), HttpStatus.OK);
    }

}
