package thalys.hair.api.domain.customer;

import jakarta.validation.constraints.NotNull;

public record CustomerUpdateData(
        @NotNull
        Long id,
        String name,
        String phone

) {
}
