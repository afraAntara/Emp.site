package com.empsite.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;


@Entity
public class Job {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String job_role;
    @NotNull
    private String company_name;
    private String start_date;
    private String end_date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public Job() {

    }
    //@ManyToOne
    //@JoinColumn(name="company_email")
    //private Company comp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob_role() {
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }


   /* public Company getComp() {
        return comp;
    }

    public void setComp(Company comp) {
        this.comp = comp;
    }*/

    public Job(String job_role, String company_name, String start_date, String end_date, User user) {
        this.job_role=job_role;
        this.company_name=company_name;
        this.start_date=start_date;
        this.end_date=end_date;
        this.user=user;
    }

    public Job(String job_role, String start_date, String end_date) {
        this.job_role=job_role;
        this.start_date=start_date;
        this.end_date=end_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    /*@Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", job_role='" + job_role + '\'' +
                ", company_name='" + company_name + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", user=" + user +
                '}';
    }*/
}