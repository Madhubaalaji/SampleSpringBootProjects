package com.example.userDemo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="id")
    Integer id;

    @NotNull
    @NotBlank
    @Column(name="user_name")
    String name;

    @NotNull
    @NotBlank
    @Column(name="email")
    String email;

}
