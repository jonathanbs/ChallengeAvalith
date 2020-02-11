package com.TercerProject.TercerProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
//hola
import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name= "email")
    private String email;

    @ManyToOne
    @JoinColumn(name="department_id")
    @JsonIgnore
    private Department department;
}

