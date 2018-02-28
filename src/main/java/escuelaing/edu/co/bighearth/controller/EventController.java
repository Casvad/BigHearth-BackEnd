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
    @RequestMapping( value = "/{organitation}",method = RequestMethod.POST )
    public Event createEvent(@RequestBody Event event,@PathVariable String organitation){
        return eventService.createEvent(event,organitation);
    }

    @CrossOrigin
    @RequestMapping( value = "/{idEvent}.{nameEvent}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable String idEvent,@PathVariable String nameEvent){
        return eventService.getEventById(new EventId(Integer.parseInt(idEvent),nameEvent));
    }


    @CrossOrigin
    @RequestMapping(value="/sendMailEvent/{idEvent}.{nameEvent}",method = RequestMethod.POST )
    public boolean sendMailEvent(@PathVariable String idEvent,@PathVariable String nameEvent,@RequestBody List<String> mailInfo){
        return eventService.sendMailEvent(new EventId(Integer.parseInt(idEvent),nameEvent),mailInfo);
    }

    @CrossOrigin
    @RequestMapping( value = "/userEvents/{username}", method = RequestMethod.GET)
    public List<Event> getUserListEvent(@PathVariable String username){
        return eventService.getUserListEvent(username);
    }
}