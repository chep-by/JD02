package by.itacademy.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatLineRepository extends CrudRepository<ChatLine, Long> {

    List<ChatLine> findAllByUserLogin(String login);
}
