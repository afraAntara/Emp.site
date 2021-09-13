/*package com.empsite.entities;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_id;
    @Column(length = 50)
    private String School;
    //@Column(length = 50)
    //private String School_Subject;
    @Column(length = 50)
    private String College;
    //@Column(length = 50)
    //private String College_Subject;
    @Column(length = 50)
    private String Bachelors_University;
    //@Column(length = 50)
    //private String Bachelors_Subject;
    @Column(length = 50)
    private String Masters_University;
    //@Column(length = 50)
    //private String Masters_Subject;
    @Column(length = 100)
    private String contactDetails;

    @OneToOne( fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "emp")
    private User user;

    public Employee() {
    }

    /*public Employee(String school,String college,String bachelors_University,String masters_University, String contactDetails) {
        this.School = school;
        this.College = college;
        this.Bachelors_University = bachelors_University;
        this.Masters_University = masters_University;
        this.contactDetails = contactDetails;
    }*/
/*

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
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

    public String getBachelors_University() {
        return Bachelors_University;
    }

    public void setBachelors_University(String bachelors_University) {
        Bachelors_University = bachelors_University;
    }

    public String getMasters_University() {
        return Masters_University;
    }

    public void setMasters_University(String masters_University) {
        Masters_University = masters_University;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }


}*/
