package escuelaing.edu.co.BigHearth.service;

import escuelaing.edu.co.BigHearth.model.User;
import java.util.*;

public interface UserService {

List<User> getUsers();

User getUser( String username );

}