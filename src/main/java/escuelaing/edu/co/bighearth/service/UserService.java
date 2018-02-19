package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.EventType;
import escuelaing.edu.co.bighearth.model.User;
import escuelaing.edu.co.bighearth.model.Volunteer;

import java.sql.Date;
import java.util.*;

public interface UserService {

    List<User> getUsers();

    User getUser( String username );

    Volunteer editConfigVolunteer(String mail, String state, String city, String address, String password, String description, Set<EventType> interest, String name, String lastname, Date bornDate);

}