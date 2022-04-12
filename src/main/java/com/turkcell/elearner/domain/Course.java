package com.turkcell.elearner.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="courses")
public class Course {

	@Id
    @Column(name = "id")
	private String courseId;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category")
	private String category;
	
	
}
