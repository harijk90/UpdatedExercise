package com.sp.stud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.stud.entity.CourseEntity;

public interface CourseRepositary extends JpaRepository<CourseEntity,Long> {

	public CourseEntity findOneByName(String name);

}
