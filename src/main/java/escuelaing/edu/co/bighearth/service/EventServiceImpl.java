package escuelaing.edu.co.bighearth.service;

import escuelaing.edu.co.bighearth.model.Event;
import escuelaing.edu.co.bighearth.model.EventId;
import escuelaing.edu.co.bighearth.model.User;
import escuelaing.edu.co.bighearth.model.Volunteer;
import escuelaing.edu.co.bighearth.mail.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;


@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private UserService userService;

    private static List<Event> events = new ArrayList<>();

    public EventServiceImpl() { }
    
    
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
        events.add( new Event( new EventId(2, "Voluntarios para proyecto en línea en madrid") , 30 , "EDUCATIVO",
        "Se necesitan personas voluntarias para tutorías individualizadas, a niños y niñas preadolescentes  "+
        "con problemas de integración familiar, escolar y social.", new Date(2018), blop,voluntieers));
        events.add( new Event( new EventId(3,"Acompañamiento en residencias de la tercera edad") , 100 , "OCIO Y TIEMPO LIBRE",
        "Necesitamos voluntari@s que se ofrezcan para hacerle un poquito de compañía a una señora que está en una Residencia de la tercera edad ",
        new Date(2018), blop,voluntieers));

        userService.getUser("carlos.ramirez-ot").addEventList(events.get(0));
        userService.getUser("carlos.ramirez-ot").addEventList(events.get(1));
        userService.getUser("carlos.ramirez-ot").addEventList(events.get(2));
        events.get(0).getVolunteers().add(userService.getUser("carlos.ramirez-ot").getUsername());

    }


    @Override
    public List<Event> getEvents()
    {
        return events;
    }

    @Override
    public Event getEventById( EventId eventId ) {
        Event event=new Event();
        System.out.println(eventId.getName());
        System.out.println(eventId.getId());
        for(int i = 0;i < events.size();i++){
            System.out.println(events.get(i).getEventId().getId());
            System.out.println(events.get(i).getEventId().getName());
            if(events.get(i).getEventId().getId()==eventId.getId()){
                return events.get(i);
            }
        }
        return event;
    }

    @Override
    public Event createEvent( Event event ,String  organitation ) {
            int provisionalId =events.get(events.size()-1).getEventId().getId()+1;
            event.setEventId(new EventId(provisionalId,event.getEventId().getName()));
            for(Event e: events){
                if(!(e.getEventId().getId()==event.getEventId().getId() &&e.getEventId().getName()==event.getEventId().getName())){
                    userService.getUser(organitation).addEventList(event);
                    events.add(event);
                }
            }
        return event;
    }

    @Override
    public List<Event> getUserListEvent(String username) {
        User findUser = userService.getUser(username);
        return findUser!=null? findUser.getEventRegistered():new ArrayList<Event>();
    }

    @Override
    public boolean sendMailEvent(EventId eventId, List<String> mailInfo) {
        List<String> emails=new ArrayList<>();
        for ( Event e : events){
            if (e.getEventId().sameEventId(eventId)){
                for (String user: e.getVolunteers()){
                    emails.add(userService.getUser(user).getMail());
                }
            }
        }
        return Mail.sendEmail(emails,mailInfo);
    }



}
