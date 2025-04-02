package smu.group3.peerevaluationscheduler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import smu.group3.peerevaluationscheduler.entity.Course;
import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findByProfessorId(int professorId);
}
