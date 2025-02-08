package com.fa.ServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

//import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;

import org.springframework.util.StringUtils;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
//import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import com.fa.ExcelHelper;
import com.fa.Dto.CommonDto;
import com.fa.Dto.SampleDto;
import com.fa.Entity.SampleEntity;
import com.fa.Repository.SameRepository;
import com.fa.Service.SampleService;



@Service
public class SampleServiceImpl implements SampleService {
	@Resource
	SameRepository sampleRepository;
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Emp Id", "UserName", "E-Mail", "CreatedBy", "CreatedDate", "Skills" };
	static String SHEET = "Tutorials";

//	@Override
//	public CommonDto save(MultipartFile file, SampleDto dto) {
//		CommonDto commonDto = new CommonDto();
//		try {
//			System.err.println("File Check : " + file.getSize());
//			if (dto != null) {
//				SampleEntity entity = new SampleEntity();
////		System.err.println(entity);
////		System.err.println(dto.getCreatedBy());
////		
//				entity.setEmpId("FAS-" + sampleRepository.getseqId());
//				entity.setUserName(dto.getUserName());
//				entity.setPassword(dto.getPassword());
//				entity.setCreatedBy(dto.getCreatedBy());
//				entity.setCreatedDate(dto.getCreatedDate());
//				entity.setEmpId("FAS-" + sampleRepository.getseqId());
//				System.err.println(entity);
//				sampleRepository.save(entity);
//				commonDto.setStatus("Success");
//			}
//			if (null != file) {
//				ByteArrayInputStream stream = new ByteArrayInputStream(file.getBytes());
//				XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
//				System.err.println(workbook.getSheetAt(0));
//				XSSFSheet sheet = workbook.getSheetAt(0);
//				List<SampleDto> dtos = new ArrayList<>();
//				for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
//					XSSFRow row = sheet.getRow(i);
//					SampleDto sampleDto = new SampleDto();
//					sampleDto.setPassword(cellValue(row, 0));
//					sampleDto.setUserName(cellValue(row, 1));
//					sampleDto.setCreatedBy(cellValue(row, 2));
//					sampleDto.setCreatedDate(cellValue(row, 3));
//					sampleDto.setEmpId(cellValue(row, 4));
//					dtos.add(sampleDto);
//				}
//				dtos.forEach(data -> {
//					SampleEntity entity = new SampleEntity();
//					entity.setUserName(data.getUserName());
//					entity.setPassword(data.getPassword());
//					entity.setCreatedBy(data.getCreatedBy());
//					entity.setCreatedDate(data.getCreatedDate());
//					entity.setEmpId(data.getEmpId());
//					entity = sampleRepository.save(entity);
//					System.err.println(entity);
//				});
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			commonDto.setStatus("Exception Occurs..");
//		}
//		return commonDto;
//	}

//	private String cellValue(Row row, int cellValue) {
//		Cell cell = row.getCell(cellValue);
//		return cell.toString();
//	}

	@Override
	public CommonDto getAllData() {
		CommonDto commonDto = new CommonDto();

		List<SampleEntity> list = sampleRepository.findAll();
		List<SampleDto> dtoList = new ArrayList<SampleDto>();
		for (SampleEntity data : list) {
			SampleDto dto = new SampleDto();

			dto.setUserName(data.getUserName());
			dto.setEmpId(data.getEmpId());
			dto.setPassword(data.getPassword());
			dto.setCreatedBy(data.getCreatedBy());
			dto.setCreatedDate(data.getCreatedDate());
			dto.setEmail(data.getEmail());
//			System.out.println(data.getSkill());
			dto.setReply(data.getSkill());
			dtoList.add(dto);
		}
		try {
			commonDto.setResponseDto(dtoList);
		} catch (Exception e) {
			e.printStackTrace();
			commonDto.setResponseData(e);
		}
		return commonDto;
	}

//@Override
//public ByteArrayInputStream load() {
//	List<SampleEntity> list = sampleRepository.findAll();
//	ByteArrayInputStream in = ExcelHelper.listToExcel(list);
//	return in;
//}

