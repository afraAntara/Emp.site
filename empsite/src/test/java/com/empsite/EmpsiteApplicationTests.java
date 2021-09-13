package com.empsite;

//import com.empsite.entities.Job;
import com.empsite.entities.User;
//import com.empsite.service.JobService;
import com.empsite.service.CustomUserDetailsService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
class EmpsiteApplicationTests {

   /* @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;
    @Autowired
    private JobService jobService;

    @Before
    public void initDb() {
        {
            User newUser = new User("testUser@mail.com", "testUser", "123456");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("testAdmin@mail.com", "testAdmin", "123456");
            userService.createUser(newUser);
        }

        Job userJob = new Job("accountant", "12th Jan 2021", "", "testUser@mail.com");
        User user = userService.findOne("testUser@mail.com");
        jobService.addJob(userJob, user);
    }

    @org.junit.Test
    public void testUser() {
        User user = userService.findOne("testUser@mail.com");
        assertNotNull(user);
        User companyadmin = userService.findOne("testAdmin@mail.com");
        assertEquals(companyadmin.getEmail(), "testAdmin@mail.com");
    }

    @org.junit.Test
    public void testTask() {
        User user = userService.findOne("testUser@mail.com");
        List<Job> task = jobService.findUserJob(user);
        assertNotNull(task);


    }*/

}
