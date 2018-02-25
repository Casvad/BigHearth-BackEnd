package escuelaing.edu.co.bighearth.model;

import java.sql.Blob;
import java.util.Date;
import java.util.ArrayList;

public class Event {
    private int id, numberOfVolunteers;
    private String eventType;
    private String name, description;
    private Date eventDate;
    private Blob image;
    private ArrayList<Volunteer> volunteers;


    public Event(){

    }

    public Event(int id, int numberOfVolunteers, String name, String type, String description, Date eventDate, Blob image, ArrayList<Volunteer> volunteers) {
        this.id = id;
        this.numberOfVolunteers = numberOfVolunteers;
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

    public int getNumberOfVolunteers() {
        return numberOfVolunteers;
    }

    public void setNumberOfVolunteers(int numberOfVolunteers) {
        this.numberOfVolunteers = numberOfVolunteers;
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

    public Blob getImage() {
        return image;
    }

    public void  setImage(Blob image) { this.image = image;}

    public ArrayList<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(ArrayList<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

    //Fase beta
    public boolean addVolunteerEvent(Volunteer volunteerToRegister){
        this.volunteers.add(volunteerToRegister);
        volunteerToRegister.addEventList(this);
        return true;
    }
}
