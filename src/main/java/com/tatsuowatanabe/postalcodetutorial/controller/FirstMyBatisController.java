package com.tatsuowatanabe.postalcodetutorial.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tatsuowatanabe.postalcodetutorial.dto.TestDto;
import com.tatsuowatanabe.postalcodetutorial.form.first_my_batis.TestForm;
import com.tatsuowatanabe.postalcodetutorial.service.TestService;

@Controller
@RequestMapping(value = "/first_my_batis")
public class FirstMyBatisController {

	@Autowired
	private TestService testService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String test(Model model) {
		List<TestDto> tests = testService.getTestAll();
		model.addAttribute("message" , "MyBatisの全件取得サンプルです");
		model.addAttribute("tests"   , tests);
		model.addAttribute("testForm", new TestForm());
		return "first_my_batis/index";
	}
	
	@RequestMapping(value = "/dto/{id}", method = RequestMethod.GET)
	public String testDto(Model model, @PathVariable int id) {
		TestDto dto = new TestDto();
		dto.setId(id);
		TestDto test = testService.getTestByDto(dto);
		model.addAttribute("message" , "MyBatisのサンプルです");
		model.addAttribute("test"    , test);
		model.addAttribute("tests"   , null);
		model.addAttribute("testForm", new TestForm());
		return "first_my_batis/index";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String testInsert(@ModelAttribute TestForm form, Model model) {
		int count = testService.insertTest(form.getName());
		Logger.getLogger(FirstMyBatisController.class).log(Level.INFO, "挿入件数は" + count + "件です。");
		return "redirect:/first_my_batis";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String testDelete(Model model, @PathVariable int id) {
		int count = testService.deleteTest(id);
		Logger.getLogger(FirstMyBatisController.class).log(Level.INFO, "削除件数は" + count + "件です。");
		return "OK";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String testUpdate(Model model, @PathVariable int id) {
		TestDto test = testService.getTest(id);
		TestForm form = new TestForm();
		BeanUtils.copyProperties(test, form);
		model.addAttribute("message", "MyBatisのUpdateサンプルです");
		model.addAttribute("test"    , test);
		model.addAttribute("testForm", form);
		return "first_my_batis/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	@Transactional
	public String testUpdate(@ModelAttribute TestForm form, Model model) {
		TestDto dto = new TestDto();
		BeanUtils.copyProperties(form, dto);
		int count = testService.updateTest(dto);
		Logger.getLogger(FirstMyBatisController.class).log(Level.INFO, "更新件数は" + count + "件です。");
		return "OK";
	}

}
