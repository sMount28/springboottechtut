package smu.group3.peerevaluationscheduler.entity;

import jakarta.persistence.*;

@Entity
@Table(name="`Groups`")
public class Group {
    //~ Fields ---------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, name="Group_ID")
    private int groupId;

    @Column(name="Course_ID")
    private int courseId;

    @Column(name="GroupName")
    private String groupName;


    //~ Constructor ---------------------------------------------------------------------

    // default constructor
    public Group() {}


    // parameterized constructor
    public Group(int groupId, int courseId, String groupName) {
        this.groupId = groupId;
        this.courseId = courseId;
        this.groupName = groupName;
    }


    //~ Methods -------------------------------------------------------------------------

    public int getGroupId() { return groupId; }

    public int getCourseId() { return courseId; }

    public String getGroupName() { return groupName; }
}
