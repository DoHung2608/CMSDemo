package com.example.miniproject.service;

import com.example.miniproject.model.database.Employee;
import com.example.miniproject.model.session.EmployeeInfo;
import com.example.miniproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getInfoEmp() { return employeeRepository.getInfoEmp(); }

    public boolean saveEmp(Employee employee) { return employeeRepository.saveEmployee(employee);}

    public void deleteEmp(Integer id) {
        employeeRepository.deleteEmp(id);
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.getEmployeeById(id);
    }

    public Page<Employee> findPaginated(int pageNo,int pageSize) {
        return employeeRepository.findPaginated(pageNo,pageSize);
    }
    public EmployeeInfo findEmployInfo(Integer idAccount) {
        return employeeRepository.findEmployInfo(idAccount);
    }
}
