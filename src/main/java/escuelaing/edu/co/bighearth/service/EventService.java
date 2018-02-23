package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.Event;
import java.util.*;

public interface EventService {

List<Event> getEvents();

Event get( int eventid );

Event create(Event event);

}