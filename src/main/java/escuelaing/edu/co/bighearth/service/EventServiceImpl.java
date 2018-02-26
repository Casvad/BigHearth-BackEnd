package escuelaing.edu.co.bighearth.service;

import com.sun.crypto.provider.BlowfishParameters;
import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.EventId;
import escuelaing.edu.co.bighearth.model.User;
import escuelaing.edu.co.bighearth.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Array;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;


@Service
public class EventServiceImpl implements EventService{

    private List<Event> events = new ArrayList<>();


    public EventServiceImpl()
    {
    }


    @PostConstruct
    private void populateSampleData() {
        ArrayList<String> voluntieers = new ArrayList<>();
        String blop = "https://78.media.tumblr.com/1fb1cfbe837fa1e2894e89143cd5d4a5/tumblr_ozne1faCKB1td5qjgo1_500.gif";
        events.add(new Event( new EventId(0,"Asistencia a la mujer y la infancia"),20 , "COMUNITARIO",
        "Necesitamos profesor de inglés para impartir curso básico a las madres que acuden a la fundación, el curso está enfocado "+
        "para su mejora formativa y laboral, tiene una duración de una hora y se imparte solo un día a la semana.", new Date(2018),blop,voluntieers));
        events.add( new Event( new EventId(1, "Refuerzo escolar en ies") , 50 , "EDUCATIVO",
        "Se necesitan voluntarios para impartir clases de repaso escolar, a menores en riesgo de exclusión social de 12 a 18 años, "+
        "para su mejora formativa y laboral, tiene una duración de una hora y se imparte solo un día a la semana.", new Date(2018),blop,voluntieers));
        events.add( new Event( new EventId(2, "Voluntarias/os para proyecto en línea en madrid") , 30 , "EDUCATIVO",
        "Se necesitan personas voluntarias para tutorías individualizadas, a niños y niñas preadolescentes  "+
        "con problemas de integración familiar, escolar y social.", new Date(2018), blop,voluntieers));
        events.add( new Event( new EventId(3,"Acompañamiento en residencias de la tercera edad") , 100 , "OCIO Y TIEMPO LIBRE",
        "Necesitamos voluntari@s que se ofrezcan para hacerle un poquito de compañía a una señora que está en una Residencia de la tercera edad ",
        new Date(2018), blop,voluntieers));
    }


    @Override
    public List<Event> getEvents()
    {
        return events;
    }

    @Override
    public Event get( EventId eventId ) {
        Event event=new Event();
        for(int i=0;i<events.size();i++){
            if(events.get(i).getEventId().getId()==eventId.getId() &&events.get(i).getEventId().getName()==eventId.getName()){
                return events.get(i);
            }
        }
        return event;
    }

    @Override
    public Event create( Event event ) {
        int provisionalId =events.get(events.size()-1).getEventId().getId()+1;
        event.setEventId(event.getEventId().setId(provisionalId));
        for(Event e: events){
            if(!(e.getEventId().getId()==event.getEventId().getId() &&e.getEventId().getName()==event.getEventId().getName())){
                events.add(event);
            }
        }
        return event;
    }


}