package com.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fa.dto.CommonDto;
import com.fa.dto.RelationDto;
import com.fa.service.RelationService;

@RestController
public class RelationController {

	@Autowired
	RelationService relationService;

	@PostMapping(value = "/save")
	public ResponseEntity<CommonDto<?>> save(@RequestBody RelationDto dto) {
		CommonDto<?> response = relationService.save(dto);
		return new ResponseEntity<CommonDto<?>>(response, HttpStatus.OK);

	}
	
	
	@GetMapping(value = "/view")
	public ResponseEntity<CommonDto<List<RelationDto>>> view() {
		CommonDto<List<RelationDto>> response = relationService.view();
		return new ResponseEntity<CommonDto<List<RelationDto>>>(response, HttpStatus.OK);

	}
}
