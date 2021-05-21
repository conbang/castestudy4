package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.appUserService.adminService.AdminService;
import com.example.demo.service.appUserService.loginuser.ILoginUserService;
import com.example.demo.service.appUserService.roleService.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private ILoginUserService loginUserService;

    @ModelAttribute("roles")
    public Iterable<Role> userRoles() {
        return userRoleService.findALl();
    }

    @ModelAttribute("role")
    public Role sendUserRole() {
        return new Role();
    }

    @Autowired
    private AdminService adminService;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("admin/home");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView showALl(@PageableDefault(size = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("admin/adminList");
        modelAndView.addObject("admin", adminService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView searchByName(@ModelAttribute Role role, @PageableDefault(size = 7) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("admin/adminList");
        modelAndView.addObject("admin", adminService.findUserRoleName(role, pageable));
        return modelAndView;
    }

//    @PutMapping("/list/{id}")
//    private ResponseEntity<LoginUser> disableUser(@PathVariable Long id){
//        LoginUser loginUser = this.loginUserService.findById(id);
//        if (loginUser.isDisable()==true){
//            loginUser.setDisable(false);
//        } else {
//            loginUser.setDisable(true);
//        }
//        loginUserService.save(loginUser);
//        return new ResponseEntity<>(loginUser, HttpStatus.OK);
//    }
//
    @GetMapping("/show")
    public ModelAndView showIndex(){
        ModelAndView modelAndView = new ModelAndView("adminList");
        return modelAndView;
    }
}
