package com.example.demospringboot.service;

import com.example.demospringboot.domain.Employee;
import com.example.demospringboot.domain.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee saveEmployee(@RequestBody Employee requestForSave) {
        Employee employee = repository.save(requestForSave);
        return employee;
    }

    @Override
    public List<Employee> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));

        if (employee.getIsDeleted()) {
            throw new EntityNotFoundException("Employee was deleted with id = " + id);
        }

        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repository.findById(employee.getId())
                .map(entity -> {
                    entity.setName(employee.getName());
                    entity.setEmail(employee.getEmail());
                    entity.setCountry(employee.getCountry());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + employee.getId()));
    }

    @Override
    public void removeEmployeeById(Long id) {
        repository.findById(id)
                .map(employee -> {
                    employee.setIsDeleted(Boolean.TRUE);
                    return repository.save(employee);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
    }

    @Override
    public void removeAllUsers() {
        repository.deleteAll();
    }
}
