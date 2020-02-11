package com.TercerProject.TercerProject.service;

import com.TercerProject.TercerProject.exception.ResourceNotFoundException;
import com.TercerProject.TercerProject.model.Department;
import com.TercerProject.TercerProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    // Create Department
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    // List All Departments
    public List<Department> getAllDepartments(){
        return this.departmentRepository.findAll();
    }

    // Get Department by ID
    public Department getDepartmentById(Long departmentId)  {
        return departmentRepository.findById(departmentId).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"No hay departamento"));
    }
    // Delete Department by ID
    public void deleteDepartmentById(Long departmentId) throws ResourceNotFoundException{
        Optional<Department> departmentDb = this.departmentRepository.findById(departmentId);

        if (departmentDb.isPresent()){
            this.departmentRepository.deleteById(departmentId);
        }else{
            throw  new ResourceNotFoundException("Departamento con id: "+ departmentId+" no encontrado!");
        }
    }
}
