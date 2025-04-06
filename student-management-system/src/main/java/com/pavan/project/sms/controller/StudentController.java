package com.pavan.project.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pavan.project.sms.entity.Student;
import com.pavan.project.sms.service.StudentService;



@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//handler method to handle list students and return mode and view
	
	@GetMapping("/students")
	public String ListStudents(Model model ) {
		model.addAttribute("students", studentService.getAllStudents());
		return "sutdents";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudentId(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		// get student from database by id
		Student existingStudent = studentService.getStudentId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		//save update student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
		
	}
	
	//handler method to handle delete student request
	
	@GetMapping("/students/{id}")
	public  String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
