package com.sp.stud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.stud.model.*;
import com.sp.stud.util.MapperUtil;
import com.sp.stud.dao.CourseRepositary;
import com.sp.stud.dao.StudentRepositary;

@RestController
public class StudentController {

	@Autowired
	StudentRepositary studentrepo; 
	@Autowired
	CourseRepositary courseRepo;
	
	@GetMapping(value = "/getAllStudents", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentModel>> getAllStudents() {
		List<StudentModel> studentList=MapperUtil.getStudentModelFromEntity(studentrepo.findAll());
		return new ResponseEntity<List<StudentModel>>(studentList,HttpStatus.OK);
	}
	
	@PostMapping(value="/student",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentModel> addStudent(@RequestBody StudentModel request) {
		  studentrepo.save(MapperUtil.getEntityBean(request));	
	return new ResponseEntity<StudentModel>(request,HttpStatus.CREATED);
	}
	
	@PostMapping(value="/course",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> addCourse(@RequestBody Course request) {
		  courseRepo.save(MapperUtil.getEntityBean(request));	
	return new ResponseEntity<Course>(request,HttpStatus.OK);
	}
	
	
	@PutMapping(value="/student/{name}",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel request,@PathVariable String name) {
	studentrepo.save(MapperUtil.updateStudentEntity(studentrepo.findOneByName(request.getName()),courseRepo.findOneByName(name)));	
	return new ResponseEntity<StudentModel>(request,HttpStatus.OK);
	}

	
}