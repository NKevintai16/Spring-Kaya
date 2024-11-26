package com.example.spring_kaya;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class ClimbingRouteController {

    @Autowired
    private ClimbingRouteRepository climbingRouteRepository;

    @GetMapping
    public List<ClimbingRoute> getAllRoutes(){
        return climbingRouteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClimbingRoute> getRouteById(@PathVariable Long id) {
        return climbingRouteRepository.findById(id)
                .map(climbingRoute -> ResponseEntity.ok().body(climbingRoute))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ClimbingRoute createRoute(@RequestBody ClimbingRoute route) {

        return climbingRouteRepository.save(route);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClimbingRoute> updateRoute(@PathVariable Long id, @RequestBody ClimbingRoute routeDetails) {
        return climbingRouteRepository.findById(id)
                .map(route -> {
                    route.setRouteName(routeDetails.getRouteName());
                    route.setLocation(routeDetails.getLocation());
                    route.setRouteDifficulty(routeDetails.getRouteDifficulty());
                    route.setDateCompleted(routeDetails.getDateCompleted());
                    route.setNotes(routeDetails.getNotes());
                    ClimbingRoute updatedRoute = climbingRouteRepository.save(route);
                    return ResponseEntity.ok(updatedRoute);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public  String deleteRoute(@PathVariable Long id) {
        climbingRouteRepository.deleteById(id);
        return "Deleted id: " + id;
    }
}
