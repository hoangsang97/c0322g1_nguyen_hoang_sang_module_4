package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Employee;
import vn.codegym.repository.IEmployeeRepository;
import vn.codegym.service.IEmployeeService;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAllEmployee(pageable);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee.getName(), employee.getDateOfBirth(), employee.getIdCard(), employee.getSalary(),
                employee.getPhoneNumber(), employee.getEmail(), employee.getAddress(),
                employee.getPosition().getId(), employee.getEducationDegree().getId(),
                employee.getDivision().getId(), employee.getId());
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }
}
