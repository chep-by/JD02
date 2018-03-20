package by.itacademy.service;

import by.itacademy.aspect.SaveOrUpdateLogger;
import by.itacademy.entity.DamageBill;
import by.itacademy.entity.Reservation;
import by.itacademy.repository.DamageBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DamageBillServiceImpl implements DamageBillService {

    private final DamageBillRepository damageBillRepository;
    private final ReservationService reservationService;

    @Autowired
    public DamageBillServiceImpl(DamageBillRepository damageBillRepository, ReservationService reservationService) {
        this.damageBillRepository = damageBillRepository;
        this.reservationService = reservationService;
    }

    @SaveOrUpdateLogger
    @Override
    public void saveDamageBillByBillAndReservationId(DamageBill damageBill, Long id) {
        Reservation reservation = reservationService.findOne(id);
        damageBill.setReservation(reservation);
        damageBillRepository.save(damageBill);
    }
}
