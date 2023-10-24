package com.example.orm.manyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orm.manyToMany.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findById(int id);
}
