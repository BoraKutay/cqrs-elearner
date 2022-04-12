package com.turkcell.elearner.ws.controllers;


import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.elearner.application.features.courses.commands.create.CreateCourseCommand;
import com.turkcell.elearner.ws.models.CreateCourseModel;

@RestController
@RequestMapping("/courses")
public class CoursesController {

	private CommandGateway commandGateway;

	public CoursesController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}
	
	@PostMapping("/create-course")
	public void createCourse(@RequestBody CreateCourseModel createCourseModel) {
		
		CreateCourseCommand command = CreateCourseCommand.builder()
				.courseName(createCourseModel.getCourseName())
				.description(createCourseModel.getDescription())
				.category(createCourseModel.getCategory())
				.build();
		
		
		this.commandGateway.sendAndWait(command);
	}
	
}
