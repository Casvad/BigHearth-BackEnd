package is.escuelaing.edu.co.BigHearth.service;



import is.escuelaing.edu.co.BigHearth.model.Organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> getOrganizations();

    Organization getOrganization( Long id );

    Organization createOrganization( Organization organization );
}
