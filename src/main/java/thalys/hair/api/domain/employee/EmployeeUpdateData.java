package thalys.hair.api.domain.employee;

import jakarta.validation.constraints.NotNull;
import thalys.hair.api.domain.address.AddressData;

public record EmployeeUpdateData(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address) {
}
