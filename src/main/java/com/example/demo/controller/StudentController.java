package com.example.demo.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.model.Student;
import com.example.demo.model.Country;
import com.example.demo.service.CountryService;
import com.example.demo.service.StudentService;
import com.example.demo.validator.StudentFormVlaidator;

import jakarta.validation.Valid;



@Controller
public class StudentController {
	
	@Autowired
	private StudentService stService;
	@Autowired
	private CountryService cService;
	
	@Autowired
   private ModelMapper mapper;

	/*@GetMapping("/add-student")
	public ModelAndView addMerchants() {
		
		ModelAndView mv = new ModelAndView("student_add");

		
		/*System.out.println(country);
		
		for(Integer c:country.keySet()) {
			System.out.println(c+" value"+country.get(c));
		}
		
		
	
		return mv;
	
	}*/
	
	@GetMapping("/add-student")
	public ModelAndView addstudents() {
		ModelAndView mav = new ModelAndView("student_add");
		
Map<Integer,String> country=cService.getCountry();
		
		System.out.println(country);
		
		for(Integer c:country.keySet()) {
			System.out.println(c+" value"+country.get(c));
		}
		mav.addObject("countries",country);
		
		mav.addObject("studentFormVlaidator", new StudentFormVlaidator());
		return mav;
	}

	@PostMapping("/save-student")
	public void saveeditform() {
		System.out.println("hi");
	}
	
	@PostMapping("/save-students")
	public void SaveStudentCountry(@Valid  @ModelAttribute StudentFormVlaidator studentFormVlaidator,BindingResult bindingResult ){
		
		/*System.out.println(studentFormVlaidator);
		ModelAndView modelAndView = new ModelAndView("student_edit");
		
		if (bindingResult.hasErrors()) { 
			
			modelAndView.addObject("studentFormVlaidator", studentFormVlaidator);
	       
	        return modelAndView;
	    } else {
	    	mapper.getConfiguration().setAmbiguityIgnored(true);

	    	Student s =mapper.map(studentFormVlaidator, Student.class);
	    	s.setCountryId(studentFormVlaidator.getCountryId());
	    	stService.saveStudent(s);
	    	 return modelAndView;
	    }*/
		
		
		
	}
	@PostMapping("/save-studentfadsfs")
	public String SaveStudentCountry(@Valid  Student student,@RequestParam Integer country,BindingResult bindingResult ){
				
		/*student.setCountry(cService.findById(country));
		System.out.println(student);*/
		
		if (bindingResult.hasErrors()) {       
	         
	        return "student_edit";
	    } else {
	        return "student_list";
	    }
		
		
	}
	
	
	/*@Autowired
	private LaptopService lapService;*/
	
	/*@RequestMapping("/StudentsList")
	public ModelAndView getList(){
		ModelAndView mv =new ModelAndView("student_list");
		mv.addObject("students",stService.findAllStudents());
		
		return mv;
		
	}
	
	
	
	
	@GetMapping("/edit/{id}")
	public ModelAndView getStaff(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("student_add");
		Student student = stService.getById(id);
		mav.addObject("command", student);
		return mav;
	}
	
	@GetMapping("/add-student")
	public ModelAndView addstudents() {
		ModelAndView mav = new ModelAndView("student_add");
		mav.addObject("command", new Student());
		return mav;
	}
	@PostMapping("/save-student")
	public String saveStudent(@ModelAttribute Student student) {
		stService.saveStudent(student);
		return "redirect:/StudentsList";
		
	}
	


	@GetMapping("/delete/{id}")
	public String saveStudent(@PathVariable("id") Integer id) {
		Student studnet=stService.getById(id);
		stService.delete(studnet.getId());
		return "redirect:/StudentsList";
		
	}*/

	@RequestMapping("/home")
	public ModelAndView firstPage() {
		return new ModelAndView("home");
	}
	
	
	}
