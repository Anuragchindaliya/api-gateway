package in.anurag.gatekeeper.management.dto.requestDto;

import in.anurag.gatekeeper.management.entity.OrganizationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationStatusRequest {
    @NotNull
    private OrganizationStatus status;
}
