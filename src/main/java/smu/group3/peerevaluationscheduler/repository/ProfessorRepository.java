package smu.group3.peerevaluationscheduler.repository;

import smu.group3.peerevaluationscheduler.entity.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
    Professor findByEmailAndPassword(String email, String password);
    Professor findByProfessorId(int professorId);
}
