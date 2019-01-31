package com.etca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/grammar")
@Controller
public class GrammarController{

	@GetMapping({"/", "/index"})
	public String all(){
		return "grammar";
	}
}