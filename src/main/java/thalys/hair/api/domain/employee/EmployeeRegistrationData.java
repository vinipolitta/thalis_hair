package thalys.hair.api.domain.employee;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import thalys.hair.api.domain.address.AddressData;

public record EmployeeRegistrationData(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank
        String phone,
        @NotBlank
        @Email
        String email,
        @NotNull
        Specialty specialty,


        Boolean active,
        @NotNull
        @Valid
        AddressData address) {


}
