package com.example.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserH2Dto {

    private Long id;
    private String firstName;
    private String lastName;
    private Byte age;
    private Boolean study;
}