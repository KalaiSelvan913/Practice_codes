package com.fa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fa.dto.CrudDto;
import com.fa.service.CrudService;


@Controller
public class CrudController {
	
	@Resource
	CrudService crudService;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res) {
	ModelAndView mvc = new ModelAndView("Login");
	return mvc;
	}
	
	
	
	/*
	 * @RequestMapping(value="/action",method= RequestMethod.POST) public
	 * ModelAndView save(HttpServletRequest req, HttpServletResponse res){
	 * ModelAndView mv = new ModelAndView("creation"); String str=""; str =
	 * crudService.create(req); mv.addObject("result", str); return mv; }
	 */
	
	@RequestMapping(value="/action", method=RequestMethod.POST)
	public ResponseEntity<String> save(HttpServletRequest req, HttpServletResponse res) {
		String s = crudService.create(req);
		System.err.println(s);
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public ModelAndView getData() {
		ModelAndView mv = new ModelAndView("view");
		List<CrudDto> dto = crudService.getData();
		
		mv.addObject("data", dto);
		return mv;
	}
	
	@RequestMapping(value="/creation", method=RequestMethod.GET)
	public String creation(HttpServletRequest req, HttpServletResponse res) {
		return "creation";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(HttpServletRequest req, HttpServletResponse res) {
		return "index";
	}
	
	@RequestMapping(value="/showindex", method=RequestMethod.GET)
	public String showindex(HttpServletRequest req, HttpServletResponse res) {
		return "showindex";
	}
	
	/*
	 * @RequestMapping(value="/base64conversion", method=RequestMethod.POST) public
	 * ResponseEntity<String> base64conversion(@RequestParam("base64value") String
	 * base64value) { String result = crudService.base64conversion(base64value);
	 * System.err.println(result); return new ResponseEntity<String>(result,
	 * HttpStatus.OK); }
	 */

	@RequestMapping(value="/base64", method=RequestMethod.GET)
	public String base64(HttpServletRequest req, HttpServletResponse res) {
		return "base64conversion";
	}
//	@RequestMapping(value = "/checklogin", method = RequestMethod.GET)
//	public String checklogin(HttpServletRequest req, HttpServletResponse res) {
//		String s = crudService.tochecklogin(req);
//		if (s.equalsIgnoreCase("success")) {
//			return "index";
//		}
//		return "Login";
//	}
	@RequestMapping(value = "/loginValidation", method = RequestMethod.POST)
	public ResponseEntity<String> checklogin(@RequestParam("userName") String userName,@RequestParam("password") String password) {
		String s = crudService.loginvalidation(userName,password);
		System.err.println(s);
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}

	
	@RequestMapping(value="/datatable", method=RequestMethod.GET)
	public ModelAndView getDataTable(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("datatable");
		
		return mv;
	}
	
	
	@RequestMapping(value = "/getAllData", method = RequestMethod.GET)
	public ResponseEntity<List<CrudDto>> GetData() {
	  List<CrudDto> dto = crudService.getData();
		return new ResponseEntity<List<CrudDto>>(dto, HttpStatus.OK);
	}

	@RequestMapping(value="/sample", method=RequestMethod.GET)
	public ModelAndView sample(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("sample");
		
		return mv;
	}
	
	@RequestMapping(value="/sample1", method=RequestMethod.GET)
	public ModelAndView sample1(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("sample1");
		
		return mv;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(HttpServletRequest req, HttpServletResponse res) {
		return "edit";
	}
	
	@RequestMapping(value="/edit1", method=RequestMethod.GET)
	public ModelAndView edit1(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("edit");
		String str1="";
		str1= crudService.edit(req);
		
		return mv;
	}
	
	@RequestMapping(value="/viewpdf", method=RequestMethod.GET)
	public ModelAndView tablepdf() {
		ModelAndView mv = new ModelAndView("tablepdf");
		List<CrudDto> dto = crudService.getData();
		
		mv.addObject("data", dto);
		return mv;
	}
	
	@RequestMapping(value="/html", method=RequestMethod.GET)
	public ModelAndView htmltable() {
		ModelAndView mv = new ModelAndView("htmltable");
		List<CrudDto> dto = crudService.getData();
		
		mv.addObject("data", dto);
		return mv;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(HttpServletRequest req, HttpServletResponse res) {
		return "index";
	}
	
	
	@RequestMapping(value = "/deleteByName", method = RequestMethod.GET)
	public ResponseEntity<String> deleteByName(@RequestParam("userName") String name) {
	  String result = crudService.deleteByName(name);
	  System.err.println(result);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public String login(HttpServletRequest req, HttpServletResponse res) {
//		
//		return "Login";
//	}
//	
//	@RequestMapping(value="/action", method=RequestMethod.GET)
//	public String action(HttpServletRequest req, HttpServletResponse res) {
//		return "action";
//	}
	

	
	  @RequestMapping(value = "/upload", method = RequestMethod.GET)
	  public ResponseEntity<String> upload() { 
		  String result = crudService.upload();
	  System.err.println(result); 
	  return new ResponseEntity<String>(result,HttpStatus.OK); 
	  }
	 
	
	/*
	 * @RequestMapping(value = "/upload", method = RequestMethod.GET) public
	 * ResponseEntity<String> uploadFile(@RequestParam("filexlsx") MultipartFile
	 * file) { String message = ""; System.err.println("on Upload Controller");
	 * message = crudService.upload(file);
	 */
	/* return new ResponseEntity<String>(message,HttpStatus.OK); */


	
}
