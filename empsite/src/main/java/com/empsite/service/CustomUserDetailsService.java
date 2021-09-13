package com.empsite.service;

import com.empsite.details.CustomUserDetails;
//import com.empsite.entities.Role;
import com.empsite.entities.Job;
import com.empsite.entities.Role;
import com.empsite.entities.User;
import com.empsite.exceptions.UserNotFoundException;
import com.empsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    /*public void createUser(User user){
        BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepo.save(user);

    }
    public void createCompanyAdmin(User user){
        BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("CompanyAdmin");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepo.save(user);

    }*/
    //public User findOne(String email) {
    //    return userRepo.findOne(email);
    //}


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public List<User> listAll(){
        return (List<User>) userRepo.findAll();
    }

    public User get(Long id) throws UserNotFoundException{
        Optional<User> result = userRepo.findById(id);
        if(result.isPresent()) {
        return result.get();
        }
        throw new UserNotFoundException("Could not find any users with"+id);
    }

    public void saveUser(User user){
        userRepo.save(user);
    }

}