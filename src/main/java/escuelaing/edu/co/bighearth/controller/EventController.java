package escuelaing.edu.co.bighearth.controller;

import escuelaing.edu.co.bighearth.model.Event;
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
    @RequestMapping( value = "/{idEvent}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable int idEvent){
        return eventService.getEventById(idEvent);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST )
    public Event createEvent(@PathVariable Event event){
        return eventService.createEvent(event);
    }

    @CrossOrigin
    @RequestMapping( value = "/userEvents/{username}", method = RequestMethod.GET)
    public List<Event> getUserListEvent(@PathVariable String username){
        return eventService.getUserListEvent(username);
    }
}