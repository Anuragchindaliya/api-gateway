package in.anurag.gatekeeper.management.controller;

import in.anurag.gatekeeper.management.dto.requestDto.OrganizationRequest;
import in.anurag.gatekeeper.management.dto.requestDto.OrganizationResponse;
import in.anurag.gatekeeper.management.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/platform/organization")
public class PlatformOrganizationController {
    private final OrganizationService organizationService;

    public PlatformOrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }

    @PostMapping
    public ResponseEntity<OrganizationResponse> create(@Valid @RequestBody OrganizationRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationService.create(request));
    }
}
