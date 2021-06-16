package technical.test.api.mapper;

import org.springframework.stereotype.Service;
import technical.test.api.persistence.model.Activity;
import technical.test.api.v1.dto.ActivityDTO;

public interface ActivityMapper {

    ActivityDTO toActivityDto(Activity activity);
    Activity toActivity(ActivityDTO activity);

}