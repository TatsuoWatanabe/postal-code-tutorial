package com.tatsuowatanabe.postalcodetutorial.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.tatsuowatanabe.postalcodetutorial.dto.EmployeeDto;
import com.tatsuowatanabe.postalcodetutorial.form.employee.EmployeeListForm;

@Controller
public class EmployeeListController {
	private List<EmployeeDto> employeeList = new ArrayList<>();
	
	@RequestMapping(value="/employee/list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("title"           , "社員一覧");
		model.addAttribute("message"         , "登録社員一覧情報を表示します。");
		model.addAttribute("employeeListForm", new EmployeeListForm());
		model.addAttribute("employeeList"    , employeeList);
		return "employee/list";
	}
	
	@RequestMapping(value = "/employee/list", method = RequestMethod.POST)	
	public String list(@Valid @ModelAttribute EmployeeListForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("message"         , "");
			model.addAttribute("employeeListForm", form);
		} else {
			// is Valid.
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(form, dto);
			employeeList.add(dto);
			model.addAttribute("message"         , form.getName() + "を登録しました。");
			model.addAttribute("employeeListForm", new EmployeeListForm()); // clear the form.
		}
		
		model.addAttribute("title"       , "社員一覧");
		model.addAttribute("employeeList", employeeList);
		
		return "employee/list";
	}
}
