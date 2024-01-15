package com.utcn.employeeApplication.department;

import com.utcn.employeeApplication.employee.Employee;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    public List<Department> findDepartmentsByManager(Integer managerID) {
        return departmentRepository.findDepartmentsByManagerID(managerID);
    }
    @Transactional
    public Department create(Department department) {
        return departmentRepository.save(department);
    }
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(Integer departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with ID: " + departmentId));
    }
    @Transactional
    public Department updateDepartment(Integer departmentId, Map<String, Object> updates) {
        Department existingDepartment = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with ID: " + departmentId));
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();
            switch (field) {
                case "description":
                    existingDepartment.setDescription(value.toString());
                    break;
                case "parentID":
                    existingDepartment.setParentID((Integer) value);
                    break;
                case "managerID":
                    existingDepartment.setManagerID((Integer) value);
                    break;
                default:

            }
        }
        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartmentById(Integer departmentId) {
        departmentRepository.deleteById(departmentId);
    }

}
