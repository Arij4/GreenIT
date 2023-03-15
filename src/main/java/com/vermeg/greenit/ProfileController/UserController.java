package com.vermeg.greenit.ProfileController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.greenit.ProfileRepository.UserRepository;
import com.vermeg.greenit.profile.User;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/user/search/all")
	public List<User> index() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{mail}")
	public User show(@PathVariable String mail) {
		return userRepository.findByMail(mail);
	}

	@PostMapping("/user/search")
	public User search(@PathVariable String mail) {

		return userRepository.findByMail(mail);
	}

	@PostMapping("/user")
	public User  create(@RequestBody User user) {

		return userRepository.save(new User(user.getMail(), user.getPassword()));
	}

	@PutMapping("/user/{mail}")
	public User update(@PathVariable String mail, @RequestBody Map<String, String> body) {
		int userMail = Integer.parseInt(mail);
		// getting profile
		@SuppressWarnings("deprecation")
		User user = userRepository.getOne((long) userMail);

		user.setMail(body.get("mail"));
		user.setPassword(body.get("password"));
		return userRepository.save(user);
	}

	@DeleteMapping("user/{mail}")
	public boolean delete(@PathVariable String mail) {
		int userMail = Integer.parseInt(mail);
		userRepository.deleteByMail(userMail);
		return true;
	}

}