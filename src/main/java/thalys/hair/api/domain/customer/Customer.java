package thalys.hair.api.domain.customer;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "customers")
@Entity(name = "Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Boolean active = true;

    public Customer(CustomerRegistrationData dados) {
        this.name = dados.name();
        this.email = dados.email();
        this.phone = dados.phone();
        if (dados.active() == null)
            this.active = true;
    }

    public void updateInfo(CustomerUpdateData dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.phone() != null) {
            this.phone = dados.phone();
        }
    }

    public void deleteCustomer() {
        this.active = false;
    }

    public void restoreCustomer() {
        this.active = true;
    }
}
