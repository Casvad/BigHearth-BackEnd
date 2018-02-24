package escuelaing.edu.co.bighearth.controller;


import escuelaing.edu.co.bighearth.model.Organization;
import escuelaing.edu.co.bighearth.model.User;
import escuelaing.edu.co.bighearth.model.Volunteer;
import escuelaing.edu.co.bighearth.service.ServicesException;
import escuelaing.edu.co.bighearth.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping( "user" )
public class UserController
{

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login(@RequestBody User login )
        throws ServletException
    {

         String jwtToken = "";

        if ( login.getUsername() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String username = login.getUsername();
        String password = login.getPassword();

        User user = userService.getUser( "martinjhm271" );

        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }

        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    @RequestMapping( value = "/users", method = RequestMethod.GET)
    public List<User> volunteers(){
        return userService.getUsers();
    }

    @RequestMapping( value = "/modifyProfileVol", method = RequestMethod.PUT)
    public User modifyProfileVolunteer(@RequestBody Volunteer modUser){
        try{
            return userService.editConfigUser(modUser);
        }catch(ServicesException servException){
            return null;
        }
    }

    @RequestMapping( value = "/modifyProfileOrg", method = RequestMethod.PUT)
    public User modifyProfileOrganization(@RequestBody Organization modUser){
        try{
            return userService.editConfigUser(modUser);
        }catch(ServicesException servException){
            return null;
        }
    }


    public class Token
    {

        private String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}