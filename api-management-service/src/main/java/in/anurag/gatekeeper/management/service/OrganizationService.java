package in.anurag.gatekeeper.management.service;

import in.anurag.gatekeeper.management.dto.requestDto.OrganizationRequest;
import in.anurag.gatekeeper.management.dto.requestDto.OrganizationResponse;
import in.anurag.gatekeeper.management.dto.requestDto.OrganizationStatusRequest;
import in.anurag.gatekeeper.management.entity.Organization;
import in.anurag.gatekeeper.management.entity.OrganizationStatus;
import in.anurag.gatekeeper.management.exception.ApiException;
import in.anurag.gatekeeper.management.repository.OrganizationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;
    public OrganizationService(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }
    public OrganizationResponse create (OrganizationRequest request){
        long startedAt = System.nanoTime();

        checkUnique(request.getName(),request.getSlug(),null);

        Organization organization = new Organization();

        organization.setName(request.getName());
        organization.setSlug(request.getSlug());
        organization.setStatus(OrganizationStatus.PENDING);
        organization.setCreatedAt(LocalDateTime.now());
        organization.setUpdatedAt(LocalDateTime.now());

        organizationRepository.save(organization);
        return OrganizationResponse.from(organization);
    }

    @Transactional
    public OrganizationResponse changeStatus(Long id, OrganizationStatusRequest request){
        long statedAt = System.nanoTime();
        Organization organization = getOrganization(id);

        if(request.getStatus() == OrganizationStatus.DELETED){
            throw new ApiException(HttpStatus.BAD_REQUEST,"Use DELETE to soft-delete an organization");
        }

        organization.setStatus(request.getStatus());
        organization.setUpdatedAt(LocalDateTime.now());

        return OrganizationResponse.from(organization);
    }

    private Organization getOrganization(Long id){
        return organizationRepository.findByIdAndStatusNot(id,OrganizationStatus.DELETED).orElseThrow(()->new ApiException(HttpStatus.NOT_FOUND,"Organization not found"));
    }
    private void checkUnique(String name, String slug, Long currentId){
        if(organizationRepository.existsByNameIgnoreCase(name)){
            Organization current = currentId == null ? null: organizationRepository.findById(currentId).orElse(null);
            if(current==null || !current.getName().equalsIgnoreCase(name)){
                throw new ApiException(HttpStatus.CONFLICT,"Organization name already exists");
            }
        }

        if(organizationRepository.existsBySlugIgnoreCase(slug)){
            Organization current = currentId == null ? null : organizationRepository.findById(currentId).orElse(null);
            if(current == null || !current.getSlug().equalsIgnoreCase(slug)){
                throw  new ApiException(HttpStatus.CONFLICT,"Organization slug already exists");
            }
        }
    }

}
