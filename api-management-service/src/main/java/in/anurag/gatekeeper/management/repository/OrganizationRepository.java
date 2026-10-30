package in.anurag.gatekeeper.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.anurag.gatekeeper.management.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
     Boolean existsByNameIgnoreCase(String name);

     Boolean existsBySlugIgnoreCase(String slug);
}
