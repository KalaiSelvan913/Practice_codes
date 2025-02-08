package com.fa.service;

import com.fa.dto.CommonDto;
import com.fa.dto.MapDto;
import com.fa.dto.RelationDto;
import com.fa.dto.RoleDto;

public interface MapService {

	CommonDto<?> roleSave(RoleDto dto);

	CommonDto<?> save(MapDto dto);

}
