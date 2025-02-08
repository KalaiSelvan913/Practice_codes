package com.fa.service;

import java.util.List;

import com.fa.dto.CommonDto;
import com.fa.dto.RelationDto;

public interface RelationService {

	CommonDto<?> save(RelationDto dto);

	CommonDto<List<RelationDto>> view();

}
