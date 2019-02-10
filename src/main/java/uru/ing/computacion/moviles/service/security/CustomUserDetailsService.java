package uru.ing.computacion.moviles.service.security;

import uru.ing.computacion.moviles.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uru.ing.computacion.moviles.entity.User;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    UserDAO UserDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.UserDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        User user = UserDAO.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new CustomUserDetails(user);
    }
}
