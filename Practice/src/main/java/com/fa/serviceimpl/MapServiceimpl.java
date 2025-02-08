package com.fa.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.dto.CommonDto;
import com.fa.dto.MapDto;
import com.fa.dto.RoleDto;
import com.fa.entity.MapEntity;
import com.fa.entity.RoleEntity;
import com.fa.repository.MapRepository;
import com.fa.repository.RoleRepository;
import com.fa.service.MapService;

@Service
public class MapServiceimpl implements MapService {

	@Autowired
	MapRepository mapRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public CommonDto<?> roleSave(RoleDto dto) {
		CommonDto<?> response = new CommonDto<>();

		RoleEntity entity = new RoleEntity();
		entity.setRole(dto.getRole());
		roleRepository.save(entity);
		response.setStatus("Success");

		return response;
	}

	@Override
	public CommonDto<?> save(MapDto dto) {
		CommonDto<?> response = new CommonDto<>();

		MapEntity entity = new MapEntity();
		entity.setName(dto.getName());
		entity.setMobile(dto.getMobile());
		List<RoleEntity> role = new ArrayList<RoleEntity>();
		List<RoleDto> roleDto = dto.getRole();

		for (RoleDto r : roleDto) {
			Optional<RoleEntity> rol = roleRepository.findById(Long.valueOf(r.getId()));
			RoleEntity en = rol.get();
			role.add(en);
		}
		entity.setRole(role);
		mapRepository.save(entity);
		response.setStatus("Saved Successfully");

		return response;
	}

}
