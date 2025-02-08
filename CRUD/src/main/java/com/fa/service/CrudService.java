package com.fa.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.fa.dto.CrudDto;



public interface CrudService {

	public String create(HttpServletRequest req);

	public List<CrudDto> getData();

//	public String tochecklogin(HttpServletRequest req);

	public String loginvalidation(String userName, String password);

	public String edit(HttpServletRequest req);

	public String deleteByName(String name);

	

	public String upload();

	/* public String base64conversion(String base64value); */

	

}
