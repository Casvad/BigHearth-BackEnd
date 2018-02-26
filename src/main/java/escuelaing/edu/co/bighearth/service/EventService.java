package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.User;

import java.util.*;

public interface EventService {

    List<Event> getEvents();

    Event getEventById( int eventid );

    Event createEvent(Event event);

    List<Event> getUserListEvent(String username);
    

}