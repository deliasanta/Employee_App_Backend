package com.utcn.employeeApplication.employee;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + employeeId));
    }
    @Transactional
    public Employee updateEmployee(Integer id, Map<String, Object> updates) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + id));
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();
            switch (field) {
                case "name":
                    existingEmployee.setName(value.toString());
                    break;
                case "departmentID":
                    existingEmployee.setDepartmentID((Integer) value);
                    break;
                case "managerID":
                    existingEmployee.setManagerID((Integer) value);
                    break;
                case "email":
                    existingEmployee.setEmail(value.toString());
                    break;
                default:

            }
        }
        return employeeRepository.save(existingEmployee);
    }
    public void deleteEmployeeById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
    public List<Employee> findEmployeesByEmail(String email) {
        return employeeRepository.findEmployeesByEmail(email);
    }
    public List<Employee> getEmployeesByDepartment(Integer departmentID) {
        return employeeRepository.findEmployeesByDepartmentID(departmentID);
    }
    public List<Employee> getManagersByDepartment(Integer departmentID) {
        return employeeRepository.findEmployeesByDepartmentIDAndManagerIDNot(departmentID,0);
    }
}
