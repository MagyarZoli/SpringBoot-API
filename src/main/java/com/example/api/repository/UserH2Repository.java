package com.example.api.repository;

import com.example.api.model.UserH2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserH2Repository
        extends JpaRepository<UserH2, Long> {

    List<UserH2> findAllById(Long id);
}