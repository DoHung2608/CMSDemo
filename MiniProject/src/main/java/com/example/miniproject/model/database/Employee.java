package com.example.miniproject.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_employee")
    private Integer idEmployee;

    @Column(name = "img")
    private String img;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "age")
    private BigDecimal age;

    @Basic(optional = false)
    @Column(name = "createtime", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "accountEMP")
    private Integer accountEmp;


    public Employee(String img, String username, String firstname, String lastname, String address, BigDecimal age, String city, String salary) {
    }
}
