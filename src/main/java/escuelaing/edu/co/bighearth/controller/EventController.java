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

    @RequestMapping( method = RequestMethod.GET)
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @RequestMapping( value = "/{idEvent}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable int idEvent){
        return eventService.get(idEvent);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST )
    public Event createEvent(@PathVariable Event event){
        return eventService.create(event);
    }

    @RequestMapping( value = "/userEvents/{username}", method = RequestMethod.GET)
    public List<Event> volunteers(@PathVariable String username){
        return eventService.getUserListEvent(username);
    }

    @RequestMapping( value = "/leave/{idEvent}", method = RequestMethod.PUT)
    public List<Event> volunteers(@PathVariable int idEvent, @RequestBody Volunteer volunteer){
        eventService.leaveEventUser(idEvent,volunteer);
        return volunteer.getEventRegistered();
    }
}
