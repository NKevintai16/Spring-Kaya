package com.example.spring_kaya;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ClimbingRouteRepository extends JpaRepository<ClimbingRoute, Long> {

}
