package escuelaing.edu.co.bighearth.controller;


import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.User;
import escuelaing.edu.co.bighearth.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "event" )
public class EventController {

    @Autowired
    private EventService eventService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST )
    public Event createUser(@RequestBody Event event) {
        return eventService.create(event);
    }

    @RequestMapping( value = "/userEvents/{username}", method = RequestMethod.GET)
    public List<Event> volunteers(@PathVariable String username){
        return eventService.getUserListEvent(username);
    }
}
