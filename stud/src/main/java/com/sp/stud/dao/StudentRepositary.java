package com.sp.stud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sp.stud.entity.*;
public interface StudentRepositary extends JpaRepository<Student,Long> {

	public Student findOneByName(String name); 

}
