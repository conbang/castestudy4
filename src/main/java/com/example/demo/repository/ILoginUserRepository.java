package com.example.demo.repository;



import com.example.demo.model.LoginUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ILoginUserRepository extends PagingAndSortingRepository<LoginUser, Long> {
}