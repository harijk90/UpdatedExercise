package com.sp.stud.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int id;

	private String name;

public 	CourseEntity(String name) {
	this.name=name;
}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public CourseEntity() {
		// TODO Auto-generated constructor stub
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@ManyToMany(mappedBy = "courses")
    List<Student> students;
}
