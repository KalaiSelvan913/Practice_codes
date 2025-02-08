package com.fa.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;



import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;


import com.fa.entity.*;
import com.fa.dto.CrudDto;
import com.fa.entity.CrudEntity;
import com.fa.repository.CrudRepository;
import com.fa.repository.LoginRepository;
import com.fa.service.CrudService;

@Service
public class CrudServiceImpl implements CrudService {

	@Resource
	CrudRepository crudRepository;

	@Resource
	LoginRepository loginRepository;

	@Override
	public String create(HttpServletRequest req) {

		String result = "";

		try {

			if (!String.valueOf(req.getParameter("name")).equalsIgnoreCase("")
					&& !String.valueOf(req.getParameter("phone")).equalsIgnoreCase(" ")
					&& !String.valueOf(req.getParameter("companyName")).equalsIgnoreCase(" ")
					&& !String.valueOf(req.getParameter("dob")).equalsIgnoreCase(" ")
					&& !String.valueOf(req.getParameter("experience")).equalsIgnoreCase(" ")
					&& !String.valueOf(req.getParameter("team")).equalsIgnoreCase(" ")
					&& !String.valueOf(req.getParameter("gender")).equalsIgnoreCase(" ")
					&& !String.valueOf(req.getParameter("base64value")).equalsIgnoreCase(" ")) {

				CrudEntity entity = new CrudEntity();
				entity.setName(req.getParameter("name"));
				entity.setPhone(req.getParameter("phone"));
				entity.setDob(req.getParameter("dob"));
				entity.setCompanyName(req.getParameter("companyName"));
				entity.setTeam(req.getParameter("team"));
				entity.setGender(req.getParameter("gender"));
				entity.setPre_exp(req.getParameter("experience"));
				entity.setBase64Value(req.getParameter("base64value"));

				crudRepository.save(entity);
				result = "Saved Successfully";

			}
		} catch (Exception e) {

			e.printStackTrace();
			result = "Exception";
		}

		return result;
	}

	@Override
	public List<CrudDto> getData() {
		List<CrudEntity> list = crudRepository.findAll();
		List<CrudDto> dtolist = new ArrayList<>();
		for (CrudEntity itr : list) {
			CrudDto dto = new CrudDto();
			dto.setName(itr.getName());
			dto.setPhone(itr.getPhone());
			dto.setDob(itr.getDob());		
			dto.setCompanyName(itr.getCompanyName());
			dto.setTeam(itr.getTeam());
			dto.setGender(itr.getGender());
			dto.setPre_exp(itr.getPre_exp());
			dtolist.add(dto);

		}
		return dtolist;
	}

//	@Override
//	public String tochecklogin(HttpServletRequest req) {
//		List<LoginEntity> l = loginRepository.getdata();
//		System.err.println(l);
//		String out = "";
//
//		for (LoginEntity e : l) {
//			if (req.getParameter("username").equalsIgnoreCase(e.getUsername())
//					&& req.getParameter("password").equalsIgnoreCase(e.getPassword())) {
//				out = "success";
//				break;
//			} else {
//				out = "failed";
//			}
//		}
//		return out;
//		
//	}

	@Override
	public String loginvalidation(String userName, String password) {

		String result = "";
		if (userName.equalsIgnoreCase(loginRepository.getName(userName))
				&& password.equalsIgnoreCase(loginRepository.getPassword(userName))) {
			result = "login successfull";
		} else {
			result = "Invalid Credentials";
		}

		return result;

	}

	@Override
	public String edit(HttpServletRequest req) {

		CrudEntity enter = crudRepository.getDataByName(req.getParameter("name"));
		enter.setPhone(req.getParameter("phone"));
		enter.setGender(req.getParameter("gender"));
		enter.setTeam(req.getParameter("team"));
		enter.setDob(req.getParameter("dob"));
		enter.setCompanyName(req.getParameter("companyName"));
		enter.setPre_exp(req.getParameter("exp"));

		crudRepository.save(enter);

		return null;
	}

	@Override
	public String deleteByName(String name) {

		String result = "";

		Long en = crudRepository.getIdByName(name);

		crudRepository.deleteById(en);

		result = name + " Record is Deleted!";

		return result;

	}

	@Override
	public String upload() {
		
		String result = "";
		try {

			String fileLocation="/home/fasoftwares/Downloads/upload.xlsx";
			XSSFWorkbook wbook =new XSSFWorkbook (fileLocation);
			XSSFSheet sheet=wbook.getSheetAt (0);
			int lastRowNum = sheet.getLastRowNum ();
			int physicalNumberofRows = sheet.getPhysicalNumberOfRows ();
			System.out.println("Inclusive of header: "+ physicalNumberofRows);
			System.out.println("No.of Rows: "+ lastRowNum);
			short lastCellNum=sheet.getRow(0).getLastCellNum();
			System.out.println("No.of cells:"+lastCellNum);
			
			for (int i=1;i<=lastRowNum; i++){
				LoginEntity entity = new LoginEntity();
			    XSSFRow row=sheet.getRow(i);
			    for (int j=0; j< lastCellNum; j++){
			        XSSFCell cell=row.getCell(j);
			        DataFormatter dft=new DataFormatter();
			        String value=dft.formatCellValue(cell);
					/* String value=cell.getStringCellValue(); */
					/* System.err.println(value); */
			        
			        if(j==0) {
			        	
			        	System.err.println("row1"+value);
			        	entity.setPassword(value);
			        }
			        if(j==1) {
			        	
			        	System.err.println("row2"+value);
			        	entity.setUsername(value);
			        }
			        loginRepository.save(entity);
			    

			    }
			}
			/*for (Row row : sheet) // iteration over row using for each loop
			{
//				System.err.println(row);
				for (Cell cell : row) // iteration over cell using for each loop
				{
//					System.err.println(cell);
					switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
					case Cell.CELL_TYPE_NUMERIC: // field that represents numeric cell type
						// getting the value of the cell as a number
//						System.err.println("numeric");
						System.out.print("numeric "+cell.getNumericCellValue() + "\n");
						break;
					case Cell.CELL_TYPE_STRING: // field that represents string cell type
						// getting the value of the cell as a string
//						System.err.println("str");
						System.out.print("str "+cell.getStringCellValue() + "\n");
						break;
					}
				}*/
				wbook.close();
				result = "success";
				/* } */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * @Override public String base64conversion(String base64value) { String result
	 * = "";
	 * 
	 * if(!base64value.equalsIgnoreCase(" ")) { CrudEntity ent = new CrudEntity();
	 * ent.setBase64Value(base64value); crudRepository.save(ent);
	 * 
	 * result = "base64values Save Successfully"; }else { result = "empt"; }
	 * 
	 * return result; } String value=cell.getStringCellValue(); 
	 */

}
