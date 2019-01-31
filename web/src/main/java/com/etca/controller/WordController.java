package com.etca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

import com.etca.model.Word;
import com.etca.model.User;
import com.etca.model.RoleEnum;

@RequestMapping("/word")
@Controller
public class WordController{

	@GetMapping({"/", "/index"})
	public String all(){
		return "word/words";
	}

	@GetMapping("/create-word")
	public String createWord(Model model){
		model.addAttribute(new Word());
		
		return "word/create-word";
	}

	@PostMapping("/create-word")
	public String createWord(@Valid @ModelAttribute Word word, 
		RedirectAttributes redirect, BindingResult result, Model model,
		@AuthenticationPrincipal User principal)
	{	
		if(!principal.canCreateContent()){

			redirect.addFlashAttribute("flash", "Must be an author to create word");
			return "redirect:/user/profile";

		}
		if(result.hasErrors()){
			model.addAttribute("error", "Failed to create word");

			return "word/create-word";
		}


		return "word/words";
	}
}