package by.itacademy.controller;

import by.itacademy.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExceptionsController {

    public static final int ERROR_CODE_400 = 400;
    public static final int ERROR_CODE_401 = 401;
    public static final int ERROR_CODE_404 = 404;
    public static final int ERROR_CODE_405 = 405;
    public static final int ERROR_CODE_500 = 500;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public String notFound() {
        return "pagenotfound";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String badRequest() {
        return "badrequest";
    }

    @GetMapping(value = "errors")
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        ModelAndView errorPage = new ModelAndView("errorPage");
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            case ERROR_CODE_400:
                {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
                }
            case ERROR_CODE_401:
                {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
                }
            case ERROR_CODE_404:
                {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
                }
            case ERROR_CODE_405:
                {
                errorMsg = "Http Error Code: 405. Method Not Allowed. May be OptimisticLockException";
                break;
                }
            case ERROR_CODE_500:
                {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
                }
            default:
                {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
                }
        }
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }

}
