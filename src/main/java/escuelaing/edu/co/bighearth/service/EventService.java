package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.User;
import escuelaing.edu.co.bighearth.model.Volunteer;

import java.util.*;

public interface EventService {

    List<Event> getEvents();

    Event get( int eventid );

    Event create(Event event);

    List<Event> getUserListEvent(String username);

    User leaveEventUser(int idEvent, Volunteer volunteer);

}