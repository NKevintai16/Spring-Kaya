package com.example.spring_kaya.entity;

import jakarta.persistence.*;
import jakarta.validation.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;


//JPA entity
@Data
@Entity
@Table(name = "routes")
public class ClimbingRoute {

    @Id
    @Column (nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Route Name cannot be blank")
    @Size(max = 100, message = "Route name must be less than 100 characters")
    @Column (nullable = false)
    private String routeName;

    @NotBlank(message = "Route difficulty cannot be blank")
    @Column(nullable = false)
    private String routeDifficulty;

    @NotBlank(message = "Location cannot be blank")
    @Size(max = 150, message = "Location must be less than 150 characters")
    @Column(nullable = false)
    private String location;

    @Column(nullable = true)
    private LocalDateTime dateCompleted;

    @Size(max = 500, message = "Notes must be less than 500 characters")
    @Column(length = 500)
    private String notes;
}
