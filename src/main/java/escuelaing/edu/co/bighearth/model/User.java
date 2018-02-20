package escuelaing.edu.co.bighearth.model;

import java.util.*;


public class User{


    private String mail="", state="", city="", address="",username="", password="", description="";
    private Set<EventType> interest=new HashSet<>();
    private int volunteersMade=-1;


    public User(){

    }

    public User(String username,String password,String mail, String state, String city, String address, String description, Set<EventType> interest, int volunteersMade) {
        this.mail = mail;
        this.state = state;
        this.city = city;
        this.address = address;
        this.username=username;
        this.password = password;
        this.description = description;
        this.interest = interest;
        this.volunteersMade = volunteersMade;
    }


    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username=username;
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

    public Set<EventType> getInterest() {
        return interest;
    }

    public void setInterest(Set<EventType> interest) {
        this.interest = interest;
    }

    public int getVolunteersMade() {
        return volunteersMade;
    }

    public void setVolunteersMade(int volunteersMade) {
        this.volunteersMade = volunteersMade;
    }

    public boolean confirmUserEmail(String email) { return this.mail.equals(email); }

    public void modifyUserInterest(Set<EventType> newInterests){
        for (EventType event: interest) {
            if(!newInterests.contains(event)){
                interest.remove(event);
            }
        }
        for(EventType event : newInterests) {
            if (!interest.contains(event)) {
                interest.add(event);
            }
        }
    }

    public boolean equals (User us){
        if (this==us) return true;
        if (this == null) return false;
        if (this.getClass() != us.getClass()) return false;
        return this.mail.equals(us.getMail());
    }

    @Override
    public String toString()
    {
        return "User{" + "Username=" + this.username + ", password=" + this.password + '}';
    }
}