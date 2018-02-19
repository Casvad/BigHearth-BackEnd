package escuelaing.edu.co.BigHearth.service;

import escuelaing.edu.co.BigHearth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    private List<User> users = new ArrayList<>();


    public UserServiceImpl()
    {
    }


    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "martinjhm271", "123","","","","","",new ArrayList<String>(),"") );
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( String username )
    {   User u=new User();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                return users.get(i);
            }
        }
        return u;
    }




}