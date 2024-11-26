package com.example.spring_kaya;

import jakarta.persistence.*;

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

    @Column (nullable = false)
    private String routeName;


    @Column(nullable = false)
    private String routeDifficulty;

    @Column(nullable = false)
    private String location;

    @Column(nullable = true)
    private LocalDateTime dateCompleted;

    @Column(length = 500)
    private String notes;
}
