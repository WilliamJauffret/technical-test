package technical.test.api.persistence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "activity")
@Data
public class Activity {

    @Id
    private String id;

    private String descriptionCourte;

    private String descriptionLongue;

    private String titre;


}
