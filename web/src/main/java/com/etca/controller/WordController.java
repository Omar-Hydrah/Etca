package com.etca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.List;
import java.util.Collection;

import com.etca.model.Word;
import com.etca.model.User;
import com.etca.model.RoleEnum;
import com.etca.model.Language;
import com.etca.model.Level;
import com.etca.form.WordForm;
import com.etca.service.LanguageService;
import com.etca.service.LevelService;
import com.etca.service.WordService;

@RequestMapping("/word")
@Controller
public class WordController{

	private static final Logger logger =
		LoggerFactory.getLogger(WordController.class);

	@Autowired
	private LevelService levelService;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private WordService wordService;


	@GetMapping({"/", "/index"})
	public String index(Model model){

		return "word/words";
	}

	@GetMapping("/all")
	public String all(Model model){
		List<Word> words = wordService.findAll();

		model.addAttribute("words", words);

		return "word/words-list";
	}

	@GetMapping("/create-word")
	public String createWord(Model model){

		List<Language> langs  = languageService.findAll();
		List<Level>    levels = levelService.findAll(); 

		
		model.addAttribute("wordForm", new WordForm());
		model.addAttribute("languages", langs);
		model.addAttribute("levels", levels);

		return "word/create-word";
	}

	@PostMapping("/create-word")
	public String createWord(@Valid @ModelAttribute WordForm wordForm, 
		RedirectAttributes redirect, BindingResult result, Model model,
		@AuthenticationPrincipal User principal)
	{	
		// logger.info("\n\n" + wordForm.toString() + "\n\n");

		if(principal == null || !principal.canCreateContent()){

			redirect.addFlashAttribute("flash", "Must be an author to create word");
			return "redirect:/user/profile";

		}
		if(result.hasErrors()){
			model.addAttribute("error", "Failed to create word");

			return "word/create-word";
		}

		wordService.save(wordForm);

		return "redirect:/word/words";
	}
}