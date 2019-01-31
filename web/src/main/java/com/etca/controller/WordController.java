package com.etca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/word")
@Controller
public class WordController{

	@GetMapping({"/", "/index"})
	public String all(){
		return "words";
	}
}