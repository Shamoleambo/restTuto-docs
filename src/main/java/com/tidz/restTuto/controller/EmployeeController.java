package com.tidz.restTuto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tidz.restTuto.errors.EmployeeNotFoundException;
import com.tidz.restTuto.model.Employee;
import com.tidz.restTuto.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	private final EmployeeRepository repository;

	public EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/employees")
	public List<Employee> all() {
		return this.repository.findAll();
	}

	@PostMapping("/employees")
	public Employee newEmployee(@RequestBody Employee employee) {
		return this.repository.save(employee);
	}

	@GetMapping("/employees/{id}")
	public Employee one(@PathVariable Long id) {
		return this.repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	@PutMapping("/employees/{id}")
	public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return this.repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			return repository.save(newEmployee);
		});
	}

	@DeleteMapping("/employee")
	public void deleteEmployee(@PathVariable Long id) {
		this.repository.deleteById(id);
	}

}
