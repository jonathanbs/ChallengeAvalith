package com.TercerProject.TercerProject.controller;

import com.TercerProject.TercerProject.exception.ResourceNotFoundException;
import com.TercerProject.TercerProject.model.Department;
import com.TercerProject.TercerProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Get All Request
    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    // Post Request
    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @DeleteMapping("/departments/{id}")
    public HttpStatus deleteDepartment(@PathVariable(value = "id") Long departmentId) throws ResourceNotFoundException {
        this.departmentService.deleteDepartmentById(departmentId);
        return HttpStatus.OK;
    }
}

