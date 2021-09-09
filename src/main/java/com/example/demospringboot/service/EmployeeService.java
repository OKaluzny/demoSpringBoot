package com.example.demospringboot.service;

import com.example.demospringboot.domain.Employee;

import java.util.List;


public interface EmployeeService {

    /**
     * Save new employee.
     *
     * @param requestForSave {@link Employee}.
     * @return DTO representation for saved employee.
     */
    Employee saveEmployee(Employee requestForSave);

    List<Employee> getAllUsers();

    Employee getEmployeeById(final Long id);

    Employee updateEmployee(final Employee employee);

    void removeEmployeeById(final Long id);

    void removeAllUsers();

}
