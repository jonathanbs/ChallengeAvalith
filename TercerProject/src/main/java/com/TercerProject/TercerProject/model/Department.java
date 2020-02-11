package com.TercerProject.TercerProject.model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name= "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long idDepart;

    @Column(name = "department_name")
    private String departmentName;

    //@OneToMany (targetEntity = Employee.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Employee> employeeList;
}
