package com.pharm.controller.login;

import com.pharm.dto.user.RequestUserDTO;
import com.pharm.security.JWTUtility;
import com.pharm.security.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private JWTUtility jwtUtilility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody RequestUserDTO requestUserDTO, HttpServletRequest request) throws Exception {
       // UserDetails userDetails = null;
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestUserDTO.getUsername(),
                            requestUserDTO.getPassword())
            );
            request.getSession().setAttribute("userName", requestUserDTO.getUsername());
            //UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        } catch (Exception ex) {
            throw new Exception("Invalid Username or Password");
        }
        return ResponseEntity.ok(new JwtResponse(JWTUtility.generateToken(requestUserDTO.getUsername()),
                null,
                requestUserDTO.getUsername(),
                null,
                null));

       // JWTUtility.generateToken(requestUserDTO.getUsername());
    }


    @GetMapping("/welcom")
    public String welcom()
    {
        return "welcome to Pharm";
    }

    /**
     * return login page
     *
     * @param //model
     * @return
     */
    @RequestMapping(value = "/login.htm", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView returnLoginPage(@RequestParam(value = "error", required = false) String error,
                                        @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
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
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.addObject("login", new RequestUserDTO());
        model.setViewName("login-page");
        return model;
    }

    /**
     * return dashboard Page
     *
     * @param //model
     * @return
     */
    @GetMapping(value = "/dashboard.htm")
    public ModelAndView returnDashboardPage(HttpServletRequest request) {

        /*
         * Authentication authentication =
         * SecurityContextHolder.getContext().getAuthentication();
         *
         * if (authentication != null) { authentication.getAuthorities(); String
         * username = authentication.getName(); }
         */
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

}
