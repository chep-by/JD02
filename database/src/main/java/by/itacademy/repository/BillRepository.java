package by.itacademy.repository;

import by.itacademy.entity.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface BillRepository extends CrudRepository<Bill, Long> {

    Bill findByReservationId(Long id);

    @Query(value = "select sum(b.finalCost) from Bill b where b.payDateTime>?1 and b.payDateTime<?2")
    Integer findSumByDate(LocalDateTime before, LocalDateTime after);
}
