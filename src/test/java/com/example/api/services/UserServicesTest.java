package com.example.api.services;

import com.example.api.TestStructure;
import com.example.api.dto.UserH2Dto;
import com.example.api.model.UserH2;
import com.example.api.repository.UserH2Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServicesTest
        implements TestStructure {

    @Mock
    private UserH2Repository userRepository;

    @InjectMocks
    private UserH2ServicesImpl userServices;

    private UserH2 user;
    private UserH2Dto userDto;

    @BeforeEach
    public void setUp() {
        user = UserH2.builder()
                .firstName("Test")
                .lastName("Elek")
                .age((byte) 18)
                .study(true)
                .build();
        userDto = UserH2Dto.builder()
                .firstName("Test")
                .lastName("Elek")
                .age((byte) 18)
                .study(true)
                .build();
    }

    @Override
    @Test
    public void create_Test() throws Exception {
        when(userRepository.save(any(UserH2.class))).thenReturn(user);
        UserH2Dto savedUserDto = userServices.postEntity(userDto);
        assertThat(savedUserDto).isNotNull();
        assertEquals(savedUserDto, userDto);
    }

    @Override
    @Test
    public void get_Test() throws Exception {
        when(userRepository.findAll()).thenReturn(List.of(user));
        Iterable<UserH2Dto> userDtoList = userServices.getAllEntity();
        assertThat(userDtoList).isNotNull();
    }

    @Override
    @Test
    public void put_Test() throws Exception {
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
        when(userRepository.save(any(UserH2.class))).thenReturn(user);
        UserH2Dto savedFoodDto = userServices.putEntity(userDto, 1L);
        assertThat(savedFoodDto).isNotNull();
    }

    @Override
    @Test
    public void delete_Test() throws Exception {
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
        assertAll(() -> userServices.deleteEntity(1L));
    }
}