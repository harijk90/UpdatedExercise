package com.sp.stud.util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.BeanUtils;

import com.sp.stud.model.*;
import com.sp.stud.entity.*;

public class MapperUtil {

	public static List<StudentModel> getStudentModelFromEntity(List<Student> studEntilties){
		List<StudentModel> studentList=new ArrayList<>();
		for(Student studEntity:studEntilties) {
			StudentModel student=new StudentModel();
			student.setId(studEntity.getId());
			student.setName(studEntity.getName());
			student.setCourses(getConvertedCouseList(studEntity.getCourses()));
			studentList.add(student);
	}
		return studentList;
	}

	private static List<Course> getConvertedCouseList(List<CourseEntity> courses) {
		List<Course> courseList=new ArrayList<>();
		for(CourseEntity courseEntity:courses) {
			Course course=new Course();
			course.setId(courseEntity.getId());
			course.setName(courseEntity.getName());
			courseList.add(course);
		}
		return courseList;
	}

	public static Student getEntityBean(StudentModel model) {
		
		Student studentEntity=new Student(model.getName());
		BeanUtils.copyProperties(model, studentEntity);
		return studentEntity;
	}
public static CourseEntity getEntityBean(Course model) {
		
		CourseEntity courseEntity=new CourseEntity(model.getName());
		BeanUtils.copyProperties(model, courseEntity);
		return courseEntity;
	}

public static Student updateStudentEntity(Student student, CourseEntity course) {
	if(student!=null)
		student.getCourses().addAll(Arrays.asList(course));
  return student;
}
}
