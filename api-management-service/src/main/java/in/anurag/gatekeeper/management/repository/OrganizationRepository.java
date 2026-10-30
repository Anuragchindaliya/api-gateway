package in.anurag.gatekeeper.management.repository;

import in.anurag.gatekeeper.management.entity.OrganizationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.anurag.gatekeeper.management.entity.Organization;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
     Boolean existsByNameIgnoreCase(String name);

     Boolean existsBySlugIgnoreCase(String slug);

     Optional<Organization> findByIdAndStatusNot(Long id, OrganizationStatus status);
}
