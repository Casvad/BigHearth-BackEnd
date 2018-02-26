package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.EventId;

import java.util.*;

public interface EventService {

List<Event> getEvents();

Event get( EventId eventid );

Event create(Event event);

}