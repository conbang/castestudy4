package com.example.demo.service.appUserService.adminService;

import com.example.demo.model.LoginUser;
import com.example.demo.model.Role;
import com.example.demo.repository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private IAdminRepo adminRepo;

    @Override
    public Page<LoginUser> findAll(Pageable pageable) {
        return adminRepo.findAllByOrderByIdAsc(pageable);
    }

    @Override
    public Page<LoginUser> findUserRoleName(Role role, Pageable pageable) {
        return adminRepo.findAllByOrderByIdAsc(pageable);
    }

}