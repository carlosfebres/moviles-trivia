package uru.ing.computacion.moviles.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uru.ing.computacion.moviles.entity.Game;
import uru.ing.computacion.moviles.entity.User;

import java.util.Set;

public interface GameDAO extends JpaRepository<Game, Integer> {

	Set<Game> findAllByPlayerEmail(String email);

	@Query(
			value = "SELECT g FROM Game g JOIN FETCH g.player ORDER BY g.score DESC",
			countQuery = "SELECT count(g) FROM Game g"
	)
	Page<Game> getTopGames(Pageable pagable);


}
