package com.empsite.repositories;

import com.empsite.entities.Job;
import com.empsite.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    //User getUserByEmail(String email);
    //User findOne(String email);
    @Query("SELECT u FROM User u WHERE u.email=?1")
    public User getUserByEmail(String email);



   // User findOne(User user);
    //List<User> findByNameLike(String name);
   //Query("SELECT u FROM User u WHERE u.user_id=?1")
   // public User findById(Long id);

    //public List<User> findByNameContaing(String name);
   // @Query("from User as u where u.jobs.company_name.equalsTo(name)")


}
