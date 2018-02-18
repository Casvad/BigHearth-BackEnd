package is.escuelaing.edu.co.BigHearth.service;

import is.escuelaing.edu.co.BigHearth.model.Volunteer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService{

    private List<Volunteer> volunteers = new ArrayList<>();

    public VolunteerServiceImpl() {
    }

    @Override
    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    @Override
    public Volunteer getVolunteer(Long id) {
        return null;
    }

    @Override
    public Volunteer createVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
        return volunteer;
    }


}
