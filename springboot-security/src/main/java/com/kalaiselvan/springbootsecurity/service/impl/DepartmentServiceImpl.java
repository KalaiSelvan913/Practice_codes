package com.kalaiselvan.springbootsecurity.service.impl;

import static com.kalaiselvan.springbootsecurity.constants.ComConstants.ACTIVE;
import static com.kalaiselvan.springbootsecurity.constants.ComConstants.ADMIN;
import static com.kalaiselvan.springbootsecurity.constants.ComConstants.SUCCESS;
import static com.kalaiselvan.springbootsecurity.constants.ComConstants.UPDATED_RESOURCE;
import static com.kalaiselvan.springbootsecurity.entity.Sequence.SequenceConstants.DEPARTMENT_CODE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kalaiselvan.springbootsecurity.dto.DepartmentDto;
import com.kalaiselvan.springbootsecurity.dto.ResponseDto;
import com.kalaiselvan.springbootsecurity.entity.Department;
import com.kalaiselvan.springbootsecurity.entity.Sequence.SeqGenerator;
import com.kalaiselvan.springbootsecurity.exception.DepartmentAlreadyExistsException;
import com.kalaiselvan.springbootsecurity.exception.DepartmentNotFoundException;
import com.kalaiselvan.springbootsecurity.mapping.GenericMapping;
import com.kalaiselvan.springbootsecurity.repository.DepartmentRepo;
import com.kalaiselvan.springbootsecurity.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepo deptRepo;

	private final GenericMapping mapper;
	
	private final SeqGenerator seqGenerator;
	

//	private final GenericExceptionHandling exceptionHandler;

//	public DepartmentServiceImpl(DepartmentRepo deptRepo, GenericMapping mapper) {
//		this.deptRepo = deptRepo;
//		this.mapper = mapper;
//	}

	@Override
	public String saveDepartment(DepartmentDto deptDto) {
//		logger.info("Starting Service name --> saveDepartment ");
		if (!deptRepo.findByDepartmentCodeAndStatus(deptDto.getDepartmentCode(), ACTIVE).isEmpty())
			throw new DepartmentAlreadyExistsException("Department Code is Already Exist");

		Department department = mapper.map(deptDto, Department.class);
		department.setDepartmentCode(seqGenerator.generateSeqCode(DEPARTMENT_CODE));
		department.setStatus(ACTIVE);
		department.setCreatedBy(ADMIN);
		department.setCreatedDate(LocalDate.now());
		department.setLastModifiedBy(ADMIN);
		department.setLastModifiedDate(LocalDateTime.now());

    deptRepo.save(department);
//    logger.info("saveDepartment Service Ended");
		return SUCCESS;
	}

	@Override
	public ResponseDto<List<DepartmentDto>> getDeptDetails() {
//		logger.info("Starting Service name --> getDeptDetails ");
//		ResponseDto<List<DepartmentDto>> response = new ResponseDto<>();
		List<Department> deptList = Optional.of(deptRepo.findAllByOrderByDepartmentNameAsc())
				.filter(dept -> !dept.isEmpty())
				.orElseThrow(() -> new DepartmentNotFoundException("No departments found"));
		List<DepartmentDto> deptDtoList = mapper.mapAll(deptList, DepartmentDto.class);
//		response = ResponseUtils.successResponse(deptDtoList);
		return new ResponseDto<>(200,deptDtoList,true,SUCCESS);
	}

	@Transactional
	@Override
	public ResponseEntity<ResponseDto<String>> editDepartment(List<DepartmentDto> deptDto) {
//		logger.info("Starting Service name --> editDepartment ");
//		ResponseDto<String> response = new ResponseDto<>();
//		try {
			Map<String, DepartmentDto> dtoMap = deptDto.stream()
					.collect(Collectors.toMap(DepartmentDto::getDepartmentCode, dto -> dto));
			List<String> deptCode = deptDto.stream().map(DepartmentDto::getDepartmentCode).collect(Collectors.toList());
			List<Department> existingDept = Optional.of(deptRepo.findByDepartmentCodeIn(deptCode))
					.orElseThrow(() -> new DepartmentNotFoundException("Department ID not found"));
			existingDept.forEach(dept -> {
				DepartmentDto dto = dtoMap.get(dept.getDepartmentCode());
				mapper.map(dto, dept);
			});
			Optional.of(deptRepo.saveAll(existingDept)).orElseThrow(() -> new RuntimeException("Department is not updated, Re-Try Again"));
//			response = ResponseUtils.successResponse(null);
			var response = new ResponseDto<String>(200,null,true,UPDATED_RESOURCE);
//			List<Department> deptList = Optional.of(deptRepo.findByDepartmentCode(deptDto.getDepartmentCode()))
//					.filter(dept -> !dept.isEmpty()).orElseThrow(() -> new DepartmentNotFoundException("No departments found"));
//			Department dept = deptList.get(0);
//			dept.setDepartmentName(deptDto.getDepartmentName());
//			dept.setModifiedBy(ComConstants.ADMIN);
//			dept.setModifiedDate(LocalDateTime.now());
//			Optional.of(deptRepo.save(dept)).orElseThrow(()-> new RuntimeException("Department is not updated, Re-Try Again"));
//			response.setMessage(ComConstants.SUCCESS);
//			response.setStatus(HttpStatus.OK.value());
//		} catch (Exception e) {
////			return exceptionHandler.handleException(e);
//			e.printStackTrace();
//		}
//		logger.info("editDepartment Service Ended");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
