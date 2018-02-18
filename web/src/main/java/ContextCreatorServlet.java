import by.itacademy.ApplicationContextHolder;

import javax.servlet.http.HttpServlet;

public class ContextCreatorServlet extends HttpServlet {
    public ContextCreatorServlet() {
        super();
    }

    @Override
    public void destroy() {
        ApplicationContextHolder.destroy();
    }

}
