package com.sp.stud;



import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sp.stud.dao.CourseRepositary;
import com.sp.stud.dao.StudentRepositary;
import com.sp.stud.entity.CourseEntity;
import com.sp.stud.entity.Student;

@SpringBootApplication
public class StudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner mappingDemo(StudentRepositary studentRepository,
    		CourseRepositary courseRepository) {
        return args -> {
            Student student = new Student("Harish");
            studentRepository.save(student);

            CourseEntity course1 = new CourseEntity("AWS");
            CourseEntity course2 = new CourseEntity("SpringMvc");
            CourseEntity course3 = new CourseEntity("J2EE");

            courseRepository.saveAll(Arrays.asList(course1, course2, course3));

           
            student.getCourses().addAll(Arrays.asList(course1, course2, course3));

           studentRepository.save(student);
        };
    }

}
