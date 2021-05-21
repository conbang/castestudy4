package com.example.demo.repository;

import com.example.demo.model.LoginUser;
import com.example.demo.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface IAdminRepo extends PagingAndSortingRepository<LoginUser, Long> {
//// loi
//    Page<LoginUser> findAllByRole(Role role, Pageable pageable);
    Page<LoginUser> findAllByOrderByIdAsc(Pageable pageable);
}
