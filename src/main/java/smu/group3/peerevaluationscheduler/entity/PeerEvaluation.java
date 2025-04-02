package smu.group3.peerevaluationscheduler.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name="Peer_Evaluation")
public class PeerEvaluation {
    //~ Fields ---------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, name="Evaluation_ID")
    private int evaluationId;

    @Column(name="Group_ID")
    private int groupId;

    @Column(name="Start_Date")
    private LocalDate startDate;

    @Column(name="Due_Date")
    private LocalDate dueDate;


    //~ Constructors --------------------------------------------------------------------

    // default constructor
    public PeerEvaluation() {}


    // parameterized constructor
    public PeerEvaluation(int groupId, LocalDate startDate, LocalDate dueDate) {
        this.groupId = groupId;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }
}
