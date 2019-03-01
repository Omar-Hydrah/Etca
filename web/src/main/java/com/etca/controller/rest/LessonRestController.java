package com.etca.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etca.model.Lesson;
import com.etca.service.LessonService;

@RestController
@RequestMapping("/api/lesson")
public class LessonRestController{

	private static final Logger log = 
		LoggerFactory.getLogger(LessonRestController.class);

	@Autowired
	private LessonService lessonService;

	@GetMapping("/")
	public Map<String, String> index(){
		Map<String, String> links = new HashMap<>();

		links.put("all lessons", "/api/lesson/all");
		links.put("single lesson", "/api/lesson/{id}");
		return links;
	}

	@GetMapping("/{id}")
	public Lesson lesson(@PathVariable("id") Long id){
		Optional<Lesson> lessonOptional = lessonService.findById(id);

		if(lessonOptional.isPresent()){
			Lesson lesson = lessonOptional.get();

			return lesson;
		}else{
			return null;
		}
	}

	@GetMapping("/all")
	public List<Lesson> all(){

		List<Lesson> lessons = lessonService.findAll();

		return lessons;
	}
}