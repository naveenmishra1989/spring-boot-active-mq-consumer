package com.bridgingcode.springbootactivemqdemo.model;

import com.bridgingcode.springbootactivemqdemo.repo.entity.Employee;

import java.util.List;

public class Data {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
