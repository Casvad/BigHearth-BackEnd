package escuelaing.edu.co.bighearth.controller;


import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.EventId;
import escuelaing.edu.co.bighearth.model.Volunteer;
import escuelaing.edu.co.bighearth.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;



@RestController
@RequestMapping( "event" )
public class EventController {

    @Autowired
    private EventService eventService;

    @CrossOrigin
    @RequestMapping( method = RequestMethod.GET)
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST )
    public Event createEvent(@RequestBody Event event){
        return eventService.createEvent(event);
    }

    @CrossOrigin
    @RequestMapping( value = "/{idEvent.nameEvent}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable int idEvent,@PathVariable String nameEvent){
        return eventService.getEventById(new EventId(idEvent,nameEvent));
    }


    @CrossOrigin
    @RequestMapping(value="/sendMailEvent",method = RequestMethod.POST )
    public boolean sendMailEvent(@RequestBody List<String> emails,@RequestBody List<String> mailInfo){
        return eventService.sendMailEvent(emails,mailInfo);
    }

    @CrossOrigin
    @RequestMapping( value = "/userEvents/{username}", method = RequestMethod.GET)
    public List<Event> getUserListEvent(@PathVariable String username){
        return eventService.getUserListEvent(username);
    }
}