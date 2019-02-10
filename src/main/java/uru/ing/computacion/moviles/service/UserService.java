package uru.ing.computacion.moviles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uru.ing.computacion.moviles.DAO.UserDAO;
import uru.ing.computacion.moviles.entity.Game;
import uru.ing.computacion.moviles.entity.User;

import java.util.Set;


@Service
public class UserService {

	private final PasswordEncoder passwordEncoder;
	private final UserDAO userDAO;

	@Autowired
	public UserService(PasswordEncoder passwordEncoder, UserDAO userDAO) {
		this.passwordEncoder = passwordEncoder;
		this.userDAO = userDAO;
	}

	@Transactional
	public void removeById(int id) {
		userDAO.delete( userDAO.getOne(id) );
	}

	@Transactional
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDAO.save(user);
		return user;
	}

	public User getById(int id) throws ChangeSetPersister.NotFoundException {
		return userDAO.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
	}

}
