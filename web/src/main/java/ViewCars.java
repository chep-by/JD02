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
        CarDto carDto = new CarDto((String) session.getAttribute("manufacture"), (String) session.getAttribute("model"),
                Integer.valueOf((String) session.getAttribute("minYear")), Integer.valueOf((String) session.getAttribute("maxYear")),
                limit, page);
        List<Car> carsByParams = new CarService().getCarsByParams(carDto);
        req.setAttribute("cars", carsByParams);
        req.setAttribute("pages", Math.ceil(new CarService().getCount(carDto) / limit));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/viewcars.jsp").forward(req, resp);
    }
}
