package technical.test.api.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technical.test.api.metier.ActivityMetier;
import technical.test.api.v1.ActivityApi;
import technical.test.api.v1.dto.ActivityDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class ActivityApiImpl implements ActivityApi {

    @Autowired
    ActivityMetier activityMetier;

    @Override
    public ResponseEntity<ActivityDTO> getActivity(String id) {
        return null;
    }

    @Override
    public ResponseEntity<ActivityDTO> postActivity(String id, @Valid ActivityDTO activityDTO) {
        return new ResponseEntity<>(activityMetier.addActivity(activityDTO),HttpStatus.OK);

    }
}