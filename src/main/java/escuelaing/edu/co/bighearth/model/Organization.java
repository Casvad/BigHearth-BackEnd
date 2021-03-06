package escuelaing.edu.co.bighearth.model;

import java.util.List;

public class Organization extends User {
    private String commercialName, businessName;
    private int NIT;
    private int volunteersMade=-1;

    public Organization() {
    }

    public Organization(String username, String password, String mail, String state, String city, String address, String description, List<String> interest, int volunteersMade, List<Event> eventRegistered, String commercialName, String businessName, int NIT,String image) {
        super(username, password, mail, state, city, address, description, interest, volunteersMade,eventRegistered, image);
        this.commercialName = commercialName;
        this.businessName = businessName;
        this.NIT = NIT;
    }


    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public int getVolunteersMade() {
        return volunteersMade;
    }

    public void setVolunteersMade(int volunteersMade) {
        this.volunteersMade = volunteersMade;
    }
}
