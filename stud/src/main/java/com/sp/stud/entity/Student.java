package com.sp.stud.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	private String name;
	@ManyToMany
	@JoinTable(
	  name = "coursesStudent", 
	  joinColumns = @JoinColumn(name = "student_id"), 
	  inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<CourseEntity> courses;
	
	public Student() {
		
	}

	public Student(String name) {
		this.name=name;
		this.courses=new ArrayList<>();
	}
	
	public List<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + "]\n";
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
	
}
