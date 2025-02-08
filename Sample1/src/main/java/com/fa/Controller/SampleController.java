package com.fa.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//import org.springframework.http.MediaType;

//import org.springframework.http.HttpHeaders;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.HeadersTooLargeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
//import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fa.Dto.CommonDto;
import com.fa.Dto.SampleDto;
import com.fa.Entity.SampleEntity;
import com.fa.Repository.SameRepository;
import com.fa.Service.SampleService;
import com.fa.ServiceImpl.ExcelService;
import com.fa.ServiceImpl.PDFGeneratorService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;

//import ch.qos.logback.classic.Logger;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class SampleController {

	@Resource
	SampleService sampleService;

	@Resource
	ExcelService excelService;
	@Autowired
	PDFGeneratorService pdfGeneratorService;
	@Autowired
	SameRepository sampleRepository;

//@RequestMapping(value="/save", method = RequestMethod.POST)
//public ResponseEntity<?>Save(@RequestParam(name="file") MultipartFile file, 
//		@RequestParam(name="data")String data){
//	CommonDto commonDto = new CommonDto();
//	try {
//		SampleDto dto = null;
//		if(null != data && !data.isEmpty()) {
//			dto = new ObjectMapper().readValue(data, SampleDto.class);
//		}
//		commonDto = sampleService.save(file, dto);
//	}catch (Exception e) {
//		// TODO: handle exception
//	}
//	return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
//}
	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public ResponseEntity<?> SaveData(@RequestBody SampleDto dto) {

		CommonDto commonDto = null;
		System.out.println(dto.getSend().toString());
		commonDto = sampleService.saveData(dto);
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
	public ResponseEntity<?> SaveEdit(@RequestBody SampleDto dto) {
		CommonDto commonDto = null;
		System.err.println(dto.getEmpId());
		commonDto = sampleService.saveEdit(dto);
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllData", method = RequestMethod.GET)
	public ResponseEntity<?> getAllData() {
		CommonDto commonDto = null;
		commonDto = sampleService.getAllData();
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/getDataById", method = RequestMethod.POST)
	public ResponseEntity<?> getDataById(@RequestParam(name = "empId") String empId) {
		System.err.println(empId);
		CommonDto commonDto = null;
		commonDto = sampleService.gtDataByID(empId);
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

//@RequestMapping(value="/saveAsExcel", method= RequestMethod.GET)
//public ResponseEntity<?> getFile() {
//    String filename = "tutorials.xlsx";
//    InputStreamResource file = new InputStreamResource(sampleService.load());
//    return ResponseEntity.ok()
//        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
//        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
//        .body(file);
//  }
//	

//@GetMapping(path="/saveExcel", produces ="application/json")
	@RequestMapping(value = "/saveExcel", method = RequestMethod.GET)
	public List<String[]> saveExcel() {
		return sampleService.getData();
	}

//@RequestMapping(path="/fexcel", method = RequestMethod.POST)
//public ResponseEntity<?> Excel(@RequestBody SampleDto dto ){
//	CommonDto commonDto = new CommonDto();
//	commonDto = sampleService.getExcel(dto);
//	return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
//}
	@RequestMapping(path = "/pdf", method = RequestMethod.POST)
	public ResponseEntity<?> pdf(@RequestBody SampleDto dto) {
		CommonDto commonDto = new CommonDto();
//	commonDto = sampleService.getPdf(dto);
		commonDto = excelService.pdf(dto);
//	sampleService.pdf();
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ResponseEntity<CommonDto> upload() {
		CommonDto commonDto = null;
		commonDto = sampleService.upload();
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
	public ResponseEntity<CommonDto> blukUpload(MultipartFile file) {
		CommonDto commonDto = sampleService.uploadExcelFile(file);
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ResponseEntity<CommonDto> FileUpload(MultipartFile file, String data) {
		CommonDto commonDto = new CommonDto();
//		System.err.println(data);
//	System.err.println(file);
		try {
			commonDto = sampleService.store(file, data);
			commonDto.setStatus("upload file successfully " + file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
			commonDto.setStatus("could not upload file " + file.getOriginalFilename() + "!");
		}
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public ResponseEntity<?> downloadFile(@RequestParam(name = "fileById") Long id) {
		System.err.println(id);
		SampleEntity DbFile = sampleService.getFile(id);
//	System.err.println(DbFile);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + DbFile.getFileName() + "\"")
				.body(DbFile.getData());
	}

	@RequestMapping(value = "/downloadFiles", method = RequestMethod.GET)
	public ResponseEntity<?> downloadFiles(
			@RequestParam(value = "fileCreater") String fcreater, @RequestParam(name = "fileDate") String fDate,
			HttpServletResponse response) throws HeadersTooLargeException, IOException {
//		if(fId=="") {fId = null;}
		response.setContentType("application/zip");
		response.setHeader("Content-Disposition", "attachment; filename=multiplefile.zip");
//		long FID = Long.parseLong(fId);
		List<SampleEntity> files =  sampleService.getFiles(fcreater, fDate);
		String filename=null;
		List<String> srcFiles = new LinkedList<String>();
		try {
			for(SampleEntity file: files) {
				filename = file.getFileName();
				String loc = file.getFileName();
				OutputStream out = new FileOutputStream(loc);
				byte[] data = file.getData();
				out.write(data);
//				close Output Stream
				out.close();
				srcFiles.add(loc);
			}
			ZipOutputStream  zipOut = new ZipOutputStream(response.getOutputStream());
			for(String srcFile: srcFiles) {
				File fileToZip = new File(srcFile);
				FileInputStream fis = new FileInputStream(fileToZip);
				ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
				zipOut.putNextEntry(zipEntry);
				
				byte[] bytes = new byte[1024];
				int length;
				while((length = fis.read(bytes))>=0) {
					zipOut.write(bytes,0,length);
				}
				fis.close();
			}
			zipOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

//		System.err.println(files);
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fw2.getFileName() + "\"")
//				.body(fw2.getData());
		
	}

	@RequestMapping(value = "/excel", method = RequestMethod.GET)
	public ResponseEntity<?> excel(@RequestParam(name = "EmpId") String empId) {
		String filename = "ExcelData.xlsx";
		InputStreamResource file = new InputStreamResource(sampleService.load(empId));
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}

	@RequestMapping(value = "/pdfs", method = RequestMethod.GET)
	public void pdf(@RequestParam(name = "EmpId") String empId, HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		SampleEntity en = sampleRepository.findByEmpId(empId);
		pdfGeneratorService.export(en, response);
	}

	@RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
	public ResponseEntity<?> exportExcel(@RequestBody SampleDto dto) {
		System.err.println(dto);
		CommonDto commonDto = new CommonDto();
		commonDto = sampleService.exportExcel(dto);
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}

//For LoginValidation 
	@RequestMapping(value = "/loginValidation", method = RequestMethod.POST)
	public ResponseEntity<?> loginValidation(@RequestBody SampleDto dto) {
		System.err.println(dto);
		CommonDto commonDto = new CommonDto();
		commonDto = sampleService.loginValidation(dto);
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/emailGeneration", method=RequestMethod.POST)
	public ResponseEntity<?> emailGeneration(@RequestBody SampleDto dto){
		CommonDto commonDto = new CommonDto();
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}
	
}
