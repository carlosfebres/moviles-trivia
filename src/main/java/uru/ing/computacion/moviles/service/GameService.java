package uru.ing.computacion.moviles.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uru.ing.computacion.moviles.DAO.GameDAO;
import uru.ing.computacion.moviles.DAO.UserDAO;
import uru.ing.computacion.moviles.entity.Game;
import uru.ing.computacion.moviles.entity.User;

import java.util.Set;

@Service
public class GameService {

	private final GameDAO gameDAO;

	public GameService(GameDAO gameDAO, UserDAO userDAO) {
		this.gameDAO = gameDAO;
	}

	@Transactional(readOnly = true)
	public Page<Game> topGames(int index, int size) {
		return this.gameDAO.getTopGames(PageRequest.of(index, size));
	}

	@Transactional(readOnly = true)
	public Set<Game> getGames(String email) {
		return gameDAO.findAllByPlayerEmail( email );
	}

	@Transactional
	public void save(Game game) {
		this.gameDAO.save(game);
	}
}
