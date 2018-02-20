package escuelaing.edu.co.bighearth.model;

import java.sql.Blob;
import java.util.Date;

public class Event {
    private int id, numberOfVolunteers;
    private EventType eventType;
    private String name, description;
    private Date eventDate;
    private Blob image;

    public Event() {
    }

    public Event(int id, int numberOfVolunteers, String name, EventType eventType, String description, Date eventDate, Blob image) {
        this.id = id;
        this.numberOfVolunteers = numberOfVolunteers;
        this.name = name;
        this.eventType = eventType;
        this.description = description;
        this.eventDate = eventDate;
        this.image = image;
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

    public EventType getType() {
        return eventType;
    }

    public void setType(EventType eventType) {
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

    public void setImage(Blob image) {
        this.image = image;
    }
}
