package com.fa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.dto.AddressDto;
import com.fa.dto.CommonDto;
import com.fa.dto.RelationDto;
import com.fa.entity.AddressEntity;
import com.fa.entity.RelationEntity;
import com.fa.repository.RelationRepository;
import com.fa.service.RelationService;

@Service
public class RelationServiceimpl implements RelationService {

	@Autowired
	RelationRepository relationRepository;

	@Override
	public CommonDto<?> save(RelationDto dto) {
		CommonDto<?> response = new CommonDto<>();

		RelationEntity entity = new RelationEntity();
		entity.setName(dto.getName());
		entity.setMobile(dto.getMobile());

		List<AddressEntity> address = new ArrayList<AddressEntity>();
		List<AddressDto> aDto = dto.getAddress();

		for (AddressDto ad : aDto) {
			AddressEntity en = new AddressEntity();
			en.setAddress(ad.getAddress());
			en.setCity(ad.getCity());
			en.setPincode(ad.getPincode());
			en.setRelation(entity);
			address.add(en);
		}
		entity.setAddress(address);
		relationRepository.save(entity);
		response.setStatus("Success");

		return response;
	}

	@Override
	public CommonDto<List<RelationDto>> view() {
		CommonDto<List<RelationDto>> response = new CommonDto<>();

		List<RelationDto> dto = new ArrayList<RelationDto>();
		List<RelationEntity> list = relationRepository.findAll();

		for (RelationEntity en : list) {
			RelationDto rel = new RelationDto();
			rel.setId(String.valueOf(en.getId()));
			rel.setName(en.getName());
			rel.setMobile(en.getMobile());
			List<AddressEntity> add = en.getAddress();
			List<AddressDto> a = new ArrayList<AddressDto>();
			for (AddressEntity aa : add) {
				AddressDto ad = new AddressDto();
				ad.setId(String.valueOf(aa.getId()));
				ad.setAddress(aa.getAddress());
				ad.setCity(aa.getCity());
				ad.setPincode(aa.getPincode());
				a.add(ad);
			}
			rel.setAddress(a);
			dto.add(rel);
		}
		response.setResponseData(dto);

		return response;
	}

}
