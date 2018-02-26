package escuelaing.edu.co.bighearth.model;

import java.sql.Blob;
import java.util.Date;
import java.util.*;

public class Event {

    private int id,maxVolunteers;
    private String eventType;
    private String name, description;
    private Date eventDate;
    private String image;

    private List<String> volunteers=new ArrayList<>();


    public Event(){

    }

    public Event(int id,int maxVolunteers, String name, String eventType, String description, Date eventDate, String image,List<String> volunteers) {

        this.id = id;
        this.maxVolunteers=maxVolunteers;
        this.name = name;
        this.eventType = eventType;
        this.description = description;
        this.eventDate = eventDate;
        this.image = image;
        this.volunteers = volunteers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return eventType;
    }

    public void setType(String eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getImage() {
        return image;
    }

    public void  setImage(String image) { this.image = image;}

    public List<String> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<String> volunteers) {
        this.volunteers = volunteers;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getMaxVolunteers() {
        return maxVolunteers;
    }

    public void setMaxVolunteers(int maxVolunteers) {
        this.maxVolunteers = maxVolunteers;
    }

    //Fase beta
    public boolean addVolunteerEvent(Volunteer volunteerToRegister){
        this.volunteers.add(volunteerToRegister.getUsername());
        return true;
    }



  
}
