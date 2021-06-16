package technical.test.api.mapper.impl;

import org.springframework.stereotype.Service;
import technical.test.api.mapper.ActivityMapper;
import technical.test.api.persistence.model.Activity;
import technical.test.api.v1.dto.ActivityDTO;

@Service
public class ActivityMapperImpl implements ActivityMapper {

    @Override
    public ActivityDTO toActivityDto(Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(activity.getId());
        activityDTO.setDescriptionCourte(activity.getDescriptionCourte());
        activityDTO.setDescriptionLongue(activity.getDescriptionLongue());
        activityDTO.setTitre(activity.getTitre());
        return activityDTO;
    }

    @Override
    public Activity toActivity(ActivityDTO activity) {
        Activity activityToReturn = new Activity();
        activityToReturn.setId(activity.getId());
        activityToReturn.setDescriptionCourte(activity.getDescriptionCourte());
        activityToReturn.setDescriptionLongue(activity.getDescriptionLongue());
        activityToReturn.setTitre(activity.getTitre());
        return activityToReturn;
    }
}
