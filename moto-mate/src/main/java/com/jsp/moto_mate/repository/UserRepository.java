package com.jsp.moto_mate.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.moto_mate.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByMobile(Long mobile);

    User findByEmail(String email);

}
