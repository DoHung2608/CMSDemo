package com.example.miniproject.repository.database;

import com.example.miniproject.model.database.Employee;
import com.example.miniproject.model.session.EmployeeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDatabase extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee", nativeQuery = true)
    public List<Employee> getInfoEmp();

    public Long countEmployeeByIdEmployee(Integer id);

    public Employee getEmployeeByIdEmployee(Integer id);

    @Query(value = "select * from employee", nativeQuery = true)
    public Page<Employee> findWithPage(Pageable pageable);

    @Query(value = "" +
            "select account.email as email, " +
            "employee.img as img, " +
            "employee.username as userName," +
            "employee.firstname as firstName," +
            "employee.lastname as lastName," +
            "employee.address as address," +
            "employee.city as city," +
            "employee.country as country from account, employee where account.id_account=?1 and account.id_account = employee.accountEMP", nativeQuery = true)
    public EmployeeInfo findEmployInfo(Integer idAccount);
}
