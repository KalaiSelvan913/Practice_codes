package com.kalaiselvan.springbootsecurity.service.impl;

import static com.kalaiselvan.springbootsecurity.constants.ComConstants.ADMIN;
import static com.kalaiselvan.springbootsecurity.constants.ComConstants.SUCCESS;
import static com.kalaiselvan.springbootsecurity.constants.ComConstants.UPDATED_RESOURCE;
import static com.kalaiselvan.springbootsecurity.entity.Sequence.SequenceConstants.ROLE_CODE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kalaiselvan.springbootsecurity.dto.ResponseDto;
import com.kalaiselvan.springbootsecurity.dto.RolesDto;
import com.kalaiselvan.springbootsecurity.entity.Role;
import com.kalaiselvan.springbootsecurity.entity.Sequence.SeqGenerator;
import com.kalaiselvan.springbootsecurity.mapping.GenericMapping;
import com.kalaiselvan.springbootsecurity.repository.RoleRepo;
import com.kalaiselvan.springbootsecurity.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class RoleServiceImpl implements RoleService {
	
  private final GenericMapping mapper;

  private final RoleRepo roleRepo;

  private final SeqGenerator seqGenerator;

  @Override
  public ResponseDto<RolesDto> saveRole(RolesDto roleDto) {
//		ResponseDto<RolesDto> response = new ResponseDto<>();
    Role role = mapper.map(roleDto, Role.class);
    role.setRoleCode(seqGenerator.generateSeqCode(ROLE_CODE));
    role.setCreatedBy(ADMIN);
    role.setCreatedDate(LocalDate.now());
    role.setLastModifiedBy(ADMIN);
    role.setLastModifiedDate(LocalDateTime.now());
    Role savedRole = roleRepo.save(role);
    RolesDto savedRoleDto = mapper.map(savedRole, RolesDto.class);
//			response = ResponseUtils.successResponse(savedRoleDto);
    return new ResponseDto<>(200, savedRoleDto, true, SUCCESS);
  }

  @Override
  public ResponseDto<RolesDto> updateRole(RolesDto roleDto) {
//		ResponseDto<RolesDto> response = new ResponseDto<>();
    Role role = Optional.of(roleRepo.findByRoleCode(roleDto.getRoleCode()))
        .orElseThrow(() -> new RuntimeException("Role Not Found"));
    role.setName(roleDto.getName());
    role.setLastModifiedBy(ADMIN);
    role.setLastModifiedDate(LocalDateTime.now());
    Role savedRole = roleRepo.save(role);
    RolesDto savedRoleDto = mapper.map(savedRole, RolesDto.class);
//		response = ResponseUtils.successResponse(savedRoleDto);
    return new ResponseDto<>(200, savedRoleDto, true, UPDATED_RESOURCE);
  }

  @Override
  public ResponseDto<List<RolesDto>> getAllRoles() {
//		ResponseDto<List<RolesDto>> response = new ResponseDto<>();
    List<Role> roleList = Optional.of(roleRepo.findAll())
        .orElseThrow(() -> new RuntimeException("Roles are not found"));
    List<RolesDto> rolesDtoList = mapper.mapAll(roleList, RolesDto.class);
//		response = ResponseUtils.successResponse(rolesDtoList);
    return new ResponseDto<>(200, rolesDtoList, true, SUCCESS);
  }

}
