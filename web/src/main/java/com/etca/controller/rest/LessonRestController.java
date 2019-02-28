package com.etca.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import com.etca.model.Lesson;
import com.etca.service.LessonService;

@RestController
@RequestMapping("/api/lesson")
public class LessonRestController{

	@Autowired
	private LessonService lessonService;

	@GetMapping("/{id}")
	@ResponseBody
	public Lesson lesson(){
		Optional<Lesson> lessonOptional = lessonService.findById();

		if(lessonOptional.isPresent()){
			return lessonOptional.get();
		}else{
			return null;
		}
	}

	@GetMapping("/all")
	@ResponseBody
	public List<Lesson> all(){
		return lessonService.findAll();
	}
}