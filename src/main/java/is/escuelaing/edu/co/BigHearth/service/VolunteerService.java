package is.escuelaing.edu.co.BigHearth.service;

import is.escuelaing.edu.co.BigHearth.model.Volunteer;

import java.util.List;

public interface VolunteerService {
    List<Volunteer> getVolunteers();

    Volunteer getVolunteer( Long id );

    Volunteer createVolunteer( Volunteer volunteer );
}
