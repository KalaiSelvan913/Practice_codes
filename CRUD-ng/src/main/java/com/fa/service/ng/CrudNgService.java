package com.fa.service.ng;

import com.fa.dto.ng.CommonDto;
import com.fa.dto.ng.CrudNgDto;


public interface CrudNgService {

	public CommonDto save(CrudNgDto dto);

	public CommonDto getAllData();

	public CommonDto edit(CrudNgDto dto);

	public CommonDto deleteByName(CrudNgDto dto);

//	public CommonDto savePassword(CrudNgDto dto);

	public CommonDto loginValidation(CrudNgDto dto);

	public CommonDto findByName(String name);

	

	

}
