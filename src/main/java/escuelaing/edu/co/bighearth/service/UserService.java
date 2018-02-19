package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.User;
import java.util.*;

public interface UserService {

List<User> getUsers();

User getUser( String username );

}