package com.example.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
//@Setter
//@Getter
@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private String number;
    private double balance;

}
