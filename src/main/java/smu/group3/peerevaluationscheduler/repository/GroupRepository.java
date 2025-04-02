package smu.group3.peerevaluationscheduler.repository;

import smu.group3.peerevaluationscheduler.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {
    List<Group> findByCourseId(int courseId);
}
