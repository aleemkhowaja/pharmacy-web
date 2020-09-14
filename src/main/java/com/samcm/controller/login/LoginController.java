package com.samcm.controller.login;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.samcm.dto.user.RequestUserDTO;

@Controller
@RequestMapping
public class LoginController
{
    /**
     * return login page
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/login.htm", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView returnLoginPage(@RequestParam(value = "error", required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request)
    {
	String ip = request.getLocalAddr();

	Map<String, String> result = new HashMap<>();

	/*
	 * Enumeration headerNames = request.getHeaderNames(); while
	 * (headerNames.hasMoreElements()) { String key = (String)
	 * headerNames.nextElement(); String value = request.getHeader(key);
	 * System.out.println(key+" ++++++++++"+value); }
	 */

	System.out.println("ip:::" + ip);
	ModelAndView model = new ModelAndView();
	if(error != null)
	{
	    model.addObject("error", "Invalid username and password!");
	}

	if(logout != null)
	{
	    model.addObject("msg", "You've been logged out successfully.");
	}
	model.addObject("login", new RequestUserDTO());
	model.setViewName("LoginPage");
	return model;
    }

    /**
     * return dashboard Page
     * 
     * @param model
     * @return
     */
    @GetMapping(value = "/dashboard.htm")
    public ModelAndView returnDashboardPage(HttpServletRequest request)
    {

	/*
	 * Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication();
	 * 
	 * if (authentication != null) { authentication.getAuthorities(); String
	 * username = authentication.getName(); }
	 */
	ModelAndView model = new ModelAndView();
	model.setViewName("dashboard");
	return model;
    }

}
