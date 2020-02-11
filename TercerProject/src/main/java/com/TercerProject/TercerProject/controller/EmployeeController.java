package com.TercerProject.TercerProject.controller;

import com.TercerProject.TercerProject.exception.ResourceNotFoundException;
import com.TercerProject.TercerProject.model.Employee;
import com.TercerProject.TercerProject.service.DepartmentService;
import com.TercerProject.TercerProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    // Listar todos los empleados
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // Get empleado por ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
    }

    // Create empleado
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee, @RequestParam("depId") Long depId){

        return employeeService.createEmployee(employee, depId);
    }

    //@PutMapping Actualizar Empleado

    @DeleteMapping("/employess/{id}")
    public HttpStatus deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        this.employeeService.deleteEmployeeById(employeeId);
        return HttpStatus.OK;
    }

}

