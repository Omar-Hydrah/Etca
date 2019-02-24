package com.etca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etca.form.LessonForm;
import com.etca.service.LanguageService;
import com.etca.service.LevelService;
import com.etca.model.Sentence;
import com.etca.model.Language;
import com.etca.model.Level;

@RequestMapping("/lesson")
@Controller
public class LessonController{

	private static final Logger log = 
		LoggerFactory.getLogger(LessonController.class);

	@Autowired
	private LanguageService languageService;

	@Autowired
	private LevelService levelService;


	@GetMapping({"/", "/index"})
	public String all(){
		return "lesson/lessons";
	}

	@GetMapping("/create")
	public String create(Model model){

		LessonForm form = new LessonForm();
		List<Language> languages = languageService.findAll();
		List<Level> levels       = levelService.findAll();

		for(int i = 0; i < 5; i++){
			form.addSentence(new Sentence("Text", "Translation"));
		}

		model.addAttribute("form", form);
		model.addAttribute("languages", languages);
		model.addAttribute("levels", levels);

		return "lesson/create-lesson";
	}

	@PostMapping("/create")
	public String create(Model model, @Valid @ModelAttribute LessonForm form){
		log.info("\n\n" + form.toString() + "\n\n");

		return "lesson/create-lesson";
	}

	@GetMapping("/{id}")
	public String lesson(){
		return "";
	}
}