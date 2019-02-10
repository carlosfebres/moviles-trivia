package uru.ing.computacion.moviles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;
import uru.ing.computacion.moviles.entity.User;
import uru.ing.computacion.moviles.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	private final TokenStore tokenStore;

	@Autowired
	public UserController(UserService userService, TokenStore tokenStore) {
		this.userService = userService;
		this.tokenStore = tokenStore;
	}

	@PostMapping
	@ResponseBody
	public User signup(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public User get(@PathVariable("id") int id) throws ChangeSetPersister.NotFoundException {
		return userService.getById(id);
	}

	@GetMapping("/logout")
	@ResponseStatus(HttpStatus.OK)
	public void logout(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null) {
			String tokenValue = authHeader.substring(7).trim();
			OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
			tokenStore.removeAccessToken(accessToken);
		}
	}


}