	@Override
	public List<String[]> getData() {
		List<SampleEntity> listData = sampleRepository.findAll();
		List<String[]> obj = new ArrayList<>();

		for (SampleEntity item : listData) {
			String[] objList = new String[6];
			objList[0] = item.getEmpId();
			objList[1] = item.getUserName();
			objList[2] = item.getPassword();
			objList[3] = item.getCreatedBy();
			objList[4] = item.getCreatedDate();
			obj.add(objList);
		}
		return obj;
	}

//	@Override
//	public CommonDto getExcel(SampleDto dto) {
//		CommonDto commonDto = new CommonDto();
//		try {
////		SampleDto dtoItem =new SampleDto();
//			SampleEntity data = sampleRepository.getByEmpId(dto.getEmpId());
//			commonDto.setResponseData(data);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			commonDto.setStatus("Exception Occurs");
//		}
//		return commonDto;
//	}

	@Override
	public CommonDto getPdf(SampleDto dto) {

		CommonDto commonDto = new CommonDto();
		try {
//		SampleDto dtoItem =new SampleDto();
			SampleEntity data = sampleRepository.getByEmpId(dto.getEmpId());
			commonDto.setResponseData(data);

		} catch (Exception e) {
			e.printStackTrace();
			commonDto.setStatus("Exception Occurs");
		}
		return commonDto;
	}

