package com.fa.Service;

//import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.fa.Dto.CommonDto;
import com.fa.Dto.SampleDto;
import com.fa.Entity.SampleEntity;
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public interface SampleService {

//	CommonDto save(MultipartFile file, SampleDto dto);

	CommonDto getAllData();

//	ByteArrayInputStream load();

	List<String[]> getData();

//	CommonDto getExcel(SampleDto dto);

	CommonDto getPdf(SampleDto dto);

	CommonDto upload();

	CommonDto gtDataByID(String empId);

	CommonDto saveData(SampleDto dto);

	CommonDto saveEdit(SampleDto dto);

	CommonDto uploadExcelFile(MultipartFile file);

	void pdf(SampleDto dto);

	public List<SampleEntity> getAllEmployee();

	InputStream load(String dto);

	CommonDto exportExcel(SampleDto dto);

	CommonDto loginValidation(SampleDto dto);

	CommonDto store(MultipartFile file, String data) throws IOException;

	SampleEntity getFile(Long id);
	
//	public ArrayList<SampleEntity> getFiles(SampleDto dto);

	ArrayList<SampleEntity> getFiles(String fcreater, String fDate);

//	void export(HttpServletResponse response);
	
	Stream<SampleEntity> getAllFiles();

	

	
}
