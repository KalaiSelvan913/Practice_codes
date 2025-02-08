package com.fa.serviceimpl.ng;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fa.dto.ng.CommonDto;
import com.fa.dto.ng.CrudNgDto;
import com.fa.entity.ng.CrudNgEntity;
import com.fa.repository.ng.CrudNgRepository;
import com.fa.repository.ng.LoginNgRepository;
import com.fa.service.ng.CrudNgService;


@Service
public class CrudNgServiceImpl implements CrudNgService {
	
	@Resource
	CrudNgRepository crudNgRepository;
	
	@Resource
	LoginNgRepository loginNgRepository;
	
	

	@Override
	public CommonDto save(CrudNgDto dto) {							// Save Data API

		CommonDto commonDto = new CommonDto();

		try {
				CrudNgEntity entity = new CrudNgEntity();
				entity.setEmpid("FAS-"+crudNgRepository.getEmpId());				
				entity.setName(dto.getName());
				entity.setPhone(dto.getPhone());
				entity.setEmail(dto.getEmail());
				entity.setDob(dto.getDob());
				entity.setGender(dto.getGender());
				entity.setTeam(dto.getTeam());
		
               //Saving Data in entity
				crudNgRepository.save(entity);
				
				commonDto.setStatus("Success");
				
		} catch (Exception e) {

			e.printStackTrace();
			commonDto.setStatus("Exception Occurs...");
		
		}

		return commonDto;
	}
	
	
	

	@Override
	public CommonDto getAllData() {									// Get Data API				
		CommonDto commonDto = new CommonDto();
		
																		
		List<CrudNgEntity> list = crudNgRepository.findAll();		// Getting Data From Server through Entity
																		 		
		List<CrudNgDto> dtoList = new ArrayList<CrudNgDto>();		//     Creating DtoArrayList
																		
		for(CrudNgEntity data: list) {					// Iterating by Entity list to set in DtoObject
			CrudNgDto dto = new CrudNgDto();
			dto.setEmpid(data.getEmpid());
			dto.setName(data.getName());
			dto.setPhone(data.getPhone());
			dto.setEmail(data.getEmail());
			dto.setDob(data.getDob());
			dto.setGender(data.getGender());
			dto.setTeam(data.getTeam());
															//Add DtoObject to DtoList
			dtoList.add(dto);
		}
		
		try {
			commonDto.setResponseDto(dtoList);
		}catch (Exception e) {
			commonDto.setResponsedata(e);
		}
		return commonDto;
	}
	

	@Override
	public CommonDto edit(CrudNgDto dto) {                                   //	Edit Data API
		
		CommonDto commonDto = new CommonDto();
		try {
		CrudNgEntity enter = crudNgRepository.getDataByName(dto.getName());  //Get Data By Name
		
		enter.setEmail(dto.getEmail());
		enter.setPhone(dto.getPhone());
		enter.setDob(dto.getDob());
		enter.setGender(dto.getGender());
		enter.setTeam(dto.getTeam());
		
		crudNgRepository.save(enter);
		
		commonDto.setStatus("Success");
		}catch (Exception e) {
			
			e.printStackTrace();
			
			commonDto.setStatus("Exception Occurs..");
		}
		return commonDto;
	}


	@Override
	public CommonDto deleteByName(CrudNgDto dto) {						//Delete Data API
		
		CommonDto commonDto = new CommonDto();
		
		try {
			//Getting Particular ID by Name Using Native Query
			Long id = crudNgRepository.getIdByName(dto.getName());
			
			crudNgRepository.deleteById(id);
			
			commonDto.setStatus(dto.getName()+" Record is Deleted");
			
		}catch (Exception e) {
			e.printStackTrace();
			commonDto.setStatus("Exception Occurs...");
		}
		return commonDto;
	}

//	@Override
//	public CommonDto savePassword(CrudNgDto dto) {
//		
//		CommonDto commonDto = new CommonDto();
//		
//		try {
//			
//			
//			System.err.println(dto.getEmail());
//			System.err.println(dto.getPassword());
//			
//			
//			CrudNgEntity enter = crudNgRepository.getDataByEmail(dto.getEmail());
//			
//			System.err.println(enter);
////			enter.getPassword(dto.get)
//			
//			enter.setPassword(dto.getPassword());
//			
//			crudNgRepository.save(enter);
//			System.err.println("Password Saved....");
//			
//			commonDto.setStatus("Success");
//			
//			
//				
//		}catch (Exception e) {
//			e.printStackTrace();
//			
//			commonDto.setStatus("Exception Occurs....");
//		}
//		
//		return commonDto;	
//	}

	
     
	@Override
	public CommonDto loginValidation(CrudNgDto dto) {						//	LoginValidation
		
		CommonDto commonDto = new CommonDto();
		
		try {
			System.err.println(dto);
			System.err.println(dto.getUsername());
			System.err.println(dto.getPassword());
			if(dto.getUsername().equalsIgnoreCase(loginNgRepository.getName(dto.getUsername())) 
					&& dto.getPassword().equalsIgnoreCase(loginNgRepository.getPasswordValue(dto.getUsername()))){
				commonDto.setStatus("Success");
				System.err.println("Login Success");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			commonDto.setStatus("Exception");
		}
		
		return commonDto;
	}

	@Override
	public CommonDto findByName(String name) {
		CommonDto commonDto = new CommonDto();
		try {
			CrudNgEntity entry = crudNgRepository.getDataByName(name);
			commonDto.setResponsedata(entry);
		}catch (Exception e) {
			e.printStackTrace();
			commonDto.setResponsedata(null);
		}
		return commonDto;
	}

}
