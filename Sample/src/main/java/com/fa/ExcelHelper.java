package com.fa;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.fa.Entity.SampleEntity;
import com.fa.Repository.SameRepository;

public class ExcelHelper {
	@Resource
	SameRepository sampleRepository;
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
  static String SHEET1 = "SampleEntity";
  public static boolean hasExcelFormat(MultipartFile file) {
    if (!TYPE.equals(file.getContentType())) {
      return false;
    }
    return true;
  }
  public static List<SampleEntity> excelToTutorials(InputStream is) {
    try {
      Workbook workbook = new XSSFWorkbook(is);
      Sheet sheet = workbook.getSheet(SHEET1);
      Iterator<Row> rows = sheet.iterator();
      List<SampleEntity> tutorials = new ArrayList<SampleEntity>();
      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();
        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }
        Iterator<Cell> cellsInRow = currentRow.iterator();
        SampleEntity tutorial = new SampleEntity();
        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();
          switch (cellIdx) {
          case 0:
            tutorial.setId((long) currentCell.getNumericCellValue());
            break;
          case 1:
            tutorial.setUserName(currentCell.getStringCellValue());
            break;
          case 2:
            tutorial.setPassword(currentCell.getStringCellValue());
            break;
          case 3:
            tutorial.setCreatedBy(currentCell.getStringCellValue());
            break;
          case 4:
        	  tutorial.setCreatedDate(currentCell.getStringCellValue());
        	break;
          case 5:
        	  tutorial.setEmpId(currentCell.getStringCellValue());
        	  break;
          default:
            break;
          }
          cellIdx++;
        }
        tutorials.add(tutorial);
      }
      workbook.close();
      return tutorials;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}