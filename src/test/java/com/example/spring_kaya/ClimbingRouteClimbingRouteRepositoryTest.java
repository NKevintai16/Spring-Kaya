package com.example.spring_kaya;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClimbingRouteClimbingRouteRepositoryTest {

    @Autowired
    private ClimbingRouteRepository climbingRouteRepository;

    @Test
    public void testSaveandFindByID() {
        // Create the route
        ClimbingRoute route = new ClimbingRoute();
        route.setRouteName("Eagle Perch");
        route.setLocation("Plano");
        route.setRouteDifficulty("v1");
        route.setDateCompleted(LocalDateTime.of(2024,11,22,14,30));

        // Save the route
        ClimbingRoute savedRoute = climbingRouteRepository.save(route);

        ClimbingRoute fetchedRoute = climbingRouteRepository.findById(savedRoute.getId()).orElse(null);

        assertThat(fetchedRoute).isNotNull();
        assertThat(fetchedRoute.getRouteName()).isEqualTo("Eagle Perch");
        assertThat(fetchedRoute.getLocation()).isEqualTo("Plano");
        assertThat(fetchedRoute.getRouteDifficulty()).isEqualTo("v1");
        assertThat(fetchedRoute.getDateCompleted()).isEqualTo(LocalDateTime.of(2024,11,22,14,30));
    }

    @Test
    public void testFindAll(){
        ClimbingRoute route1 = new ClimbingRoute();
        route1.setRouteName("Eagle Perch");
        route1.setLocation("Plano");
        route1.setRouteDifficulty("v1");
        route1.setDateCompleted(LocalDateTime.now());

        ClimbingRoute route2 = new ClimbingRoute();
        route2.setRouteName("Ankle Biter");
        route2.setLocation("DD");
        route2.setRouteDifficulty("v99");
        route2.setDateCompleted(LocalDateTime.now());

        climbingRouteRepository.save(route1);
        climbingRouteRepository.save(route2);

        List<ClimbingRoute> routes = climbingRouteRepository.findAll();

        assertThat(routes.size()).isEqualTo(2);
    }
}
