package escuelaing.edu.co.bighearth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Volunteer extends User implements Serializable {
    private String name, lastname, gender;
    private Date bornDate;
    private int hours;

    public Volunteer() {}

    public Volunteer(String username, String password, String mail, String state, String city, String address, String description, List<String> interest, int volunteersMade, List<Event> eventRegistered, String name, String lastname, String gender, Date bornDate, int hours) {
        super(username, password, mail, state, city, address, description, interest, volunteersMade, eventRegistered);
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.bornDate = bornDate;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean confirmEventInscription(int idEvent){
        for (Event event: this.getEventRegistered() ) {
            if(event.getId() == idEvent){
                return true;
            }
        }
        return false;
    }

    public boolean leaveEvent(int idEvent){
        Event eventToLeave = null;
        for (Event event: this.getEventRegistered() ) {
            if(event.getId() == idEvent){
                eventToLeave = event;
            }
        }
        return this.getEventRegistered().remove(eventToLeave);
    }
}
