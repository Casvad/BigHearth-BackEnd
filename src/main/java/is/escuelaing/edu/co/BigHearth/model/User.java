package is.escuelaing.edu.co.BigHearth.model;

import java.util.Set;

public class User {

    private String mail, state, city, address, password, description;
    private Set<String> interest;
    private int volunteersMade;

    public User() {
    }

    public User(String mail, String state, String city, String address, String password, String description, Set<String> interest, int volunteersMade) {
        this.mail = mail;
        this.state = state;
        this.city = city;
        this.address = address;
        this.password = password;
        this.description = description;
        this.interest = interest;
        this.volunteersMade = volunteersMade;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getInterest() {
        return interest;
    }

    public void setInterest(Set<String> interest) {
        this.interest = interest;
    }

    public int getVolunteersMade() {
        return volunteersMade;
    }

    public void setVolunteersMade(int volunteersMade) {
        this.volunteersMade = volunteersMade;
    }
}
