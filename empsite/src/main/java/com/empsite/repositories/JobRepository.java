package com.empsite.repositories;

import com.empsite.entities.Job;
import com.empsite.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
*/
public interface JobRepository extends JpaRepository<Job, Long>{
   // List<Job> findByUser(User user);
  // Page<Job> findByUserId(Long id, Pageable pageable);
    //Optional<Job> findByIdAndPostId(Long id, Long user_id);

    @Query("from Job as c where c.user.user_id =:id")
    public List<Job> findJobByUser(@Param("id") Long id);

    @Query("SELECT j FROM Job j WHERE j.company_name LIKE %?1%")
    public List<Job> findAll(String keyword);

   /* @Modifying
    @Query("DELETE FROM Job j WHERE j.user_id = ?1")
    void deleteByIdWithJPQL(Long user_id);*/
}