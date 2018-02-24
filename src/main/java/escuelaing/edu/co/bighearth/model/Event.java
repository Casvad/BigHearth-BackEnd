package escuelaing.edu.co.bighearth.model;

import java.sql.Blob;
import java.sql.Date;

public class Event {
    private int id, numberOfVolunteers,maxVolunteers;
    private String name, type, description;
    private Date eventDate;
    private Blob image;
    private List<Volunteer> volunteers=new ArrayList<Volunteer>();

    public Event() {
    }

    public Event(int id, int numberOfVolunteers,int maxVolunteers, String name, String type, String description, Date eventDate, Blob image,List<Volunteer> volunteers) {
        this.id = id;
        this.numberOfVolunteers = numberOfVolunteers;
        this.maxVolunteers=maxVolunteers;
        this.name = name;
        this.type = type;
        this.description = description;
        this.eventDate = eventDate;
        this.image = image;
        this.volunteers=volunteers;
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
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setImage(Blob image) {
        this.image = image;
    }

    public int getMaxVolunteers() {
        return maxVolunteers;
    }

    public void setMaxVolunteers(int maxVolunteers) {
        this.maxVolunteers = maxVolunteers;
    }

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }
}
