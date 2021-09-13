package com.empsite.controllers;

import com.empsite.details.CustomUserDetails;
//import com.empsite.entities.Employee;
import com.empsite.entities.Job;
import com.empsite.entities.Role;
import com.empsite.entities.User;
//import com.empsite.repositories.EmployeeRepository;
import com.empsite.exceptions.ResourceNotFoundException;
import com.empsite.exceptions.UserNotFoundException;
import com.empsite.repositories.JobRepository;
import com.empsite.repositories.RoleRepository;
import com.empsite.repositories.UserRepository;
import com.empsite.service.CustomUserDetailsService;
import com.empsite.service.EmployeeService;
import com.empsite.service.JobService;
import com.empsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserRepository repo;
   // @Autowired
    //private EmployeeRepository empRepo;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private JobRepository jobRepo;
    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpFrom(Model model){
        model.addAttribute("user", new User());
        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        employeeService.saveUserWithDefaultRole(user);
        return "register_success";
    }
    @GetMapping("/registercompany")
    public String showSignUpCompany(Model model){
        model.addAttribute("user", new User());
        return "signup_form_company";
    }
    @PostMapping("/process_register_company")
    public String processRegisterCompany(User user) {
        userService.saveUserWithCompanyRole(user);
        return "empHome";
    }

    @GetMapping("/homepage")
    public String viewUserAccountForm(
            @AuthenticationPrincipal CustomUserDetails userDetails, Model model) {

        String userEmail = userDetails.getUsername();
        User user = repo.getUserByEmail(userEmail);

        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Account Details");

        List<User> listUsers = customUserDetailsService.listAll();
        model.addAttribute("listUsers", listUsers);

        List<Job> jobs=this.jobRepo.findJobByUser(user.getUser_id());
        model.addAttribute("jobs", jobs);

        return "empHome";

    }
    @RequestMapping("/delete/{user_id}")
    public String deleteUser(@PathVariable(name = "user_id") User user) {
        repo.delete(user);
        return "redirect:/homepage";
    }
    @RequestMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable(name = "id") Job job) {
        //jobRepo.deleteByIdWithJPQL(job.user_id);
        jobRepo.delete(job);
        return "redirect:/homepage";
    }
    @PostMapping("homepage/editempinfo/save")
    public String saveUser(User user) {
        /*String school = request.getParameter("school");
        String college = request.getParameter("college");
        String university = request.getParameter("university");
        user.setEmpDetails(school, college, university);*/
        employeeService.saveUserWithDefaultRole(user);
        //repo.save(user);
        return "redirect:/homepage";
        }
//, RedirectAttributes ra
    @GetMapping("homepage/editempinfo/{user_id}")
    public String showEditEmpForm(@PathVariable("user_id") Long id, Model model) {
       User user = repo.findById(id).get();
       model.addAttribute("user", user);
        return "editempinfo";
    }
    @GetMapping("/edit/{user_id}")
    public String showAdminEditEmpForm(@PathVariable(name = "user_id") Long id, Model model) {
        User user = repo.findById(id).get();
        model.addAttribute("user", user);
        return "editempinfo";
    }



            /*  @RequestMapping("/listallusers")
    public String showUserList(Model model) {
        List<User> listUsers = customUserDetailsService.listAll();
        model.addAttribute("listUsers", listUsers);

        return "alluserslist";
    }*/
    /*@GetMapping("/adminhomepage")
    public String viewUserAccountForm(
            @AuthenticationPrincipal CustomUserDetails userDetails, Model model) {

        String userEmail = userDetails.getUsername();
        User user = repo.getUserByEmail(userEmail);

        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Account Details");

        return "adminhomepage";

    }*/

    @GetMapping("/403")
    public String error403(){
        return "403";
    }

    /*@GetMapping ("/createEmpDetails")
    public String showNewProductPage(Model model) {
        //Employee employee = new Employee();
        model.addAttribute("employee", new Employee());

        return "add_empDetails";
    }
    @PostMapping(value = "/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        empRepo.save(employee);

        return "empHome";
    }*/

    @GetMapping("homepage/addempjobs/")
    public String addEmpJob(Model model, Principal principal) {
        String userName=principal.getName();
        User user = repo.getUserByEmail(userName);
        model.addAttribute("user", user);
        model.addAttribute("title", "Add Job");
        model.addAttribute("job", new Job());
        return "addEmpJob";
    }
    @PostMapping("/homepage/addempjob/save")
    public String saveEmpJob(@ModelAttribute Job job, Principal principal){
        String name=principal.getName();
        User user=this.repo.getUserByEmail(name);
        //Long id= user.getUser_id();
        user.getJobs().add(job);
        job.setUser(user);
        this.repo.save(user);
        return "redirect:/homepage";
    }

    @GetMapping("/showJobList")
    public String showJobList(Model model, Principal principal){
        String name=principal.getName();
        User user=this.repo.getUserByEmail(name);
        List<Job> jobs=this.jobRepo.findJobByUser(user.getUser_id());
        model.addAttribute("jobs", jobs);
        return "showJobs";
    }

    @RequestMapping("/search")
    public String Search(Model model, @Param("keyword") String keyword){
        List<Job> listjobs= jobService.listAll(keyword);
        model.addAttribute("listjobs", listjobs);
        model.addAttribute("keyword", keyword);
        return "empHome";
    }



}