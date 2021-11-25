package pe.edu.upc.trabajo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pe.edu.upc.trabajo.business.crud.UserService;
import pe.edu.upc.trabajo.models.entities.User;


@ControllerAdvice(basePackages={"com.example.demo.controller"})
public class UserControllerAdvice {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User userInSession(String username) {
    User user = userService.findByUsername(username);
        return user;
    }
}
