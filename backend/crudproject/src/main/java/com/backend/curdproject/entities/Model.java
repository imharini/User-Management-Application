package com.backend.curdproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curd_table")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "username should not be empty")
    private String username;
    @NotBlank(message = "name should not be empty")
    private String name;
    @Email
    private String email;

}
