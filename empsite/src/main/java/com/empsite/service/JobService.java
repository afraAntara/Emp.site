package com.empsite.service;

import com.empsite.entities.Job;
import com.empsite.entities.Role;
import com.empsite.entities.User;
import com.empsite.repositories.JobRepository;
import com.empsite.repositories.RoleRepository;
import com.empsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private JobRepository jobRepo;

    /*public void addJob( Job job,User user){
        //job.setUser(user);
        jobRepo.save(job);

        //Long id = userRepo.findById(user.getUser_id());
        //user.addRole(roleUser);
        userRepo.save(user);
    }*/
    public List<Job> listAll(String keyword){
        if(keyword!=null) {
            return jobRepo.findAll(keyword);
        }
        return jobRepo.findAll();
    }
}
