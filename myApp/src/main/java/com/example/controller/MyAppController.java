package com.example.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.EmpDetails;
import com.example.model.UserRegistration;
import com.example.service.MyAppService;


@RestController
public class MyAppController {

	@Autowired
	MyAppService myAppService;
	
	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;
	
    @RequestMapping(value = "/getSalary/empId/{empId}", method=RequestMethod.GET)
    public Optional<EmpDetails> getSalary(@PathVariable String empId) {
    	System.out.println("Here finally");
    	Optional<EmpDetails> empDet = myAppService.getSalary(empId);
        return empDet;
    }
    
    @RequestMapping(value = "/getByName/empName/{empName}", method=RequestMethod.GET)
    public List<EmpDetails> getByName(@PathVariable String empName) {
    	System.out.println("Here in getByName");
    	List<EmpDetails> empDet = myAppService.getByName(empName);
        return empDet;
    }
    
    @RequestMapping(value = "/getEmployee/salaryEqAbove/{salary}", method=RequestMethod.GET)
    public List<EmpDetails> salaryEqAbove(@PathVariable String salary) {
    	System.out.println("Here in salaryEqAbove");
    	List<EmpDetails> empDet = myAppService.salaryEqAbove(salary);
        return empDet;
    }
    @GetMapping(value = "/test")
    public String getSalary() {
    	System.out.println("Here in Test");
        return "Success";
    }
    
    @GetMapping(value = "/getManagerName/empName/{empName}")
    public String getManagerName(@PathVariable String empName) {
    	System.out.println("Here in getManagerName");
    	String managerName = myAppService.getManagerName(empName);
    	String message = empName + "'s Manager is " + managerName;
        return message;
    }
    
    @GetMapping(value = "/getNoOfEmployees/managerName/{managerName}")
    public String getNoOfEmployees(@PathVariable String managerName) {
    	System.out.println("Here in getNoOfEmployees");
    	int empCount = myAppService.getNoOfEmployees(managerName);
    	String message = managerName + " has " + empCount + " employee(s) under him";
        return message;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return new ModelAndView("login");
    }
    
    @RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
    	System.out.println("Inside GET method of register");
		return new ModelAndView("registration", "user", new UserRegistration());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegister(@ModelAttribute("user") UserRegistration userRegistrationObject) {
		String username = userRegistrationObject.getUsername();
		System.out.println("Inside POST method with User : " + username);
		
		// authorities to be granted
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.addAll(userRegistrationObject.getAuthority());
		User user = new User(username, userRegistrationObject.getPassword(), authorities);
		System.out.println("calling jdbcUserDetailsManager from controller");
		
		jdbcUserDetailsManager.createUser(user);
		
		return new ModelAndView("redirect:/welcome");
	}
    
    
}

