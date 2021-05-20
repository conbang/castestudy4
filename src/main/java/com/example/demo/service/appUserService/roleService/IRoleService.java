package com.example.demo.service.appUserService.roleService;


import com.example.demo.model.Role;
import com.example.demo.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
