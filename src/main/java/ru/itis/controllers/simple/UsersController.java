package ru.itis.controllers.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.models.User;
import ru.itis.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 11.10.2017
 * UsersController
 *
 * @author Victoria Noumenko
 * @version v1.0
 */

@Component
public class UsersController implements Controller {

    @Autowired
    private UsersService usersService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (httpServletRequest.getMethod().equals("GET")) {
            ModelAndView result = new ModelAndView("usersView");
            List<User> users = usersService.getAll();
            result.addObject("usersModel", users);
            return result;
        } else throw new IllegalArgumentException("Illegal request");
    }
}
