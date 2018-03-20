package by.itacademy.service;

import by.itacademy.dto.CostStrategyDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class CostStrategyServiceImpl implements CostStrategyService {

    @Override
    public List<CostStrategyDao> decodeCostStrategy(String costStrategy) {
        LinkedList<CostStrategyDao> costStrategyDaoList = new LinkedList<>();
        String[] split = costStrategy.split("_");
        for (String onePart : split) {
            CostStrategyDao costStrategyDao = new CostStrategyDao();
            String[] split1 = onePart.split("=");
            costStrategyDao.setCost(Integer.valueOf(split1[1]));
            String[] split2 = split1[0].split("-");
            costStrategyDao.setStartDays(Integer.valueOf(split2[0]));
            costStrategyDao.setEndDays(Integer.valueOf(split2[1]));
            costStrategyDaoList.add(costStrategyDao);
        }
        return costStrategyDaoList;
    }

    @Override
    public String encodeCostStrategy(List<CostStrategyDao> list) {
        StringBuilder stringBuilder = new StringBuilder();
        String prefix = "";
        for (CostStrategyDao costStrategyDao : list) {
            stringBuilder
                    .append(prefix)
                    .append(costStrategyDao.getStartDays())
                    .append("-")
                    .append(costStrategyDao.getEndDays())
                    .append("=");
            prefix = "_";
            stringBuilder
                    .append(costStrategyDao.getCost());
        }
        return stringBuilder.toString();
    }
}
