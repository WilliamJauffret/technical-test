package technical.test.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technical.test.api.metier.ActivityMetier;
import technical.test.api.v1.MultipleActivityApi;
import technical.test.api.v1.dto.ActivityDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class MultipleActivityImpl implements MultipleActivityApi {

    final
    ActivityMetier activityMetier;

    public MultipleActivityImpl(ActivityMetier activityMetier) {
        this.activityMetier = activityMetier;
    }


    @Override
    public ResponseEntity<List<ActivityDTO>> postMultipleActivity(@Valid List<ActivityDTO> activityDTO) {
        return null;
    }
}
