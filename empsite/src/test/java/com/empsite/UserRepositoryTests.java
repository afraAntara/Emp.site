package com.empsite;

import static org.assertj.core.api.Assertions.assertThat;

import com.empsite.entities.Role;
import com.empsite.entities.User;
import com.empsite.repositories.RoleRepository;
import com.empsite.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("afraantara@gmail.com");
        user.setName("Afra Antara Anjum");
        user.setPassword("1234");


        User savedUser = userRepo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getUser_id());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testUserByEmail(){
        String email = "afraantara@gmail.com";
        String password = "1234";
        User user = (User) userRepo.getUserByEmail(email);
        assertThat(user).isNotNull();

    }

    /*@Test
    public void testAddRoleToNewUser() {
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setName("Admin");
        //user.setPassword("admin");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawpassword = "admin";
        String encodedPassword = passwordEncoder.encode(rawpassword);
        user.setPassword(encodedPassword);

        Role roleAdmin = roleRepo.findByName("Admin");
        user.addRole(roleAdmin);

        User savedUser = userRepo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }*/

    /*@Test
    public void testAddRoleToNewUser() {
        User user = new User();
        user.setEmail("robi@gmail.com");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawpassword ="robi";
        String encodedPassword = passwordEncoder.encode(rawpassword);
        user.setPassword(encodedPassword);
        user.setName("Robi");


        Role roleCompany = roleRepo.findByName("Company");
        user.addRole(roleCompany);

        User savedUser = userRepo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }

*/

}
