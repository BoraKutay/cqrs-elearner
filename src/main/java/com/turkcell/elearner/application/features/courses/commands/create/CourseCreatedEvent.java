package com.turkcell.elearner.application.features.courses.commands.create;


import lombok.Data;

@Data
public class CourseCreatedEvent {
	private String courseId;
	private String courseName;
	private String description;
	private String category;
	
}
