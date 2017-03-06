package user.web;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

import user.domain.User;
import user.service.UserService;


@RestController
public class RestUserController {
	private final UserService service;
	
	public RestUserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public HttpEntity<Void> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		UriComponents uriComponents = fromMethodCall(on(getClass()).retrieveUser(savedUser.getId())).build();
		
		return ResponseEntity.created(uriComponents.encode().toUri()).build();
	}
	
	@PutMapping("/users/{id}")
	@ResponseStatus(NO_CONTENT)
	public void updateUser(@RequestBody User user, @PathVariable Long id) {
		service.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	@ResponseStatus(NO_CONTENT)
	public void deleteUser(Long id) {
		service.deleteById(id);
	}
	
}
