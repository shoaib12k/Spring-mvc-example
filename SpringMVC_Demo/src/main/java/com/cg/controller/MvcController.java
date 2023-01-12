package com.cg.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/front-controller")
public class MvcController {

	@RequestMapping("/index")
	public String index() {
		System.out.println("Index handler called");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/welcome/{id}")
	public String welcome(@PathVariable("id")String id) {
		return "Welcome"+id;
	}
	
	@RequestMapping("/student-form")
	public ModelAndView getStudForm() {
		ModelAndView mv = new ModelAndView("studentForm");
		return mv;
	}
	
	@RequestMapping(value="/submit-form")
	public ModelAndView submitFrom(@RequestParam("stuName") String stuName, @RequestParam("subject") String subject) {
		ModelAndView mv = new ModelAndView("submitForm");
		mv.addObject("studData", stuName+" "+subject);
		return mv;
	}
	
	
}
