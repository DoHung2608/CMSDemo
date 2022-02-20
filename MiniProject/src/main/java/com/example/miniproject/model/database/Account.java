package com.example.miniproject.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account")
public class Account {
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Basic(optional = false)
    @Column(name = "createdtime", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdtime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_account")
    private Integer idAccount;

    public Account(String email, String password) {
    }
}
