package escuelaing.edu.co.bighearth.model;

import escuelaing.edu.co.bighearth.model.User;

import java.sql.Date;

public class Volunteer extends User{
    private String name, lastname, gender;
    private Date bornDate;
    private int hours;
    private int volunteersParticiped=-1;

    public Volunteer() {
    }

    public Volunteer(String name, String lastname, String gender, Date bornDate, int hours, int volunteersParticiped) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.bornDate = bornDate;
        this.hours = hours;
        this.volunteersParticiped=volunteersParticiped;
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

    public int getVolunteersParticiped() {
        return volunteersParticiped;
    }

    public void setVolunteersParticiped(int volunteersParticiped) {
        this.volunteersParticiped = volunteersParticiped;
    }
}
