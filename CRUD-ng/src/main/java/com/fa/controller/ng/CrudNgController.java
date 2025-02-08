package com.fa.controller.ng;

import javax.annotation.Resource;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.dto.ng.CommonDto;
import com.fa.dto.ng.CrudNgDto;
import com.fa.service.ng.CrudNgService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class CrudNgController {
	
	@Resource
	CrudNgService crudNgService;
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public ResponseEntity<?>Save(@RequestBody CrudNgDto dto){
		
		CommonDto commonDto = null;
		commonDto = crudNgService.save(dto);
		
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllData", method= RequestMethod.GET)
	public ResponseEntity<?>getAllData(){
		
		CommonDto commonDto = null;
		commonDto = crudNgService.getAllData();
		
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/edit", method= RequestMethod.POST)
	public ResponseEntity<?>edit(@RequestBody CrudNgDto dto){
		
		CommonDto commonDto = null;
		commonDto = crudNgService.edit(dto);
		
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.POST)
	public ResponseEntity<?>delete(@RequestBody CrudNgDto dto){
		
		CommonDto commonDto = null;
		commonDto = crudNgService.deleteByName(dto);
		
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}
	
//	@RequestMapping(value="/savePassword", method= RequestMethod.POST)
//	public ResponseEntity<?>savePassword(@RequestBody CrudNgDto dto){
//		
//		CommonDto commonDto = null;
//		commonDto = crudNgService.savePassword(dto);
//		
//		
//		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
//	}
	
	
    //For Login Validation API
	@RequestMapping(value="/loginValidation", method= RequestMethod.POST)
	public ResponseEntity<?>loginValidation(@RequestBody CrudNgDto dto){
		
		CommonDto commonDto = null;
		commonDto = crudNgService.loginValidation(dto);
		
		
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getDataByName", method= RequestMethod.POST)
	public ResponseEntity<?>findByName(@RequestParam(name="empName") String name){
		System.err.println(name);
		CommonDto commonDto = null;
		commonDto = crudNgService.findByName(name);
		System.err.println(commonDto);
		
		
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}
	
	
	
	

}
