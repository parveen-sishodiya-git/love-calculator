package tech.sishodiyology.lovecalculator.controllers.login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.sishodiyology.lovecalculator.model.Login;
import tech.sishodiyology.lovecalculator.model.Love;
import tech.sishodiyology.lovecalculator.service.login.LoginService;

@Controller
public class LoginCalculator {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/")
	public String login(@ModelAttribute("login") Login login) {
		return "login";
	}
	
	@RequestMapping("/process-login")
	public String processingLogin(@Valid @ModelAttribute("login") Login login,BindingResult result,@ModelAttribute("love") Love love) {
		boolean pass = false;
		if(result.hasErrors()) {
			System.out.println("Form has error");
			return "login";
		}else {
			System.out.println("NO Error");
		}
		pass = loginService.isValidUser(login);
		
		if(pass) {
			return "lovecalculation-home-page";
		}
		System.out.println("################ Login failed ################");
		System.out.println("Login Details: "+login);
		System.out.println("Home page DTO "+love);
		return "login";
	}
	
}
