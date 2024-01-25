package thalys.hair.api.employee;

import jakarta.persistence.*;
import lombok.*;
import thalys.hair.api.address.Address;

@Table(name = "employees")
@Entity(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Employee(EmployeeRegistrationData dados) {
        this.name = dados.name();
        this.email = dados.email();
        this.phone = dados.phone();
        this.specialty = dados.specialty();
        this.address = new Address(dados.address());
    }
}
