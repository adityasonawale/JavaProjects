package com.example.spring_mvc_4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    private UserService userService;

    @RequestMapping("saveuser")
    public ModelAndView saveUser(User user) {
        userService.saveUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("message", "Registration Successful !");
        return modelAndView;
    }

    @RequestMapping("register")
    public String register() {
        return "register";
    }
    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("validate")
    ModelAndView validate(String usernameFromBrowser, String passwordFromBrowser) {
        String message;
        String viewPage;

        Session session = sessionFactory.openSession();
        User userFromDB = session.get(User.class, usernameFromBrowser);
        if (userFromDB == null) {
            message = "Username is Wrong";
            viewPage = "login";
        } else if (userFromDB.getPassword().equals(passwordFromBrowser)) {
            message = "Welcome You've Logged In Successfully ! " + usernameFromBrowser;
            viewPage = "welcome";
        } else {
            message = "Password is Wrong";
            viewPage = "login";
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewPage);
        modelAndView.addObject("message",message);
        return modelAndView;
    }
}
