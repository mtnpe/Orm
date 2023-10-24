package com.example.orm.manyToMany.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.manyToMany.entities.Employee;
import com.example.orm.manyToMany.entities.Role;
import com.example.orm.manyToMany.repository.EmployeeRepository;
import com.example.orm.manyToMany.repository.RoleRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	public void addEmployee(Employee employee) {
		List<Role> roles = new ArrayList<>(employee.getRoles());
		List<Role> newRoles = new ArrayList<Role>();
		for (Role role: roles) {
			Role newRole = roleRepository.findById(role.getId()); 
			newRoles.add(newRole);
		}
		employee.setRoles(newRoles);
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(int id, Employee employee) {
		Employee newEmployee = employeeRepository.findById(id);
		List<Role> roles = new ArrayList<>(employee.getRoles());
		List<Role> newRoles = new ArrayList<Role>();
		for (Role role: roles) {
			Role newRole = roleRepository.findById(role.getId()); 
			newRoles.add(newRole);
		}
		newEmployee.setName(employee.getName());
		newEmployee.setRoles(newRoles);
		employeeRepository.save(newEmployee);
	}

	@Transactional
	public void deleteEmployee(int id) {
		Employee employee = employeeRepository.findById(id);
		List<Role> existingRoles = new ArrayList<>(employee.getRoles());
		for (Role role : existingRoles) {
			employee.removeRole(role);
		}
		employeeRepository.delete(employee);
	}
	
}
