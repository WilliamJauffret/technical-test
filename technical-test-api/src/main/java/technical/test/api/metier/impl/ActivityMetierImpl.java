package technical.test.api.metier.impl;

import io.swagger.util.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technical.test.api.mapper.ActivityMapper;
import technical.test.api.metier.ActivityMetier;
import technical.test.api.persistence.dao.ActivityRepository;
import technical.test.api.persistence.model.Activity;
import technical.test.api.v1.dto.ActivityDTO;

import java.util.Optional;

@Service
public class ActivityMetierImpl implements ActivityMetier {

    private static final Logger log = LoggerFactory.getLogger(ActivityMetierImpl.class);

    final
    ActivityRepository activityDao;

    final
    ActivityMapper activityMapper;

    public ActivityMetierImpl(ActivityMapper activityMapper, ActivityRepository activityDao) {
        this.activityMapper = activityMapper;
        this.activityDao = activityDao;
    }

    @Override
    public ActivityDTO addActivity(ActivityDTO activityToAdd) {
         Activity activitySaved = activityDao.save(activityMapper.toActivity(activityToAdd));

         log.debug("Activity saved => " + Json.pretty(activitySaved));

         return activityMapper.toActivityDto(activitySaved);
    }

    @Override
    public ActivityDTO getActivityById(String id) {

        Optional<Activity> activityFinded = activityDao.findById(id);
        if(activityFinded.isPresent()){
            return activityMapper.toActivityDto(activityFinded.get());
        } else {
            return null;
        }
    }
}