	@Override
	public CommonDto upload() {

		CommonDto commonDto = new CommonDto();
		try {

			String fileLocation = "/home/fasoftwares/Downloads/upload.xlsx";
			XSSFWorkbook wbook = new XSSFWorkbook(fileLocation);
			XSSFSheet sheet = wbook.getSheetAt(0);
			int lastRowNum = sheet.getLastRowNum();
			int physicalNumberofRows = sheet.getPhysicalNumberOfRows();
			System.out.println("Inclusive of header: " + physicalNumberofRows);
			System.out.println("No.of Rows: " + lastRowNum);
			short lastCellNum = sheet.getRow(0).getLastCellNum();
			System.out.println("No.of cells:" + lastCellNum);

			for (int i = 1; i <= lastRowNum; i++) {
				SampleEntity entity = new SampleEntity();
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < lastCellNum; j++) {
					XSSFCell cell = row.getCell(j);
					DataFormatter dft = new DataFormatter();
					String value = dft.formatCellValue(cell);
					/* String value=cell.getStringCellValue(); */
					/* System.err.println(value); */

					if (j == 0) {

						System.err.println("row1" + value);
						entity.setPassword(value);
					}
					if (j == 1) {

						System.err.println("row2" + value);
						entity.setUserName(value);
					}
					if (j == 2) {

						System.err.println("row3" + value);
						entity.setCreatedBy(value);
					}
					if (j == 3) {

						System.err.println("row4" + value);
						entity.setCreatedDate(value);
					}
					if (j == 4) {

						System.err.println("row5" + value);
						entity.setEmpId("FAS-" + sampleRepository.getseqId());
					}
					sampleRepository.save(entity);

				}
			}
			wbook.close();
			commonDto.setStatus("Success");
			/* } */
		} catch (Exception e) {
			e.printStackTrace();
			commonDto.setStatus("Exception Occurs");
		}
		return commonDto;
	}

	@Override
	public CommonDto saveData(SampleDto dto) {
		CommonDto commonDto = new CommonDto();
		try {
//			 Object s =   dto.getSkills().toString();	
//			System.err.println(s.toString());
			SampleEntity entity = new SampleEntity();
			SampleEntity email = sampleRepository.findByEmail(dto.getEmail());
			System.err.println(email);
			if (email != null) {
				System.err.println("True");
				commonDto.setStatus("Failed");
			} else {
				System.err.println("False");
				entity.setUserName(dto.getUserName());
				System.err.println("Password = " + dto.getPassword());
				// Getting encoder
				Base64.Encoder encoder = Base64.getEncoder();
				// Encoding string
				String str = encoder.encodeToString(dto.getPassword().getBytes());
				System.err.println(str);
				entity.setPassword(str);
				entity.setCreatedBy(dto.getCreatedBy());
				entity.setCreatedDate(dto.getCreatedDate());
				entity.setEmail(dto.getEmail());
				// For Triming String 
				StringBuffer sb = new StringBuffer();
				sb.append(dto.getSend().toString());
				StringBuffer sb2 = sb.deleteCharAt(0);
//				System.out.println(sb2);
				int len = sb2.length()-1;
//				System.out.println(len);		
				String skill = sb2.deleteCharAt(len).toString();
//				skill = skill.replaceAll("[^a-zA-Z0-9]", " ");
//				System.err.println(skill);
				entity.setSkill(skill);
				entity.setEmpId("FAS-" + sampleRepository.getseqId());
				sampleRepository.save(entity);
				commonDto.setStatus("Success");
			}
//		List<SampleEntity> emailValue = (List<SampleEntity>) sampleRepository.getEmail();
//		commonDto.setResponseDto(emailValue);
		} catch (Exception e) {
			e.printStackTrace();
			commonDto.setStatus("Exception Occurs");
		}
		return commonDto;
	}

	@Override
	public CommonDto gtDataByID(String empId) {
		CommonDto commonDto = new CommonDto();
		try {
			SampleEntity data = sampleRepository.getByEmpId(empId);
			commonDto.setResponseData(data);
		} catch (Exception e) {
			e.printStackTrace();
			commonDto.setStatus("Exception Occurs...");
		}
		return commonDto;
	}

	@Override
	public CommonDto saveEdit(SampleDto dto) {
		CommonDto commonDto = new CommonDto();

		try {
			System.err.println(dto.getEmpId());
			SampleEntity entity = sampleRepository.getByEmpId(dto.getEmpId());
			System.err.println(entity);
			entity.setUserName(dto.getUserName());
			// Getting encoder
			Base64.Encoder encoder = Base64.getEncoder();
			// Encoding string
			String str = encoder.encodeToString(dto.getPassword().getBytes());
			entity.setPassword(str);
			entity.setCreatedBy(dto.getCreatedBy());
			entity.setCreatedDate(dto.getCreatedDate());
			entity.setEmail(dto.getEmail());
			sampleRepository.save(entity);
			commonDto.setStatus("Success");

		} catch (Exception e) {
			e.printStackTrace();
			commonDto.setStatus("Exception Occurs..");
		}
		return commonDto;
	}

	@Override
	public CommonDto uploadExcelFile(MultipartFile file) {
		CommonDto commonDto = new CommonDto();
		try {
			if (file != null) {
				List<SampleEntity> entityList = sampleRepository.findAll();
				List<String> userList = new LinkedList<String>();
				for (SampleEntity entity : entityList) {
					String user = entity.getUserName();
					userList.add(user);
				}
				InputStream inputStream = file.getInputStream();
//			XSSFWorkbook wbook = new XSSFWorkbook(inputStream);
//			XSSFSheet sheet = wbook.getSheetAt(0);
//			int lastRowNum = sheet.getLastRowNum();
//			System.err.println(lastRowNum);
//			int physicalNumberofRows = sheet.getPhysicalNumberOfRows();
//			short lastCellNum = sheet.getRow(0).getLastCellNum();
//			System.err.println(lastCellNum);
//			for(int i=1; i<=lastRowNum; i++) {
//				System.err.println(i);
//				SampleEntity entity = new SampleEntity();
//				XSSFRow row = sheet.getRow(i);
////				System.err.println("Row: "+row);
//				for(int j=0; j<=lastCellNum; j++) {
//					XSSFCell cell = row.getCell(j);
//					System.err.println("cell: "+cell);
//					DataFormatter dft = new DataFormatter();
//					String value = dft.formatCellValue(cell);
//					if(userList.contains(value)) {
//						break;
//					}else {
//						if(j==0) {
//							entity.setPassword(value);
//							System.err.println("first "+value);
//						}
//						if(j==1) {
//							entity.setUserName(value);
//							System.err.println("second "+value);
//						}
//						if(j==2) {
//							entity.setCreatedBy(value);
//							System.err.println("third "+value);
//						}
//						if(j==3) {
//							entity.setCreatedDate(value);
//							System.err.println("fourth "+value);
//						}
//						if(j==4) {
//							entity.setEmail(value);
//							System.err.println("fifth "+value);
//						}
////						break;
////						entity.setEmpId("FAS-"+sampleRepository.getseqId());
//						sampleRepository.save(entity);
//					}
//				}
//			}
//			wbook.close();
//			commonDto.setStatus("Success");
				XSSFWorkbook wbook = new XSSFWorkbook(inputStream);
				XSSFSheet sheet = wbook.getSheetAt(0);
				int lastRowNum = sheet.getLastRowNum();
				int physicalNumberofRows = sheet.getPhysicalNumberOfRows();
				System.out.println("Inclusive of header: " + physicalNumberofRows);
				System.out.println("No.of Rows: " + lastRowNum);
				short lastCellNum = sheet.getRow(0).getLastCellNum();
				System.out.println("No.of cells:" + lastCellNum);

				for (int i = 1; i <= lastRowNum; i++) {
					SampleEntity entity = new SampleEntity();
					XSSFRow row = sheet.getRow(i);
					for (int j = 0; j < lastCellNum; j++) {
						XSSFCell cell = row.getCell(j);
						DataFormatter dft = new DataFormatter();
						String value = dft.formatCellValue(cell);
						/* String value=cell.getStringCellValue(); */
						/* System.err.println(value); */
						if (j == 0) {
							SampleEntity email = sampleRepository.findByEmail(value);
							if (email != null) {
								System.err.println("True");
								break;
							} else {
								System.err.println("False");
								System.err.println("row 1 " + value);
								entity.setEmail(value);
							}
						}
						if (j == 1) {

							System.err.println("row 2 " + value);
							// Getting encoder
							Base64.Encoder encoder = Base64.getEncoder();
							// Encoding string
							String str = encoder.encodeToString(value.getBytes());
							entity.setPassword(str);
						}
						if (j == 2) {

							System.err.println("row 3 " + value);
							entity.setUserName(value);
						}
						if (j == 3) {

							System.err.println("row 4 " + value);
							entity.setCreatedBy(value);
						}
						if (j == 4) {

							System.err.println("row 5 " + value);
							entity.setCreatedDate(value);
						}
						if (j == 5) {

							System.err.println("row 6 " + value);
							entity.setEmpId("FAS-" + sampleRepository.getseqId());
						}
						sampleRepository.save(entity);

					}
				}
				wbook.close();
				commonDto.setStatus("Success");
				/* } */

			}
		} catch (Exception e) {
			e.printStackTrace();
			commonDto.setStatus("Exception Occurs");
		}
		return null;
	}

	@Override
	public void pdf(SampleDto dto) {
		System.err.println("In PDF");
		String filepath = "/home/fasoftwares/sample.pdf";
		String para1 = "Hello EveryOne this is Test PDF";
		try {
			PdfWriter writer = new PdfWriter(filepath);

			PdfDocument pdfdoc = new PdfDocument(writer);
			pdfdoc.addNewPage();

			Paragraph p1 = new Paragraph(para1);

			Document document = new Document(pdfdoc);
			document.add(p1);

			document.close();
			System.err.println("PDF file has been generated Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SampleEntity> getAllEmployee() {
		return sampleRepository.findAll();
	}

	@Override
	public InputStream load(String dto) {
		SampleEntity entityList = sampleRepository.findByEmpId(dto);
		ByteArrayInputStream input = convertToExcel(entityList);
		return input;
	}

	public static ByteArrayInputStream convertToExcel(SampleEntity entity) {
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet(SHEET);
			// Header
			Row headerRow = sheet.createRow(0);
			CellStyle style = workbook.createCellStyle(); 
			Font font = workbook.createFont();
			font.setFontName("Times New Roman");
			font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
			style.setFont(font);
			style.setFillBackgroundColor(IndexedColors.LIGHT_YELLOW.index);  
        	style.setFillPattern(FillPatternType.BIG_SPOTS);  
        	   style.setBorderBottom(BorderStyle.THIN);  
        	   style.setBorderRight(BorderStyle.THIN);
        	   style.setBorderLeft(BorderStyle.THIN);
        	   style.setBorderTop(BorderStyle.THIN);
               style.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
               style.setRightBorderColor(IndexedColors.BLACK.getIndex());
               style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
               style.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
				cell.setCellStyle(style);
				sheet.autoSizeColumn(col);
			}

			
			int rowIdx = 1;

			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(entity.getEmpId());
			row.createCell(1).setCellValue(entity.getUserName());
//			row.createCell(2).setCellValue(entity.getPassword());
			row.createCell(2).setCellValue(entity.getEmail());
			row.createCell(3).setCellValue(entity.getCreatedBy());
			row.createCell(4).setCellValue(entity.getCreatedDate());
			row.createCell(5).setCellValue(entity.getSkill());
			

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	@Override
	public CommonDto exportExcel(SampleDto dto) {
		CommonDto commonDto = new CommonDto();
		try {
			System.err.println("In Excel");
			SampleEntity data = sampleRepository.findByEmpId(dto.getEmpId());
			System.err.println(data);
			String Filename = "/home/fasoftwares/sample.xlsx";
			// creating an instance of HSSFWorkbook class
			HSSFWorkbook workbook = new HSSFWorkbook();
			// invoking creatSheet() method and passing the name of the sheet to be created
			HSSFSheet sheet = workbook.createSheet("Testing");
			// creating the 0th row using the createRow() method
			HSSFRow rowhead = sheet.createRow((short) 0);
			// creating cell by using the createCell() method and setting the values to the
			// cell by using the setCellValue() method
			rowhead.createCell(0).setCellValue("Emp ID");
			rowhead.createCell(1).setCellValue("UserName");
//		rowhead.createCell(2).setCellValue("Password");  
			rowhead.createCell(2).setCellValue("E-mail");
			rowhead.createCell(3).setCellValue("Created BY");
			rowhead.createCell(4).setCellValue("Created ON");
			// creating the 1st row
			HSSFRow row = sheet.createRow((short) 1);
			// inserting data in the first row
			row.createCell(0).setCellValue(data.getEmpId());
			row.createCell(1).setCellValue(data.getUserName());
//		row.createCell(2).setCellValue(data.getPassword());  
			row.createCell(2).setCellValue(data.getEmail());
			row.createCell(3).setCellValue(data.getCreatedBy());
			row.createCell(4).setCellValue(data.getCreatedDate());
			FileOutputStream fileOut = new FileOutputStream(Filename);
			workbook.write(fileOut);
			// closing the Stream
			fileOut.close();
			// closing the workbook
			workbook.close();
			// prints the message on the console
			System.err.println("Excel file has been generated successfully.");
			commonDto.setStatus("Excel File Created Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
			commonDto.setStatus("Failed");
		}

		return commonDto;
	}

	@Override
	public CommonDto loginValidation(SampleDto dto) {
		CommonDto commonDto = new CommonDto();
		try {
			// Getting encoder
			Base64.Encoder encoder = Base64.getEncoder();
			// Encoding string
			String str = encoder.encodeToString(dto.getPassword().getBytes());
			System.err.println("Encoded string: " + str);
			System.err.println(dto);
			System.err.println(dto.getEmail());
			System.err.println(dto.getPassword());

			SampleEntity data = sampleRepository.findByEmail(dto.getEmail());
			String dec = data.getPassword();
			// Getting decoder
			Base64.Decoder decoder = Base64.getDecoder();
			// Decoding string
			String dStr = new String(decoder.decode(dec));
			System.err.println("Decoded String = " + dStr);
			System.err.println(data.getUserName());
			if (dto.getEmail().equalsIgnoreCase(data.getEmail()) && dto.getPassword().equals(dStr)) {
				commonDto.setResponseData(data);
				commonDto.setStatus("Success");
			} else {
				commonDto.setStatus("Failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			commonDto.setStatus("Failed");
		}
		return commonDto;
	}

	@Override
	public CommonDto store(MultipartFile file,String data) throws IOException {
			CommonDto commonDto = new CommonDto();
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			SampleEntity entity = new SampleEntity();
			System.err.println(data);
			try {
			     JSONObject json = new JSONObject(data);
			     entity.setCreatedBy(json.get("createdBy").toString());
			     entity.setCreatedDate(json.get("createdOn").toString());
			}catch (JSONException err){
			     err.printStackTrace();
			}
			
			entity.setFileName(fileName);
			entity.setFileType(file.getContentType());
			entity.setData(file.getBytes());
			SampleEntity data2 = sampleRepository.save(entity);
			commonDto.setResponseData(data2);
			System.err.println("File Upload Successfully");
			return commonDto;
	}

	@Override
	public SampleEntity getFile(Long id) {
		return sampleRepository.findById(id).get();
	}

//	@Override
//	public ArrayList<SampleEntity> getFiles(SampleDto dto) {
//		if(dto.getFileCreater()=="") {dto.setFileCreater(null);}
//		if(dto.getFileDate()=="") {dto.setFileDate(null);}
//		System.err.println("Data: "+dto.getFileId()+" "+dto.getFileCreater()+" "+dto.getFileDate());
//		return (ArrayList<SampleEntity>) sampleRepository.findFile(dto.getFileId(), dto.getFileCreater(), dto.getFileDate());
////		return null;
//	}

	@Override
	public ArrayList<SampleEntity> getFiles( String fcreater, String fDate) {
		if(fcreater == "") {fcreater=null;}
		if(fDate=="") {fDate=null;}
		System.err.println("Data : "+fcreater+" "+fDate);
		return sampleRepository.findFile(fcreater, fDate);
	}

	@Override
	public Stream<SampleEntity> getAllFiles() {
		return sampleRepository.findAll().stream();
	}	
}
