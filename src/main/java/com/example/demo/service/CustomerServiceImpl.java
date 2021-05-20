package com.example.demo.service;

import com.example.demo.model.LoginUser;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerServiceImpl(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<LoginUser> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<LoginUser> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public LoginUser save(LoginUser loginUser) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
