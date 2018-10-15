package by.itacademy.service;

import by.itacademy.repository.ReservationStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReservationStatusServiceImpl implements ReservationStatusService {

    private ReservationStatusRepository reservationStatusRepository;

    @Autowired
    public ReservationStatusServiceImpl(ReservationStatusRepository reservationStatusRepository) {
        this.reservationStatusRepository = reservationStatusRepository;
    }

    @Override
    public ReservationStatus getReservationStatusByStatusName(String statusName) {
        return reservationStatusRepository.findByStatusName(statusName);
    }

    @Override
    public List<ReservationStatus> findAll() {
        Iterable<ReservationStatus> all = reservationStatusRepository.findAll();
        ArrayList<ReservationStatus> list = new ArrayList<>();
        all.forEach(list::add);
        return list;
    }
}
