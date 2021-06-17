package technical.test.api.metier;

import org.springframework.stereotype.Service;
import technical.test.api.v1.dto.ActivityDTO;

import java.util.List;


public interface ActivityMetier {

    public ActivityDTO addActivity(ActivityDTO activityToAdd);
    public List<ActivityDTO> addMultipleActivity(List<ActivityDTO> activityDTOList);


    public ActivityDTO getActivityById(String id);

    public List<ActivityDTO> getAllActivity();
}
