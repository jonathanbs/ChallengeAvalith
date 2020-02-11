package com.TercerProject.TercerProject.service;

import com.TercerProject.TercerProject.exception.ResourceNotFoundException;
import com.TercerProject.TercerProject.model.Employee;
import com.TercerProject.TercerProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentService departmentService;

    // Create Empleado
    public Employee createEmployee(Employee employee, Long depId){
        employee.setDepartment(departmentService.getDepartmentById(depId));
        return employeeRepository.save(employee);
    }

    // Listar todos los Empleados
    public List<Employee> getAllEmployees(){
        return  employeeRepository.findAll();
    }

    //  GET Empleado por ID
    public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Optional<Employee> employeeDb = employeeRepository.findById(employeeId);

        if (employeeDb.isPresent()) {
            return employeeDb.get();
        }else{
            throw new ResourceNotFoundException("Empleado con ID: "+ employeeId + " no encontrado!");
        }
    }
    // DELETE empleado por ID
    public void deleteEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Optional <Employee> employeeDb =this.employeeRepository.findById(employeeId);

        if (employeeDb.isPresent()){
            this.employeeRepository.deleteById(employeeId);
        }else{
            throw new ResourceNotFoundException("Empleado con ID:"+ employeeId +"no encontrado!");
        }
    }
}
