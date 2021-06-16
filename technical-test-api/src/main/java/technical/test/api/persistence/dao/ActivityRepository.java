package technical.test.api.persistence.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import technical.test.api.persistence.model.Activity;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
}
