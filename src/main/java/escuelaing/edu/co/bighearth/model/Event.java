package escuelaing.edu.co.bighearth.model;

import java.sql.Blob;
import java.util.Date;
import java.util.ArrayList;
import java.util.*;

import escuelaing.edu.co.bighearth.model.User;

public class Event {

    private EventId eventId;

    private int maxVolunteers;
    private String eventType;
    private String description;
    private Date eventDate;
    private String image;
    private Localitation localitation;
    private List<String> volunteers=new ArrayList<>();
    private String organization;

    public Event(){

    }


    public Event(EventId eventId,int maxVolunteers, String eventType, String description, Date eventDate, String image,List<String> volunteers,String organization,Localitation localitation) {

        this.eventId = eventId;
        this.maxVolunteers=maxVolunteers;
        this.eventType = eventType;
        this.description = description;
        this.eventDate = eventDate;
        this.image = image;
        this.volunteers = volunteers;
        this.organization=organization;
        this.localitation = localitation;
    }

    public EventId getEventId() {return eventId; }

    public void setEventId(EventId eventId) {
        this.eventId = eventId;
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

    public String getOrganization(){
        return this.organization;
    }

    public void setOrganization(String organization){
        this.organization=organization;
    public void setLocalitation(Localitation localitation) {
        this.localitation = localitation;
    }

    public Localitation getLocalitation() {
        return localitation;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //Fase beta
    public boolean addVolunteerEvent(Volunteer volunteerToRegister){
        this.volunteers.add(volunteerToRegister.getUsername());
        return true;
    }

}
