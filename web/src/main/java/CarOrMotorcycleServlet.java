import by.itacademy.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/car_info")
public class CarOrMotorcycleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("infoabout", new UserService().getCarInfo());
        req.getRequestDispatcher("/WEB-INF/jsp/car_moto.jsp").forward(req, resp);
    }
}
