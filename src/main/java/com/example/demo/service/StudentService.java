package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public void saveStudent(Student student) {
		repo.save(student);
	}
	/*public String getStudentByRollno(String rollNo) {
		return repo.findbyRollNo(rollNo);

	}*/
	
	
	

	public Student getById(Long id) {
		return repo.findById(id).get();

	}

	public List<Student> findAllStudents(){
		return repo.findAll();
	}



	public void delete(Long id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
	}




	
}
