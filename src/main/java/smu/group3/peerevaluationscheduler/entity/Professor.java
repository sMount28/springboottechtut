package smu.group3.peerevaluationscheduler.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Professor")
public class Professor {
    //~ Fields ---------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, name="Professor_ID")
    private int professorId;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="Email")
    private String email;

    @Column(name="Password")
    private String password;

    @Column(name="Department")
    private String department;


    //~ Constructor ---------------------------------------------------------------------

    // default constructor
    public Professor() {}


    // parameterized constructor
    public Professor(String firstName, String lastName, String email, String password, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.department = department;
    }


    //~ Methods -------------------------------------------------------------------------

    public int getProfessorId() {
        return professorId;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }
}
