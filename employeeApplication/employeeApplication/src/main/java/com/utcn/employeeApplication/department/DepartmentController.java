package com.utcn.employeeApplication.department;

import com.utcn.employeeApplication.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.create(department);
    }
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        return departmentService.updateDepartment(id, updates);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartmentById(id);
    }
    @GetMapping("/departmentsByManager")
    public List<Department> findDepartmentsByManager(@RequestParam Integer managerID) {
        return departmentService.findDepartmentsByManager(managerID);
    }
}
