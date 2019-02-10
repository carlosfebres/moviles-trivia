package uru.ing.computacion.moviles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import uru.ing.computacion.moviles.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	User findByEmail(String uuid);
}