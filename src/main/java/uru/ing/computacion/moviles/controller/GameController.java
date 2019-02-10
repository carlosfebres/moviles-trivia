package uru.ing.computacion.moviles.controller;

import org.springframework.data.domain.Page;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import uru.ing.computacion.moviles.entity.Game;
import uru.ing.computacion.moviles.service.GameService;

import java.util.Set;

@RestController
@RequestMapping("/game")
public class GameController {

	private final GameService gameService;

	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping
	@ResponseBody
	public Set<Game> getGames(OAuth2Authentication oAuth2Authentication) {
		String user_email = (String) oAuth2Authentication.getPrincipal();
		return this.gameService.getGames( user_email );
	}

	@GetMapping("/top")
	@ResponseBody
	public Page<Game> getTop(@RequestParam(defaultValue = "0", required = false) int index, @RequestParam(defaultValue = "10", required = false) int size) {
		return this.gameService.topGames( index, size );
	}

	@PostMapping
	@ResponseBody
	public Game save(@RequestBody Game game) {
		this.gameService.save(game);
		game.setPlayer(null);
		return game;
	}

}