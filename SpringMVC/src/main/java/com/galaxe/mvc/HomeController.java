package com.galaxe.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.galaxe.mvc.model.Student;
import com.galaxe.mvc.service.StudentService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	StudentService stService;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") Long id) {

		Student student = new Student();
		student = stService.getStudentbyId(id);
		model.addAttribute("student", student);
		return "edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("student") Student student) {

		stService.updateStudentSer(student);
		return "redirect:/displayStudents";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Student student, @RequestParam("username") String username,
			@RequestParam("password") String password) {

		try {
			Student stud = stService.loginSer(username, password);

			if (stud != null) {
				return "redirect:/displayStudents";
			}
		} catch (NullPointerException e) {
		}

		return "redirect:/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("student") Student student, Model model) {

		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute("student") Student student) {

		stService.createStudentser(student);
		return "redirect:/displayStudents";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model) {

		stService.findSer(id);
		model.addAttribute(id);
		stService.deleteStudentSer(id);
		return "redirect:/displayStudents";
	}

	@RequestMapping(value = "/displayStudents", method = RequestMethod.GET)
	public String displayStudents(Model model) {
		List<Student> studentList = stService.getAllStudents();
		model.addAttribute("studentList", studentList);
		return "displayStudents";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

}
