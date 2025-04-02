package smu.group3.peerevaluationscheduler.repository;

import smu.group3.peerevaluationscheduler.entity.PeerEvaluation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeerEvaluationRepository extends CrudRepository<PeerEvaluation, Integer> {
}
