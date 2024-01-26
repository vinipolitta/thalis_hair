package thalys.hair.api.domain.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        String phone,
        @NotBlank
        @Email
        String email,
        Boolean active
) {
}
