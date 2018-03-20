package by.itacademy.service;

import by.itacademy.entity.DamageBill;

public interface DamageBillService {

    void saveDamageBillByBillAndReservationId(DamageBill damageBill, Long id);
}
