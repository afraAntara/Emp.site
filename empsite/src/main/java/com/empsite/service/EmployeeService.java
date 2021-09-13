package com.empsite.service;

//import com.empsite.entities.Employee;
import com.empsite.entities.Job;
import com.empsite.entities.Role;
import com.empsite.entities.User;
//import com.empsite.repositories.EmployeeRepository;
import com.empsite.repositories.JobRepository;
import com.empsite.repositories.RoleRepository;
import com.empsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    //@Autowired
   // private EmployeeRepository empRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private JobRepository jobRepo;

    public void saveUserWithDefaultRole(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);
        userRepo.save(user);

    }

    public void saveJob(Job job){
        jobRepo.save(job);
    }



    //public List<Employee> listAll() {
    //    return empRepo.findAll();
    //}

  //  public void save(Employee employee) {
   //     empRepo.save(employee);
   // }

    /*public Employee get(long id) {
        return empRepo.findById(id).get();
    }

    public void delete(long id) {
        empRepo.deleteById(id);
    }*/
}