package smu.group3.peerevaluationscheduler.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import smu.group3.peerevaluationscheduler.entity.Professor;
import smu.group3.peerevaluationscheduler.repository.ProfessorRepository;

@Controller
public class LoginController {

    //~ fields --------------------------------------------------------------------------

    @Autowired
    private ProfessorRepository professorRepository;

    //~ Methods ---------------------------------------------------------------------------

    // open the login page
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    // handle user logging in
    @PostMapping("/userLogin")
    public String userLogin(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {
        if (professorRepository.findByEmailAndPassword(email, password) != null) {
            int id = professorRepository.findByEmailAndPassword(email, password).getProfessorId();
            session.setAttribute("professorId", id);
            return "redirect:/" + id + "/professorDashboard";
        }
        else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }


    // handle user logging out
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }


    // send user to create a new account page
    @GetMapping("/createAccount")
    public String getRegisterForm() {
        return "createAccount";
    }


    // handle create new account event
    @PostMapping("/createNewAccount")
    public String createAccount(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String userEmail,
                                @RequestParam String confirmEmail,
                                @RequestParam String userPassword,
                                @RequestParam String confirmPassword,
                                Model model) {
        if (userEmail.equals(confirmEmail) && userPassword.equals(confirmPassword)) {
            Professor professor = new Professor(firstName, lastName, userEmail, userPassword, null);
            professorRepository.save(professor);
            return "/login";
        }
        else {
            model.addAttribute("error", "Email or password do not match.");
            return "createAccount";
        }
    }
}
