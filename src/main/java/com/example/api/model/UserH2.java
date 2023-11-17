package com.example.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER_H2")
public class UserH2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private @NonNull String firstName;

    @Column(name = "LAST_NAME")
    private @NonNull String lastName;

    @Column(name = "AGE")
    private @NonNull Byte age;

    @Column(name = "STUDY")
    private @NonNull Boolean study;
}