package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloBootController {
	@RequestMapping("/helloboot")
	ModelAndView helloboot(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("model","스프링부트를 시작합니다." );
		mv.setViewName("helloboot"); //  WEB-INF/views/hello.jsp
		return mv;
	}
	
	@RequestMapping("helloajax")
	@ResponseBody
	public String helloajax() {
		return "{\"model\" : \"스프링부트 ajax\" }";  //자바객체 - JSON, 
	}
}

