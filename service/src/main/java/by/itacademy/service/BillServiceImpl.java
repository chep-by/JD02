package by.itacademy.service;

import by.itacademy.aspect.SaveOrUpdateLogger;
import by.itacademy.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class BillServiceImpl implements BillService {

    public static final int DAYS_TO_PAY_BILL = 5;
    private BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @SaveOrUpdateLogger
    @Override
    public Bill createAndSaveBill(int finalCost) {
        Bill bill = new Bill();
        bill.setPayDateTime(LocalDateTime.now().plusDays(DAYS_TO_PAY_BILL));
        bill.setFinalCost(finalCost);
        billRepository.save(bill);
        return bill;
    }
}
