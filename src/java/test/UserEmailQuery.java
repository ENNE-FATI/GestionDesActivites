/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UserDao;
import entities.User;
import java.util.List;

/**
 *
 * @author pc
 */
public class UserEmailQuery {
    public static void main(String[] args) {
    UserDao ud = new UserDao();
    List<User> users = ud.findByEmail("ennesyryfati@gmail.com");
    
    for (User u : users) {
        System.out.println("Nom : " + u.getNom());
    }
}

}
