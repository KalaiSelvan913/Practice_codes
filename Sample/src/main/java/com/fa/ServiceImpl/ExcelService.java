package com.fa.ServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.fa.ExcelHelper;
import com.fa.Dto.CommonDto;
import com.fa.Dto.SampleDto;
import com.fa.Entity.SampleEntity;
import com.fa.Repository.SameRepository;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.layer.PdfLayer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelService {
	@Autowired
	SameRepository sampleRepository;
  public void save(MultipartFile file) {
    try {
      List<SampleEntity> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
      sampleRepository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }
  public List<SampleEntity> getAllTutorials() {
    return sampleRepository.findAll();
  }
  
  
public CommonDto pdf(SampleDto dto) {
	CommonDto commonDto = new CommonDto();
	SampleEntity data = sampleRepository.getByEmpId(dto.getEmpId());
	System.err.println("In PDF");
	String filepath = "/home/fasoftwares/sample.pdf";
//	String para1 = "Hello EveryOne this is Test PDF";
	try {
	PdfWriter writer=new PdfWriter(filepath);
	
	PdfDocument pdfdoc=new PdfDocument(writer);
	pdfdoc.addNewPage();
	
//	Paragraph p1 = new Paragraph(para1);
	// Creating a table       
    float [] pointColumnWidths = {1.5f, 3.5f, 3.0f, 3.0f, 1.5f,};   
    Table table = new Table(pointColumnWidths);
    table.setWidthPercent(100f);
    
    // Adding cells to the table  
    Cell c1 = new Cell();
    table.addCell(c1.add("Emp ID"));  
    c1.setBackgroundColor(Color.DARK_GRAY);
    c1.setFontColor(Color.WHITE);
    c1.setTextAlignment(TextAlignment.CENTER);
    // Cell 2
    Cell c2 = new Cell();
    table.addCell(c2.add("UserName")); 
    c2.setBackgroundColor(Color.DARK_GRAY);
    c2.setFontColor(Color.WHITE);
    c2.setTextAlignment(TextAlignment.CENTER);
//    //Cell 3
//    Cell c3 = new Cell();
//    table.addCell(c3.add("Password"));
//    c3.setBackgroundColor(Color.DARK_GRAY);
//    c3.setFontColor(Color.WHITE);
//    c3.setTextAlignment(TextAlignment.CENTER);
    //Cell 3
    Cell c4 = new Cell();
    table.addCell(c4.add("Email"));
    c4.setBackgroundColor(Color.DARK_GRAY);
    c4.setFontColor(Color.WHITE);
    c4.setTextAlignment(TextAlignment.CENTER);
    //Cell 4
    Cell c5 = new Cell();
    table.addCell(c5.add("Created By"));
    c5.setBackgroundColor(Color.DARK_GRAY);
    c5.setFontColor(Color.WHITE);
    c5.setTextAlignment(TextAlignment.CENTER);
    //Cell 5
    Cell c6 = new Cell();
    table.addCell(c6.add("Created Date"));
    c6.setBackgroundColor(Color.DARK_GRAY);
    c6.setTextAlignment(TextAlignment.CENTER);
    c6.setFontColor(Color.WHITE);
    table.addCell((new Cell().add(data.getEmpId())).setTextAlignment(TextAlignment.CENTER));
    table.addCell((new Cell().add(data.getUserName())).setTextAlignment(TextAlignment.CENTER));
//    table.addCell((new Cell().add(data.getPassword())).setTextAlignment(TextAlignment.CENTER));
    table.addCell((new Cell().add(data.getEmail())).setTextAlignment(TextAlignment.CENTER));       
    table.addCell((new Cell().add(data.getCreatedBy())).setTextAlignment(TextAlignment.CENTER));
    table.addCell((new Cell().add(data.getCreatedDate())).setTextAlignment(TextAlignment.CENTER));
	
	Document document=new Document(pdfdoc);
//	document.add(p1);
	 // Adding Table to document        
    document.add(table); 
	
	document.close();
	System.err.println("PDF file has been Generated Successfully");
	commonDto.setStatus("Success");
	}catch (Exception e) {
		e.printStackTrace();
		commonDto.setStatus("Failed");
	}
	return commonDto;
}

public InputStream load(String dto) {
	SampleEntity entityList = sampleRepository.findByEmpId(dto);
	ByteArrayInputStream input = convertToPdf(entityList);
	return input;
}
public static ByteArrayInputStream convertToPdf(SampleEntity entity) {
	try {
//		return new ByteArrayInputStream(out.toByteArray());
		return null;
	} catch (Exception e) {
		throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	}
}


}
