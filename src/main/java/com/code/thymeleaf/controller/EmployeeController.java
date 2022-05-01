package com.code.thymeleaf.controller;

import com.code.thymeleaf.model.Employee;
import com.code.thymeleaf.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("employees", service.getEmployees());
        return "home";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("employee", service.getEmployee(id));
        return "form";
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public String save(@ModelAttribute("employee") Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, Model model) {
        service.getEmployee(id);
        service.deleteEmployee(id);
        return "redirect:/employees";
    }
}
