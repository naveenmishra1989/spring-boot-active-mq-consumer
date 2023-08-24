package com.bridgingcode.springbootactivemqdemo.repo;

import com.bridgingcode.springbootactivemqdemo.repo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemMessageRepository extends JpaRepository<Employee,Integer> {
}
