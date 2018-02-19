package escuelaing.edu.co.bighearth.model;

import escuelaing.edu.co.bighearth.model.User;

public class Organization extends User{
    private String commercialName, businessName;
    private int NIT;

    public Organization() {
    }

    public Organization(String commercialName, String businessName, int NIT) {
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
}
