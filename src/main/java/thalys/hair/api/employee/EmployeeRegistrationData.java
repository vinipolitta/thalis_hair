package thalys.hair.api.employee;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import thalys.hair.api.address.AddressData;

public record EmployeeRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        String phone,
        @NotBlank
        @Email
        String email,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        AddressData address) {


}
