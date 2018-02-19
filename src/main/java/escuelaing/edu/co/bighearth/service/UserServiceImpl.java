package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.EventType;
import escuelaing.edu.co.bighearth.model.User;
import escuelaing.edu.co.bighearth.model.Volunteer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.*;


@Service
public class UserServiceImpl implements UserService{

    private List<User> users = new ArrayList<>();
    private List<Volunteer> volunteers = new ArrayList<>();


    public UserServiceImpl()
    {
    }

    private boolean consultExistingUsername(String username){
        for(User us : users){
            if(us.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }


    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "martinjhm271", "123","","","","","",new HashSet<EventType>(),0) );
        volunteers.add(new Volunteer("carlos.ramirez-ot", "asd123","carlos.ramirez-ot@mail.escuelaing.edu.co","Cundinamarca","Bogota","","",new HashSet<EventType>(),0,"","","", (Date) new java.util.Date(),1));
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( String username ) {
        User u=new User();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                return users.get(i);
            }
        }
        return u;
    }

    /*
    *  Se modifican los datos de usuario si el correo como llave principal está dentro de los usuarios ya registrados
    * */
    @Override
    public Volunteer editConfigVolunteer(String mail, String state, String city, String address, String password, String description, Set<EventType> interest, String name, String lastname, Date bornDate) {
        synchronized (volunteers){
            for (Volunteer volunteer: volunteers) {
                //Usuario encontrado
                if(volunteer.confirmUserEmail(mail)){
                    volunteer.setAddress(address);
                    volunteer.setState(state);
                    volunteer.setCity(city);
                    volunteer.setPassword(password);
                    volunteer.setDescription(description);
                    volunteer.modifyUserInterest(interest);
                    volunteer.setName(name);
                    volunteer.setLastname(lastname);
                    volunteer.setBornDate(bornDate);
                    return volunteer;
                }
            }
            return null;
        }


    }


}