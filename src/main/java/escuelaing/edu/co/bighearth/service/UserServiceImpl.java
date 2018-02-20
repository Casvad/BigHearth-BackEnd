package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.EventType;
import escuelaing.edu.co.bighearth.model.Organization;
import escuelaing.edu.co.bighearth.model.User;
import escuelaing.edu.co.bighearth.model.Volunteer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;


@Service
public class UserServiceImpl implements UserService{

    private List<User> users = new ArrayList<>();


    public UserServiceImpl()
    {
    }

    /**
     * Search a specific user in global list
     * @param username
     * @return Return the user with the username 
     */
    private User searchUserName(String username){
        for (User us : users) {
            if(us.getUsername().equals(username)){
                return us;
            }
        }
        return null;
    }


    @PostConstruct
    private void populateSampleData()
    {
        users.add(new User( "martinjhm271", "123","","","","","",new HashSet<EventType>(),0));
        users.add(new Volunteer("carlos.ramirez-ot", "asd123","carlos.ramirez-ot@mail.escuelaing.edu.co","Cundinamarca","Bogota","","",new HashSet<EventType>(),0,"","","", new java.util.Date(),1));
        users.add(new Organization("microsoft2997", "qwerty123" , "microsoft@hotmail.com","California","Sillicon Valley","","",new HashSet<EventType>(),0,"Microsoft-Inc","Microsoft eu",1234));
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( String username ) {
        for(User us : users){
            if(us.getUsername().equals(username)){
                return us;
            }
        }
        return null;
    }

    /**
    *   Modify the user profile depend of the kind of user
    *   @param User
    *   @return user with the new profile values
    */
    @Override
    public User editConfigUser(User modUser) throws ServicesException {
        synchronized (users){
            User findUser = searchUserName(modUser.getUsername());
            if( findUser == null){
                throw new ServicesException("No se encuentra el usuario para modificar su perfil");
            }else{
                findUser.setAddress(modUser.getAddress());
                findUser.setState(modUser.getState());
                findUser.setCity(modUser.getCity());
                findUser.setPassword(modUser.getPassword());
                findUser.setDescription(modUser.getDescription());
                if(findUser instanceof Volunteer){
                    ((Volunteer)findUser).setName(((Volunteer)modUser).getName());
                    ((Volunteer)findUser).setLastname(((Volunteer)modUser).getLastname());
                    ((Volunteer)findUser).setBornDate(((Volunteer)modUser).getBornDate());
                    
                }else if(findUser instanceof Organization){
                    ((Organization)findUser).setBusinessName(((Organization)modUser).getBusinessName());
                    ((Organization)findUser).setCommercialName(((Organization)modUser).getCommercialName());
                    ((Organization)findUser).setNIT(((Organization)modUser).getNIT());
                }
                findUser.modifyUserInterest(modUser.getInterest());
                
            }
            
            return findUser;
        }


    }


}