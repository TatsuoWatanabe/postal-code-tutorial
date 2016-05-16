package com.tatsuowatanabe.postalcodetutorial.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tatsuowatanabe.postalcodetutorial.form.*;

@Controller
public class FirstController {
	
	@RequestMapping(value = "first/show", method = RequestMethod.GET)
    public String show(Model model) {
		FirstForm form = new FirstForm();
		
		@SuppressWarnings("serial")
		HashMap<String, String> hm = new HashMap<String, String>() {
			{ put("message" , "hello world!!");  }
			{ put("message2", "world of mine."); }
		};
		model.addAllAttributes(hm);
		model.addAttribute("firstForm", form);

		model.addAttribute("checkEmployees", getCheckEmployees());

		return "first/show";
    }
	
	@RequestMapping(value = "first/show", method = RequestMethod.POST)
	public String getFormInfo(@ModelAttribute FirstForm form, Model model) {
        StringBuilder builder = new StringBuilder();
        builder.append("ID : " + form.getId() + "<br /> Name : " + form.getName());
        for (String employee : form.getEmployees()) {
            builder.append("<br />").append(employee);
        }
        model.addAttribute("message", builder);
	    model.addAttribute("checkEmployees", getCheckEmployees());

	    return "first/show";
	}
	
    private List<String> getCheckEmployees() {
        List<String> list = new LinkedList<>();
        list.add("一太郎");
        list.add("次郎");
        list.add("三郎");
        return list;
    }

}
