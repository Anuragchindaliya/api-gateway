package in.anurag.gatekeeper.management.controller;

import in.anurag.gatekeeper.management.dto.requestDto.responseDto.HealthResponse;
import in.anurag.gatekeeper.management.service.HealthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/health")
public class HealthController {

    private HealthService healthService;


    public HealthController(HealthService healthService){
        this.healthService = healthService;

    }
    @GetMapping
    public ResponseEntity<HealthResponse> health(){

        String dbStatus = healthService.getHealth();
        return ResponseEntity.ok(
                new HealthResponse("UP",dbStatus, LocalDateTime.now())
        );
    }
}
