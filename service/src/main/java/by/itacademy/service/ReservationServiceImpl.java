package by.itacademy.service;

import by.itacademy.aspect.SaveOrUpdateLogger;
import by.itacademy.dto.CostStrategyDao;
import by.itacademy.dto.DateIntervalDto;
import by.itacademy.dto.ReservationDto;
import by.itacademy.entity.Bill;
import by.itacademy.entity.Reservation;
import by.itacademy.entity.User;
import by.itacademy.entity.Vehicle;
import by.itacademy.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    public static final int INIT_FINAL_COST = 0;
    public static final int STANDART_VERSION = 0;
    private ReservationRepository reservationRepository;
    private CostStrategyService costStrategyService;
    private UserService userService;
    private BillService billService;
    private VehicleService vehicleService;
    private ReservationStatusService reservationStatusService;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, CostStrategyService costStrategyService, UserService userService, BillService billService, VehicleService vehicleService, ReservationStatusService reservationStatusService) {
        this.reservationRepository = reservationRepository;
        this.costStrategyService = costStrategyService;
        this.userService = userService;
        this.billService = billService;
        this.vehicleService = vehicleService;
        this.reservationStatusService = reservationStatusService;
    }


    @Cacheable(cacheNames = "request")
    @Override
    public List<DateIntervalDto> findBlockedDatesByVehicleId(Long id) {
        LinkedList<DateIntervalDto> dateIntervalDtos = new LinkedList<>();
        List<Object[]> blockedDatesByVehicleId = reservationRepository.findBlockedDatesByVehicleId(id);
        if (blockedDatesByVehicleId.isEmpty()) {
            return null;
        } else {
            blockedDatesByVehicleId.forEach(object -> dateIntervalDtos.add(new DateIntervalDto((LocalDate) object[0], (LocalDate) object[1])));
            return dateIntervalDtos;
        }
    }


    @SaveOrUpdateLogger
    @Override
    public void createAndSaveReservation(ReservationDto reservationDto) {
        Vehicle vehicle = vehicleService.findOne(reservationDto.getVehicleId());
        List<CostStrategyDao> decodeCostStrategy = costStrategyService.decodeCostStrategy(vehicle.getVehicleCategory().getCostStrategy().getStrategy());
        Integer days = Period.between(reservationDto.getDateTake(), reservationDto.getDateReturn().plusDays(1)).getDays();
        int finalCost = INIT_FINAL_COST;
        for (CostStrategyDao costStrategyDao : decodeCostStrategy) {
            if (costStrategyDao.getStartDays() <= days && costStrategyDao.getEndDays() >= days) {
                finalCost = days * vehicle.getStandardPrice() * costStrategyDao.getCost() / 100;
                break;
            }
        }
        Bill saveBill = billService.createAndSaveBill(finalCost);
        User user = userService.findOneByLogin(reservationDto.getUserName());


        Reservation reservation = new Reservation();
        reservation.setDateTake(reservationDto.getDateTake());
        reservation.setDateReturn(reservationDto.getDateReturn());
        reservation.setVehicle(vehicle);
        reservation.setUser(user);
        reservation.setCommend(reservationDto.getCommend());
        reservation.setReservationStatus(reservationStatusService.getReservationStatusByStatusName("order created")); //TODO here something doesn't work
        reservation.setPayed(false);
        reservation.setBill(saveBill);
        reservation.setVersion(STANDART_VERSION);
        reservationRepository.save(reservation);

    }

    @Override
    public List<Reservation> findAll() {
        Iterable<Reservation> all = reservationRepository.findAll();
        ArrayList<Reservation> reservations = new ArrayList<>();
        all.forEach(reservations::add);
        return reservations;
    }

    @Override
    public Reservation findOne(Long id) {
        return reservationRepository.findOne(id);
    }

    @SaveOrUpdateLogger
    @Override
    public void updateByReservationDto(Reservation reservationLikeDtoHasIdReservationStatusPayed) {
        long id = reservationLikeDtoHasIdReservationStatusPayed.getId();
        Reservation updateReservation = reservationRepository.findOne(id);
        if (updateReservation.getVersion() != reservationLikeDtoHasIdReservationStatusPayed.getVersion()) {
            throw new OptimisticLockException();
        } else {
            updateReservation.setReservationStatus(reservationLikeDtoHasIdReservationStatusPayed.getReservationStatus());
            updateReservation.setPayed(reservationLikeDtoHasIdReservationStatusPayed.isPayed());
            updateReservation.setVersion(reservationLikeDtoHasIdReservationStatusPayed.getVersion() + 1);
        }
//        reservationRepository.save(updateReservation);
    }

    @Override
    public List<Reservation> findAllByUserLogin(String login) {
        return reservationRepository.findAllByUserLogin(login);
    }


}

