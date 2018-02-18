import by.itacademy.ApplicationContextHolder;
import by.itacademy.CarService;
import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewcars")
public class ViewCars extends HttpServlet {

    private static final CarService CAR_SERVICE = ApplicationContextHolder.getBean(CarService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer page;
        try {
            page = Integer.valueOf(req.getParameter("page"));
        } catch (NumberFormatException e) {
            page = 1;
        }
        Integer limit = Integer.valueOf((String) session.getAttribute("limit"));
//        CarDto carDto = new CarDto((String) session.getAttribute("manufacture"), (String) session.getAttribute("model"),
//                Integer.valueOf((String) session.getAttribute("minYear")), Integer.valueOf((String) session.getAttribute("maxYear")),
//                limit, page);

//        CarDto carDto = new CarDto(
//                (String) session.getAttribute("manufacture"),
//                (String) session.getAttribute("model"),
//                (String) session.getAttribute("vehicleCategoryName"),
//                Integer.valueOf((String) session.getAttribute("minYear")),
//                Integer.valueOf((String) session.getAttribute("maxYear")),
//                limit,
//                page,
//                Integer.valueOf((String) session.getAttribute("standardPriceMin")),
//                Integer.valueOf((String) session.getAttribute("standardPriceMax")),
//                (String) session.getAttribute("transmission"),
//                (String) session.getAttribute("gearbox")
//                );

        CarDto carDto = new CarDto();
        if (!session.getAttribute("manufacture").equals("")) {
            carDto.setManufacture((String) session.getAttribute("manufacture"));
        }
        if (!session.getAttribute("model").equals("")) {
            carDto.setModel((String) session.getAttribute("model"));
        }
//        if (!session.getAttribute("vehicleCategoryName").equals("")) {
//            carDto.setVehicleCategoryName((String) session.getAttribute("vehicleCategoryName"));
//        }
        if (!session.getAttribute("minYear").equals("")) {
            carDto.setYearMin(Integer.valueOf((String) session.getAttribute("minYear")));
        }
        if (!session.getAttribute("maxYear").equals("")) {
            carDto.setYearMax(Integer.valueOf((String) session.getAttribute("maxYear")));
        }
        carDto.setPerPage(limit);
        carDto.setPage(page);
//        if (!session.getAttribute("standardPriceMin").equals("")) {
//            carDto.setYearMin(Integer.valueOf((String) session.getAttribute("standardPriceMin")));
//        }
//        if (!session.getAttribute("standardPriceMax").equals("")) {
//            carDto.setYearMin(Integer.valueOf((String) session.getAttribute("standardPriceMax")));
//        }
//        if (!session.getAttribute("transmission").equals("")) {
//            carDto.setTransmission((String) session.getAttribute("transmission"));
//        }
//        if (!session.getAttribute("gearbox").equals("")) {
//            carDto.setGearbox((String) session.getAttribute("gearbox"));
//        }

        List<Car> carsByParams = CAR_SERVICE.getCarsByParams(carDto);
        req.setAttribute("cars", carsByParams);
        req.setAttribute("pages", Math.ceil(CAR_SERVICE.getCount(carDto) / limit));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/viewcars.jsp").forward(req, resp);
    }
}
