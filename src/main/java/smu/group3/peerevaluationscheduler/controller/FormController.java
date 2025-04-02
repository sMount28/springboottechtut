package smu.group3.peerevaluationscheduler.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import smu.group3.peerevaluationscheduler.entity.Group;
import smu.group3.peerevaluationscheduler.entity.Professor;
import smu.group3.peerevaluationscheduler.entity.PeerEvaluation;
import smu.group3.peerevaluationscheduler.repository.GroupRepository;
import smu.group3.peerevaluationscheduler.repository.PeerEvaluationRepository;
import smu.group3.peerevaluationscheduler.repository.ProfessorRepository;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FormController {

    //~ Fields ------------------------------------------------------------------------------

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PeerEvaluationRepository peerEvaluationRepository;

    @Autowired
    private ProfessorRepository professorRepository;


    //~ Methods -----------------------------------------------------------------------------

    // display the form page
    @GetMapping("/{pid}/{cid}/schedulePeerEvaluations")
    public String getForm(@PathVariable("pid") int pid,
                          @PathVariable("cid") int courseId,
                          Model model) {
        // get list of groups enrolled in courseId
        List<Group> groups = groupRepository.findByCourseId(courseId);

        // add groups to model
        model.addAttribute("groups", groups);

        return "schedulerForm";
    }


    // handle the form submission
    @PostMapping("/submit-evaluation")
    public String submitEvaluation(@RequestParam List<Integer> groupIds,
                                   @RequestParam@DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate startDate,
                                   @RequestParam@DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate dueDate) {
        for (int groupId : groupIds) {
            PeerEvaluation evaluation = new PeerEvaluation(groupId, startDate, dueDate);
            peerEvaluationRepository.save(evaluation);
        }

        return "redirect:/success";
    }


    // open the success page
    @GetMapping("/success")
    public String success(Model model) {
        return "success";
    }

    @GetMapping("/professorDashboard")
    public String professorDashboard(Model model, HttpSession session) {
        // Assume the professor ID is stored in the session
        Integer professorId = (Integer) session.getAttribute("professorId");

        if (professorId == null) {
            // Redirect to login or error page if the ID isn't in the session
            return "redirect:/login";
        }

        // Fetch professor details, assume a method to fetch professor by ID
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("No professor found"));

        model.addAttribute("professor", professor);
        return "professorDashboard";
    }
}
