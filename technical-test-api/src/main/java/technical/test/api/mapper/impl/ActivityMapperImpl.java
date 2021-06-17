package technical.test.api.mapper.impl;

import org.springframework.stereotype.Service;
import technical.test.api.mapper.ActivityMapper;
import technical.test.api.persistence.model.Activity;
import technical.test.api.v1.dto.ActivityDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityMapperImpl implements ActivityMapper {

    @Override
    public ActivityDTO toActivityDto(Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setDescriptionCourte(activity.getDescriptionCourte());
        activityDTO.setDescriptionLongue(activity.getDescriptionLongue());
        activityDTO.setTitre(activity.getTitre());
        return activityDTO;
    }

    @Override
    public Activity toActivity(ActivityDTO activity) {
        Activity activityToReturn = new Activity();
        activityToReturn.setDescriptionCourte(activity.getDescriptionCourte());
        activityToReturn.setDescriptionLongue(activity.getDescriptionLongue());
        activityToReturn.setTitre(activity.getTitre());
        return activityToReturn;
    }

    @Override
    public List<Activity> toActivityList(List<ActivityDTO> activiteDtoList) {
        List<Activity> listToReturn = new ArrayList<>();
        for (ActivityDTO activiteDto : activiteDtoList
        ) {
            listToReturn.add(toActivity(activiteDto));
        }

        return listToReturn;
    }

    @Override
    public List<ActivityDTO> toActivityDtoList(List<Activity> activityList) {
        List<ActivityDTO> listToReturn = new ArrayList<>();
        for (Activity activity : activityList
        ) {
            listToReturn.add(toActivityDto(activity));
        }

        return listToReturn;
    }
}
