package com.example.orm.manyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orm.manyToMany.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer > {
	Employee findById(int id);
}
