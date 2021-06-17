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
import technical.test.api.persistence.services.NextSequenceService;
import technical.test.api.v1.dto.ActivityDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityMetierImpl implements ActivityMetier {

    private static final Logger log = LoggerFactory.getLogger(ActivityMetierImpl.class);

    final
    ActivityRepository activityDao;

    final
    ActivityMapper activityMapper;

    final
    NextSequenceService nextSequenceService;

    public ActivityMetierImpl(ActivityMapper activityMapper, ActivityRepository activityDao, NextSequenceService nextSequenceService) {
        this.activityMapper = activityMapper;
        this.activityDao = activityDao;
        this.nextSequenceService = nextSequenceService;
    }

    @Override
    public ActivityDTO addActivity(ActivityDTO activityToAdd) {
        Activity activityToSave = activityMapper.toActivity(activityToAdd);
        activityToSave.setId(nextSequenceService.getNextSequence("customSequences"));
        Activity activitySaved = activityDao.save(activityToSave);

        log.debug("Activity saved => " + Json.pretty(activitySaved));

        return activityMapper.toActivityDto(activitySaved);
    }

    @Override
    public List<ActivityDTO> addMultipleActivity(List<ActivityDTO> activityDTOList) {
        List<Activity> activityList = new ArrayList<>();
        for (ActivityDTO activite : activityDTOList
        ) {

            Activity actToAdd = activityMapper.toActivity(activite);
            actToAdd.setId(nextSequenceService.getNextSequence("customSequences"));
            activityList.add(actToAdd);

        }

        List<Activity> result = activityDao.saveAll(activityList);

        return activityMapper.toActivityDtoList(result);
    }

    @Override
    public ActivityDTO getActivityById(String id) {

        Optional<Activity> activityFinded = activityDao.findById(id);
        if (activityFinded.isPresent()) {
            return activityMapper.toActivityDto(activityFinded.get());
        } else {
            return null;
        }
    }

    @Override
    public List<ActivityDTO> getAllActivity() {
        List<Activity> allActivity = activityDao.findAll();
        return  activityMapper.toActivityDtoList(allActivity);
    }
}
