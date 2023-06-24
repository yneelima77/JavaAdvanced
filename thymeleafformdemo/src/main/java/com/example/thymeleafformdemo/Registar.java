package com.example.thymeleafformdemo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Register")
public class Registar implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstname;
    private String lastName;
    private String email;
    private String username;
    private String password;

    @OneToMany
    private List<Project> projects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Registar(List<Project> projects) {
        this.projects = projects;
    }

    public Registar(String firstname, String lastName, String email, String username, String password) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Registar() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
