package com.spring_study.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_study.dao.StudentDAO;
import com.spring_study.dao.StudentDAOImpl;
import com.spring_study.model.Student;
import com.sun.media.sound.ModelWavetable;

@Controller
public class StudentAdmissionController {

	@Autowired
	private StudentDAO studDAO;
	@RequestMapping("/Student.html")
	public ModelAndView getHandler()
	{
		
		ModelAndView mv=new ModelAndView("Student");
		List<Student> studentList=studDAO.list();
		mv.addObject("studentList", studentList);
		System.out.println("I am here ");
		return mv;
				
	}
	@RequestMapping(value="/submitForm.html",method = RequestMethod.POST)
	public String submitStudentForm(@ModelAttribute Student student1)
	{
		System.out.println("I am inside add  ");
		System.out.println(student1.getUserId());
		if(student1.getUserId()!=0)
			studDAO.update(student1);
		System.out.println("I am here after adding model atribute");
		/*Student student1=new Student();
		student1.setStudentName(studentName);
		student1.setStudentHobby(studentHobby);*/
		System.out.println("This is controller");
		ModelAndView mv=new ModelAndView("Student","msg","Record has been added");
		//mv.addObject("student1", student1);
		return "redirect:Student.html";
	}
	    @RequestMapping("/remove/{id}")
	    public String removeStudent(@PathVariable("id") int id){
	    
	    	System.out.println("I am here in delete");
	        this.studDAO.delete(id);
	        return "redirect:/Student.html";
	    }
	  
	    @RequestMapping("/edit/{id}")
	    public String editStudent(@PathVariable("id") int id,RedirectAttributes redirectAttributes){
	    	
	    	System.out.println("This is edit method");
	    	System.out.println(id);
	    	List<Student> studentList=studDAO.list();
	    	
			for(Student student1 : studentList){
				System.out.println(student1.getStudentName());
				
			}
	            
				
			System.out.println(studentList.isEmpty());
			ModelAndView mv=new ModelAndView("forward:/Student.html","student",this.studDAO.getStudent(id));
			mv.addObject("studentList",studentList);
			redirectAttributes.addFlashAttribute("student",this.studDAO.getStudent(id));
	    	return "redirect:/Student.html";
	    	
	    }
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addCustomFormatter(new DateFormatter("dd-mm-yyyy"));
		
	}
	
}
