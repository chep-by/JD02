package by.itacademy.service;

import by.itacademy.dto.CostStrategyDao;

import java.util.List;

public interface CostStrategyService {

    List<CostStrategyDao> decodeCostStrategy(String costStrategy);

    String encodeCostStrategy(List<CostStrategyDao> list);
}
