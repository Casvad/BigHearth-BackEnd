package is.escuelaing.edu.co.BigHearth.service;

import is.escuelaing.edu.co.BigHearth.model.Organization;


import java.util.ArrayList;
import java.util.List;

public class OrganizationServiceImpl implements OrganizationService{

    private List<Organization> organizations = new ArrayList<>();

    @Override
    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public Organization getOrganization(Long id) {
        return null;
    }

    @Override
    public Organization createOrganization(Organization organization) {
        organizations.add(organization);
        return organization;
    }
}
