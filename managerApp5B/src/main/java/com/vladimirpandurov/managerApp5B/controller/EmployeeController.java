package com.vladimirpandurov.managerApp5B.controller;

import com.vladimirpandurov.managerApp5B.model.Employee;
import com.vladimirpandurov.managerApp5B.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = this.employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee newEmployee = this.employeeService.saveEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = this.employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long employeeId){
        this.employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
