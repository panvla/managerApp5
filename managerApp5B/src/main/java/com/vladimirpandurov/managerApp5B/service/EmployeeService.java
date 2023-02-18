package com.vladimirpandurov.managerApp5B.service;

import com.vladimirpandurov.managerApp5B.exception.EmployeeNotFoundException;
import com.vladimirpandurov.managerApp5B.model.Employee;
import com.vladimirpandurov.managerApp5B.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return this.employeeRepository.findAll();
    }

    public Employee getEmployee(Long employeeId){
        return this.employeeRepository.findEmployeeById(employeeId).orElseThrow(()-> new EmployeeNotFoundException("Employee with id " + employeeId + " not found!"));
    }

    public Employee updateEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public Employee saveEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId){
        this.employeeRepository.deleteEmployeesById(employeeId);
    }

}
