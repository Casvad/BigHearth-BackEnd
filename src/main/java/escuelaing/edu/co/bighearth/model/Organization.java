package escuelaing.edu.co.bighearth.model;

import escuelaing.edu.co.bighearth.model.User;

public class Organization extends User{
    private String commercialName, businessName;
    private int NIT;
    private int volunteersMade=-1;

    public Organization() {
    }

    public Organization(String commercialName, String businessName, int NIT,int volunteersMade) {
        this.commercialName = commercialName;
        this.businessName = businessName;
        this.NIT = NIT;
        this.volunteersMade=volunteersMade;
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
