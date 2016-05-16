package com.tatsuowatanabe.postalcodetutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tatsuowatanabe.postalcodetutorial.dto.PostalDto;
import com.tatsuowatanabe.postalcodetutorial.form.postal.PostalForm;
import com.tatsuowatanabe.postalcodetutorial.service.PostalService;

@Controller
public class PostalCodeController {

	@Autowired
	private PostalService postalService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		List<PostalDto> postals = postalService.findWithPaging();
		model.addAttribute("message"   , "PostalCodeTutorial");
		model.addAttribute("postals"   , postals);
		model.addAttribute("postalForm", new PostalForm());
		return "postal/index";
	}
}
