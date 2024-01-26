package thalys.hair.api.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
        @NotBlank
        String public_place,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String city,
        @NotBlank
        String neighborhood,
        @NotBlank
        String uf,
        String complement,
        String number) {
}
