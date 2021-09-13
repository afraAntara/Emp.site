package com.empsite.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;


    @Column(nullable = false, unique = true, length = 45)
    private String email;


    @Column(nullable = false, length = 64)
    private String password;


    @Column(nullable = false, length = 25)
    private String name;

    @Column(length = 50)
    private String School;

    @Column(length = 50)
    private String College;

    @Column(length = 50)
    private String University;

   /* @OneToOne( fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee emp;*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();



    public User(){
    }
    // Employee emp

    public User(String email, String password, String name, String school, String college, String university) {
        this.email = email;
        this.password=password;
        this.name=name;
        this.School=school;
        this.College=college;
        this.University=university;
        //this.emp=emp;
    }

    /*public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }*/


/*

    @ManyToMany(cascade =CascadeType.ALL)
    @JoinTable(
            name="user_roles",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_name",referencedColumnName = "name")  }
    )
    private List<Role> roles;*/

   // @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    //private List<Job> jobs;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Job> jobs=new ArrayList<>();
    //private Set<Role> roles = new HashSet<>();

    /*@Column(nullable =false , length = 200)
    private String university;

    @Column(nullable = false, length = 200)
    private String college;

    @Column(nullable = false, length = 200)
    private String school;*/

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
/* public User() {
    }*/

    /*public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }*/


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /*public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }*/

    /*public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }*/


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public void setEmpDetails(String school, String college, String university){
        this.School=school;
        this.College=college;
        this.University=university;
    }
    public void addJob(Job job){
        this.jobs.add(job);
    }
}
