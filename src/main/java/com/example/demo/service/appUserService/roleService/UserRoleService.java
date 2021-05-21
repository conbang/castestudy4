package com.example.demo.service.appUserService.roleService;

import com.example.demo.model.Role;
import com.example.demo.repository.IUserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleService implements IUserRoleService{
    @Autowired
    private IUserRoleRepo userRoleRepo;
    @Override
    public List<Role> findALl() {
        return (List<Role>) userRoleRepo.findAll();
    }

    @Override
    public Page<Role> findALl(Pageable pageable) {
        return null;
    }

    @Override
    public Role findById(Long id){
        return userRoleRepo.findById(id).get();
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}