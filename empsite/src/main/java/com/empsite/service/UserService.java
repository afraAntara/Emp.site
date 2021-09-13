package com.empsite.service;
import com.empsite.entities.Role;
import com.empsite.entities.User;
import com.empsite.exceptions.UserNotFoundException;
import com.empsite.repositories.RoleRepository;
import com.empsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepo;

        @Autowired
        private RoleRepository roleRepo;

        public void saveUserWithCompanyRole(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser = roleRepo.findByName("Company");
        user.addRole(roleUser);
        userRepo.save(user);
        }


        /*public void createUser(User user) {
            BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            Role userRole = new Role("USER");
            List<Role> roles = new ArrayList<>();
            roles.add(userRole);
            user.setRoles(roles);
            userRepository.save(user);
        }

        public void createCompanyAdmin(User user) {
            BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            Role userRole = new Role("COMPANY ADMIN");
            List<Role> roles = new ArrayList<>();
            roles.add(userRole);
            user.setRoles(roles);
            userRepository.save(user);
        }

        public User findOne(String email) {
            return userRepository.getOne(email);*/
            /*Optional<User> user = this.UserRepository.findById(email);
            if (user.isPresent()) {
                return user.get();
            } else {
                return null;
            }*/
      /*  }

  //return this.bookmarkRepository.findOne(bookmarkId);
  //      to:
*/

}
