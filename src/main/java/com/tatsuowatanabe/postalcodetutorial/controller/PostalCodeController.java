package com.tatsuowatanabe.postalcodetutorial.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String index(@ModelAttribute PostalForm form, Model model) {
		PostalDto dto = form.toDto();
		List<PostalDto> postals = postalService.findLimited(dto);
		model.addAttribute("totalPostals", postalService.foundRows(dto));
		model.addAttribute("title"       , "PostalCodeTutorial");
		model.addAttribute("postals"     , postals);
		model.addAttribute("postalForm"  , form);
		List<String> prefectures = Arrays.asList("東京都", "北海道", "大阪府");
		model.addAttribute("prefectures", prefectures);
		
		return "postal/index";
	}
}
