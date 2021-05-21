package com.example.demo.service.appUserService.roleService;

import com.example.demo.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface IUserRoleService{

    List<Role> findALl();

    Page<Role> findALl(Pageable pageable);

    Role findById(Long id);

    Role save(Role role);

    void deleteById(Long id);

}
