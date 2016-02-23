package com.kma.ais_dekanat.rest_api.resource_controller;


import com.kma.ais_dekanat.Application;
import com.kma.ais_dekanat.model.User;
import com.kma.ais_dekanat.security.TokenManager;
import com.kma.ais_dekanat.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {

    @RequestMapping("/auth")
    public static User authorize(@RequestParam(value="username") String userName, @RequestParam(value="password") String password) {
        User user = Application.ctx.getBean(UserService.class).getByLogin(userName); //TODO nira this is not ok
        if (user != null && user.getPassword() != null
                && user.getPassword().equals(password)) {
            user.setToken(TokenManager.generate());
            return user;
        }
        return null;
    }

    public static boolean isValid(String token) {
        return TokenManager.isValid(token);
    }

}