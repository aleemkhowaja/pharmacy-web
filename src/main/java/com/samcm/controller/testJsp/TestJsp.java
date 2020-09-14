package com.samcm.controller.testJsp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/TestJsp")
public class TestJsp
{
    @RequestMapping(value="/test", method=RequestMethod.GET)
    public ModelAndView testjsp(HttpServletRequest request) {
	
	ModelAndView model = new ModelAndView();
	model.setViewName("test");
	return model;
    }
}
