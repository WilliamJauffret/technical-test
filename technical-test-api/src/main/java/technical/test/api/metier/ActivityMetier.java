package technical.test.api.metier;

import org.springframework.stereotype.Service;
import technical.test.api.v1.dto.ActivityDTO;


public interface ActivityMetier {

    public ActivityDTO addActivity(ActivityDTO activityToAdd);

    public ActivityDTO getActivityById(String id);
}
