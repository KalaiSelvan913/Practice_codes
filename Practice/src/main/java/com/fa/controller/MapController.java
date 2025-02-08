package com.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fa.dto.CommonDto;
import com.fa.dto.MapDto;
import com.fa.dto.RoleDto;
import com.fa.service.MapService;

@RestController
public class MapController {

	@Autowired
	MapService mapService;
	
	@PostMapping(value = "/roleSave")
	public ResponseEntity<CommonDto<?>> save(@RequestBody RoleDto dto) {
		CommonDto<?> response = mapService.roleSave(dto);
		return new ResponseEntity<CommonDto<?>>(response, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/mapSave")
	public ResponseEntity<CommonDto<?>> save(@RequestBody MapDto dto) {
		CommonDto<?> response = mapService.save(dto);
		return new ResponseEntity<CommonDto<?>>(response, HttpStatus.OK);
	}
}
