package by.itacademy.repository;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByLogin(String login);

    User findByLogin(String login);
}
