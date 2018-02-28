package escuelaing.edu.co.bighearth.service;
 
import escuelaing.edu.co.bighearth.model.User;
import escuelaing.edu.co.bighearth.model.Volunteer;
import escuelaing.edu.co.bighearth.model.Organization;

import java.util.*;

public interface UserService {

    List<User> getUsers();

    User getUser( String username );

    User createUser( User user );

    public User editConfigUser(User modUser) throws ServicesException;

    
}