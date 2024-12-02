package com.example.spring_kaya.repository;

import com.example.spring_kaya.entity.ClimbingRoute;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ClimbingRouteRepository extends JpaRepository<ClimbingRoute, Long> {

}
