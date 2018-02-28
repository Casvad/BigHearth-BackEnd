package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.EventId;


import java.util.*;

public interface EventService {

    List<Event> getEvents();

    Event getEventById( EventId eventid );

    Event createEvent(Event event,String organitation);

    List<Event> getUserListEvent(String username);
    boolean unrolUser(int id, String username);

    boolean rolUser(int id, String username);
    boolean sendMailEvent(EventId eventId,List<String> mailInfo);

}