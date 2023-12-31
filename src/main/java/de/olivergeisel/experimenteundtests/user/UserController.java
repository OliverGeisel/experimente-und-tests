package de.olivergeisel.experimenteundtests.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {this.userRepository = userRepository;}

	@GetMapping("")
	String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}
}
