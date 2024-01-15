package com.utcn.employeeApplication.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findEmployeesByEmail(String email);

    List<Employee> findEmployeesByDepartmentID(Integer departmentID);

    List<Employee> findEmployeesByDepartmentIDAndManagerIDNot(Integer departmentID, Integer managerID);
}
