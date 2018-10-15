package by.itacademy.service;

import by.itacademy.exceptions.UserExistException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void newUserRegistration(User user) throws UserExistException;

    User findOneByLogin(String login);
}
