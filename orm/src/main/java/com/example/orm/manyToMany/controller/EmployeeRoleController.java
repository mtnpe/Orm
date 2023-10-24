package com.example.orm.manyToMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.orm.manyToMany.Service.EmployeeService;
import com.example.orm.manyToMany.Service.RoleService;
import com.example.orm.manyToMany.entities.Employee;
import com.example.orm.manyToMany.entities.Role;

@RestController
public class EmployeeRoleController {
	@Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;
    
    @GetMapping(path = "/employees")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Employee> getEmployees() {
        return employeeService.getEmployee();
    }
    
    @GetMapping(path = "/roles")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
        
    @PostMapping(path = "/add-employee")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createEmployee(@RequestBody Employee employee) {
    	employeeService.addEmployee(employee);
    }
    
    @PostMapping(path = "/add-role")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createRole(@RequestBody Role role) {
    	roleService.addRole(role);
    }
    
    @PutMapping(path = "update-employee/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
    	employeeService.updateEmployee(id, employee);
    }
    
    @DeleteMapping(path = "/delete-employee/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable int id) {
    	employeeService.deleteEmployee(id);
    }
    
    @DeleteMapping(path = "/delete-role/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable int id) {
    	roleService.deleteRole(id);
    }
    
}
