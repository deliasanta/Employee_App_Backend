package com.utcn.employeeApplication.department;

import com.utcn.employeeApplication.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findDepartmentsByManagerID(Integer managerID);

}
