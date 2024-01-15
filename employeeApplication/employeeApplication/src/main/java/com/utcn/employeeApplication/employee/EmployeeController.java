package com.utcn.employeeApplication.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        return employeeService.updateEmployee(id, updates);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }
    @GetMapping("/employeesByEmail")
    public List<Employee> findEmployeesByEmail(@RequestParam String email) {
        return employeeService.findEmployeesByEmail(email);
    }
    @GetMapping("/employeesByDepartment")
    public List<Employee> getEmployeesByDepartment(@RequestParam Integer departmentID) {
        return employeeService.getEmployeesByDepartment(departmentID);
    }
    @GetMapping("/managersByDepartment")
    public List<Employee> getManagersByDepartment(@RequestParam Integer departmentID) {
        return employeeService.getManagersByDepartment(departmentID);
    }
}
