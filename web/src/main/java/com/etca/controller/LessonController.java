package com.etca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/lesson")
@Controller
public class LessonController{

	@GetMapping({"/", "/index"})
	public String all(){
		return "lesson/lessons";
	}
}