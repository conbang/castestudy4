package com.example.demo.service.appUserService.adminService;

import com.example.demo.model.LoginUser;
import com.example.demo.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAdminService {
    Page<LoginUser> findAll(Pageable pageable);
    Page<LoginUser> findUserRoleName(Role role, Pageable pageable);
}
