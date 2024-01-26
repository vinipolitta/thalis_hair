package thalys.hair.api.domain.employee;

import jakarta.persistence.*;
import lombok.*;
import thalys.hair.api.domain.address.Address;

@Table(name = "employees")
@Entity(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private Boolean active = true;

    public Employee(EmployeeRegistrationData dados) {
        this.name = dados.name();
        this.email = dados.email();
        this.phone = dados.phone();
        this.specialty = dados.specialty();
        this.address = new Address(dados.address());
        if (dados.active() == null)
        this.active = true;
    }

    public void updateInfo(EmployeeUpdateData dados) {
        if (dados.name() != null){
            this.name = dados.name();
        }
        if (dados.phone() != null) {
            this.phone = dados.phone();
        }
        if (dados.address() != null) {
            this.address.updateInfo(dados.address());
        }
    }

    public void deleteEmployee() {
        this.active = false;
    }

    public void restoreEmployee() {
        this.active = true;
    }
}
