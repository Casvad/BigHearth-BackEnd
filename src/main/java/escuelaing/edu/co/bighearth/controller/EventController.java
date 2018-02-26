package escuelaing.edu.co.bighearth.controller;

<<<<<<< HEAD

import escuelaing.edu.co.bighearth.model.Event;
=======
import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.Volunteer;
>>>>>>> origin/master
import escuelaing.edu.co.bighearth.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.Set;


>>>>>>> origin/master
@RestController
@RequestMapping( "event" )
public class EventController {

    @Autowired
    private EventService eventService;

    @CrossOrigin
<<<<<<< HEAD
    @RequestMapping(method = RequestMethod.POST )
    public Event createUser(@RequestBody Event event) {
        return eventService.create(event);
=======
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
>>>>>>> origin/master
    }
}