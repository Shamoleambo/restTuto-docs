package com.tidz.restTuto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidz.restTuto.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
