package com.kalaiselvan.springbootsecurity.service.impl;

import static com.kalaiselvan.springbootsecurity.constants.ComConstants.ADMIN;
import static com.kalaiselvan.springbootsecurity.constants.ComConstants.DELETE_RESOURCE;
import static com.kalaiselvan.springbootsecurity.constants.ComConstants.SUCCESS;
import static com.kalaiselvan.springbootsecurity.constants.ComConstants.UPDATED_RESOURCE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kalaiselvan.springbootsecurity.dto.DepartmentDto;
import com.kalaiselvan.springbootsecurity.dto.EmpDto;
import com.kalaiselvan.springbootsecurity.dto.ResponseDto;
import com.kalaiselvan.springbootsecurity.dto.RolesDto;
import com.kalaiselvan.springbootsecurity.dto.response.EmployeeResponseDto;
import com.kalaiselvan.springbootsecurity.entity.Employee;
//import com.kalaiselvan.springbootsecurity.entity.Sequence.SeqGenerator;
//import com.kalaiselvan.springbootsecurity.entity.Sequence.SequenceConstants;
import com.kalaiselvan.springbootsecurity.exception.DepartmentNotFoundException;
import com.kalaiselvan.springbootsecurity.exception.EmployeeNotFoundException;
import com.kalaiselvan.springbootsecurity.mapping.GenericMapping;
import com.kalaiselvan.springbootsecurity.repository.DepartmentRepo;
import com.kalaiselvan.springbootsecurity.repository.EmployeeRepo;
import com.kalaiselvan.springbootsecurity.repository.RoleRepo;
import com.kalaiselvan.springbootsecurity.service.EmployeeService;
import com.kalaiselvan.springbootsecurity.utils.ComUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

//	private final SeqGenerator seqGenerator;

	private final EmployeeRepo empRepo;

	private final GenericMapping mapper;

	private final DepartmentRepo deptRepo;

	private final RoleRepo roleRepo;

	@Override
	public ResponseEntity<ResponseDto<List<EmployeeResponseDto>>> addEmployee(List<EmpDto> empList) {
		logger.info("addEmployee service started");
//		ResponseDto<List<EmployeeResponseDto>> response = new ResponseDto<>();
//		try {
			var employees = empList.stream().map(dto -> {
				Employee employee = mapper.map(dto, Employee.class);
//				employee.setEmpCode(seqGenerator.generateSeqCode(SequenceConstants.EMPLOYEE_CODE));
				employee.setDepartment(deptRepo.findById(dto.getDepartmentId())
						.orElseThrow(() -> new DepartmentNotFoundException("Department Id not found")));
				employee.setRoles(dto.getRoles().stream()
						.map(roleId -> Optional.of(roleRepo.findByRoleCode(roleId))
								.orElseThrow(() -> new RuntimeException("Role not found")))
						.collect(Collectors.toSet()));
				employee.setCreatedBy(ADMIN);
				employee.setCreatedDate(LocalDate.now());
				employee.setLastModifiedBy(ADMIN);
				employee.setLastModifiedDate(LocalDateTime.now());
				return employee;
			}).collect(Collectors.toList());

			empRepo.saveAll(employees);
			var collect = employees.stream()
					.map(emp -> {
						EmployeeResponseDto empDto = mapper.map(emp, EmployeeResponseDto.class);
						empDto.setRoles(mapper.mapAll(emp.getRoles(), RolesDto.class).stream()
								.collect(Collectors.toSet()));;
						return empDto;
						}).collect(Collectors.toList());

		logger.info("addEmployee service ended");
		var response = new ResponseDto<List<EmployeeResponseDto>>(200,collect,true,SUCCESS);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto<Page<EmployeeResponseDto>>> getAllEmployee(int page, int size, String[] sort) {
		logger.info("getAllEmployee service started");
//		ResponseDto<Page<EmployeeResponseDto>> response = new ResponseDto<>(); 	
//		try {
			Sort sorts = ComUtils.parseSortParams(sort);
			Pageable pageable = PageRequest.of(page, size, sorts);
			Page<Employee> empList = Optional.of(empRepo.findAll(pageable))
					.orElseThrow(() -> new EmployeeNotFoundException("Employee Detail Not Found"));
			Page<EmployeeResponseDto> empDtoList = empList.map(emp -> {
                EmployeeResponseDto empDto = mapper.map(emp, EmployeeResponseDto.class);
                empDto.setRoles(emp.getRoles().stream()
                        .map(role -> mapper.map(role, RolesDto.class))
                        .collect(Collectors.toSet()));
                empDto.setDepartment(mapper.map(emp.getDepartment(), DepartmentDto.class));
                return empDto;
            });
			var response = new ResponseDto<Page<EmployeeResponseDto>>(200, empDtoList,true,SUCCESS);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		logger.info("getAllEmployee service ended");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto<EmpDto>> getEmployeeById(Long id) {
		logger.info("getEmployeeById service started");
//		ResponseDto<EmpDto> response = new ResponseDto<>();
//		try {
			var empDetail = Optional.of(empRepo.findById(id))
					.orElseThrow(() -> new EmployeeNotFoundException("Employee Code not found"));
			var response = new ResponseDto<EmpDto>( 200, mapper.map(empDetail, EmpDto.class),true,SUCCESS);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		logger.info("getEmployeeById service ended");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<ResponseDto<String>> deleteEmployee(Long id) {
		logger.info("deleteEmployee service started");
//		ResponseDto<String> response = new ResponseDto<>();
//		try {
			empRepo.deleteById(id);
//			response = ResponseUtils.successResponse(null);
			var response = new ResponseDto<String>(204, null,true,DELETE_RESOURCE);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		logger.info("deleteEmployee service ended");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto<List<EmployeeResponseDto>>> updateEmployee(List<EmpDto> empDtoList) {
		logger.info("updateEmployee service started");
//		ResponseDto<List<EmployeeResponseDto>> response = new ResponseDto<>();
//		try {
		List<Employee> empList = empDtoList.stream().map(e ->{
			Employee emp = empRepo.findByEmpCode(e.getEmpCode());
			emp.setFirstName(e.getFirstName());
			emp.setLastName(e.getLastName());
			emp.setDateOfBirth(e.getDateOfBirth());
			emp.setGender(e.getGender());
			emp.setEmail(e.getEmail());
			emp.setPhoneNumber(e.getPhoneNumber());
			emp.setHireDate(e.getHireDate());
			emp.setSalary(e.getSalary());
			emp.setStatus(e.getStatus());
			emp.setDepartment(e.getDepartmentId() == emp.getDepartment().getId() ? emp.getDepartment() 
					: deptRepo.findById(e.getDepartmentId()).orElseThrow(() -> new DepartmentNotFoundException("Department Id not found")));
			emp.setRoles(roleRepo.findByRoleCodeIn(e.getRoles()));
			return emp;
		}).filter(Objects::nonNull).collect(Collectors.toList());

			var empResponseDto = Optional.of(empRepo.saveAll(empList))
					.orElseThrow(() -> new EmployeeNotFoundException("There is a problem, Try-Again")).stream()
					.map(emp -> {
						EmployeeResponseDto empDto = mapper.map(emp, EmployeeResponseDto.class);
						empDto.setRoles(mapper.mapAll(emp.getRoles(), RolesDto.class)
								.stream().collect(Collectors.toSet()));
						return empDto;
					}).collect(Collectors.toList());
			var response = new ResponseDto<List<EmployeeResponseDto>>(200,empResponseDto,true,UPDATED_RESOURCE);
//			response = ResponseUtils.successResponse(empResponseDto);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		logger.info("updateEmployee service ended");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
