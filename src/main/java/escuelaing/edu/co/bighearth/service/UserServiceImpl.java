package escuelaing.edu.co.bighearth.service;


import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.Organization;
import escuelaing.edu.co.bighearth.model.User;
import escuelaing.edu.co.bighearth.model.Volunteer;
import escuelaing.edu.co.bighearth.security.SHA1;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;


@Service
public class UserServiceImpl implements UserService{

    private static List<User> users = new ArrayList<>();

    public UserServiceImpl() { }

    @PostConstruct
    private void populateSampleData() {
        String pass="asd123";
        try{
            pass=SHA1.generateHash(pass);
        }catch(Exception e){}

        users.add(new Volunteer("carlos.ramirez-ot", pass,"carlos.ramirez-ot@mail.escuelaing.edu.co","Cundinamarca","Bogota","","",new ArrayList<String>(),0,new ArrayList<Event>(),"","","", new java.util.Date(),1,"https://www.w3schools.com/w3css/img_lights.jpg"));
        users.add(new Organization("microsoft2997", pass, "microsoft@hotmail.com","California","Sillicon Valley","","",new ArrayList<String>(),0, new ArrayList<Event>(), "Microsoft-Inc","Microsoft eu",1234,"https://www.w3schools.com/w3css/img_lights.jpg"));
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

    @Override
    public List<User> getUsers() {
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
    *   @param modUser Usuario para editar su configuración
    *   @return user with the new profile values
    */
    @Override
    public User editConfigUser(User modUser) throws ServicesException {
        synchronized (this.users){
            User findUser = searchUserName(modUser.getUsername());
            if( findUser == null){
                throw new ServicesException("No se encuentra el usuario para modificar su perfil");
            }else{
                findUser.setAddress(modUser.getAddress());
                findUser.setMail(modUser.getMail());
                findUser.setState(modUser.getState());
                findUser.setCity(modUser.getCity());
                findUser.setPassword(modUser.getPassword());
                findUser.setDescription(modUser.getDescription());
                if(findUser instanceof Volunteer){
                    ((Volunteer)findUser).setName(((Volunteer)modUser).getName());
                    ((Volunteer)findUser).setLastname(((Volunteer)modUser).getLastname());
                    ((Volunteer)findUser).setBornDate(((Volunteer)modUser).getBornDate());
                    ((Volunteer)findUser).setGender(((Volunteer)modUser).getGender());
                    ((Volunteer)findUser).setHours(((Volunteer)modUser).getHours());
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