package com.example.miniproject.repository;

import com.example.miniproject.model.database.Employee;
import com.example.miniproject.model.session.EmployeeInfo;
import com.example.miniproject.repository.database.EmployeeDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {
    @Autowired
    EmployeeDatabase employeeDatabase;
    public List<Employee> getInfoEmp() { return employeeDatabase.getInfoEmp(); }

    public boolean saveEmployee(Employee employee) {
        Employee saveEmp = employeeDatabase.save(employee);
        if (saveEmp != null) {
            return true;
        }
        return false;
    }

    public void deleteEmp(Integer id){
        Long count = employeeDatabase.countEmployeeByIdEmployee(id);
        if(count == null || count ==0){

        }
        employeeDatabase.deleteById(id);
    }

    public Employee getEmployeeById(Integer id) {
        Optional<Employee> optional = Optional.ofNullable(employeeDatabase.getEmployeeByIdEmployee(id));
        Employee employee = null;
        if ( optional.isPresent()) {
            employee = optional.get();
        }
        else {
            throw new RuntimeException("Employee not found for id::"+id);
        }
        return employee;
    }
    public Page<Employee> findPaginated(int pageNo,int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.employeeDatabase.findWithPage(pageable);
    }

    public EmployeeInfo findEmployInfo(Integer idAccount) {
        return employeeDatabase.findEmployInfo(idAccount);
    }

}
