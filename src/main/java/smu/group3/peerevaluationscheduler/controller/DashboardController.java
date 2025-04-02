package smu.group3.peerevaluationscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import smu.group3.peerevaluationscheduler.entity.Course;
import smu.group3.peerevaluationscheduler.entity.Professor;
import smu.group3.peerevaluationscheduler.repository.CourseRepository;
import smu.group3.peerevaluationscheduler.repository.ProfessorRepository;
import java.util.*;

@Controller
public class DashboardController {

    //~ fields --------------------------------------------------------------------------

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CourseRepository courseRepository;


    //~ Methods ------------------------------------------------------------------------

    // open the professor dashboard
    @GetMapping("/{pid}/professorDashboard")
    public String getProfessorDashboard(@PathVariable("pid") int professorId,
                                        Model model) {
        Professor professor = professorRepository.findByProfessorId(professorId);

        String name = professor.getFirstName() + " " + professor.getLastName();
        model.addAttribute("Name", name);

        List<Course> courses = courseRepository.findByProfessorId(professorId);

        model.addAttribute("Courses", courses);
        return "professorDashboard";
    }
}

