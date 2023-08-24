package com.bridgingcode.springbootactivemqdemo.repo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Integer empId;
    private String name;
    private String dept;
}
