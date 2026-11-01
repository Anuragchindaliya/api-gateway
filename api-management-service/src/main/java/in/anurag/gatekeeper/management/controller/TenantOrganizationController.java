package in.anurag.gatekeeper.management.controller;

import in.anurag.gatekeeper.management.dto.requestDto.OrganizationResponse;
import in.anurag.gatekeeper.management.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tenant/organization")
public class TenantOrganizationController {
    private final OrganizationService organizationService;
    public TenantOrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }
    @GetMapping
    public ResponseEntity<OrganizationResponse> getOwnOrganization(){
        return ResponseEntity.ok(organizationService.getOwnOrganization());
    }
}
