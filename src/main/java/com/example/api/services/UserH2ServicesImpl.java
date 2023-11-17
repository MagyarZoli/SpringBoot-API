package com.example.api.services;

import com.example.api.dto.UserH2Dto;
import com.example.api.model.UserH2;
import com.example.api.repository.UserH2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserH2ServicesImpl
        extends ServicesImpl<UserH2, UserH2Dto, Long, UserH2Repository> {

    private UserH2Repository repository;

    @Autowired
    public UserH2ServicesImpl(UserH2Repository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    protected UserH2Dto mapToDto(UserH2 entity) {
        return UserH2Dto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .age(entity.getAge())
                .study(entity.getStudy())
                .build();
    }

    @Override
    protected UserH2 mapToEntity(UserH2Dto dto) {
        return UserH2.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .study(dto.getStudy())
                .build();
    }

    @Override
    protected UserH2 mapToEntity(UserH2Dto dto, Long aLong) {
        UserH2 user = mapToEntity(dto);
        user.setId(aLong);
        return user;
    }
}