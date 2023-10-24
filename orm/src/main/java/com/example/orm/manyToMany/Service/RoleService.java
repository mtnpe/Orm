package com.example.orm.manyToMany.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.manyToMany.entities.Employee;
import com.example.orm.manyToMany.entities.Role;
import com.example.orm.manyToMany.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
    
    public void addRole(Role role) {
    	roleRepository.save(role);
    }

	public void deleteRole(int id) {
		Role role = roleRepository.findById(id);
		List<Employee> listEmployee = new ArrayList<>(role.getEmployees());
		for (Employee employee : listEmployee) {
			role.removeEmployee(employee);
		}
		roleRepository.delete(role);
	}
}
