package api_service.DataAccessLayer;

import api_service.models.User;
import java.util.ArrayList;

/**
 * Created by js on 19/04/16.
 */
public class UserDAO {

    private ArrayList<User> usersDB;

    public UserDAO(){
        usersDB = new ArrayList<User>();

        User newUser = registerUser("biscoito", "biscoito@gmail.com", "424242",
            "123", "123", "424242", "far away", "uma aí", 0);

        usersDB.add(newUser);
    }

    public User registerUser(String name, String email,
                             String school_id, String password,
                             String password2, String phoneNumber,
                             String neighborhood, String street,
                             int vehicleSeats){

        // Instantiate new user
        User newUser = new User(name, email, school_id,
                password, password2, phoneNumber,
                neighborhood, street, vehicleSeats);

        // Save new user
        usersDB.add(newUser);

        return newUser;
    }

    // TEMP
    public void listUsers(){
        for (User user: usersDB) {
            System.out.println(user);
            System.out.println();
        }
    }
    public User authenticateUser(String school_id, String password) {
        System.out.println(school_id);
        for (User user : usersDB) {
            if (user.getSchoolId().equals(school_id) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
