package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRoleRepo extends CrudRepository<Role, Long> {
    Role findByName(String name);
}