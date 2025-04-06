package com.pavan.project.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pavan.project.sms.entity.Student;
import com.pavan.project.sms.repositories.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {

//		Student student1 = new Student("Pavan","Bathygari","Pavan123@gmail.com");
//		studentRepository.save(student1);
//		
//		Student student2 = new Student("Charan","Pendyala","Charan123@gmail.com");
//		studentRepository.save(student2);
	}

}
