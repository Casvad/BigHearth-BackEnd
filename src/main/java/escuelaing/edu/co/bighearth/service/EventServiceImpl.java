package escuelaing.edu.co.bighearth.service;

import com.sun.crypto.provider.BlowfishParameters;
import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.User;
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
        byte[] myvar = "Any String you want".getBytes();
        ArrayList<User> voluntieers = new ArrayList<User>();
        Blob blop = null;
        try {
            blop = new SerialBlob(myvar);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        events.add( new Event( 0 , 20 , "a profesor de inglés centro de asistencia a la mujer y la infancia " , "COMUNITARIO",
        "Necesitamos profesor de inglés para impartir curso básico a las madres que acuden a la fundación, el curso está enfocado "+
        "para su mejora formativa y laboral, tiene una duración de una hora y se imparte solo un día a la semana.", new Date(2018),blop,voluntieers));
        events.add( new Event( 1 , 50 , "Refuerzo escolar en ies" , "EDUCATIVO", 
        "Se necesitan voluntarios para impartir clases de repaso escolar, a menores en riesgo de exclusión social de 12 a 18 años, "+
        "para su mejora formativa y laboral, tiene una duración de una hora y se imparte solo un día a la semana.", new Date(2018),blop,voluntieers));
        events.add( new Event( 2 , 30 , "Voluntarias/os para proyecto en línea en madrid " , "EDUCATIVO", 
        "Se necesitan personas voluntarias para tutorías individualizadas, a niños y niñas preadolescentes  "+
        "con problemas de integración familiar, escolar y social.", new Date(2018), blop,voluntieers));
        events.add( new Event( 3 , 100 , "Acompañamiento en residencias de la tercera edad" , "OCIO Y TIEMPO LIBRE", 
        "Necesitamos voluntari@s que se ofrezcan para hacerle un poquito de compañía a una señora que está en una Residencia de la tercera edad ",
        new Date(2018), blop,voluntieers));
    }


    @Override
    public List<Event> getEvents()
    {
        return events;
    }

    @Override
    public Event get( int eventId ) {
        Event event=new Event();
        for(int i=0;i<events.size();i++){
            if(events.get(i).getId()==eventId){
                return events.get(i);
            }
        }
        return event;
    }

    @Override
    public Event create( Event event ) {
        events.add(event);
        return event;
    }


}