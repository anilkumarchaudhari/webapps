package net.codejava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	@RequestMapping("/")
	public String login() {
		return "welcome";
	}
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping("/403")
	public String error() {
		return "accessdenied";
	}
}
