package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.EventId;


import java.util.*;

public interface EventService {

    List<Event> getEvents();

    Event getEventById( EventId eventid );

    Event createEvent(Event event);

    List<Event> getUserListEvent(String username);
    
    boolean sendMailEvent(List<String> emails,List<String> mailInfo);

    boolean unrolUser(int id, String username);
}