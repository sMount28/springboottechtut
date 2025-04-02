package smu.group3.peerevaluationscheduler.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name="Course")
public class Course {

    //~Fields -----------------------------------

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, name="Course_ID")
    private int courseId;

    @Column(name="CourseCode")
    private String courseCode;

    @Column(name="CourseName")
    private String courseName;

    @Column(name="Professor_ID")
    private int professorId;

    @Column(name="Semester")
    private String semester;

    @Column(name="Year")
    private int year;


    //~ Constructor -------------------------------

    // default constructor
    public Course() {}


    // parameterized constructor
    public Course(String courseCode, String courseName, int professorId, String semester, int year) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professorId = professorId;
        this.semester = semester;
        this.year = year;
    }


    //~ Methods --------------------------------

    public int getCourseId() {
        return courseId;
    }


    public String getCourseName() {
        return courseName;
    }


    public int getProfessorId() {
        return professorId;
    }
}
