package com.IA.Promo171.WikiHoax.backend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControleur {

    @Autowired
    private UserDao UserDao;

    @RequestMapping(value = "/user/{id}/new/", method = RequestMethod.POST)
    public User newUser(@PathVariable int id) {
        User newUser = new User( Long.valueOf(id));
        newUser = UserDao.newUser(newUser);
        return newUser;
    }

    @RequestMapping(value = "/user/connexion/", method = RequestMethod.GET)
    public boolean AutoriseconnexionUser(User usr) {
            if (UserDao.getUserMdp(usr.getIdentifiant()) == usr.getMdp()){
                return true; 
            }
            return false; 

    } 
}