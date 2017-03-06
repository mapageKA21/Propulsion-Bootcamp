package user.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import user.service.UserService;


@Controller
public class UserController {
	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String list(Model model){
		model.addAttribute("users", service.findAll());
		return "user/list";
	}
}
