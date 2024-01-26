package thalys.hair.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.*;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String public_place;
    private String cep;
    private String city;
    private String uf;
    private String neighborhood;
    private String number;
    private String complement;

    public Address(AddressData address) {
        this.public_place = address.public_place();
        this.neighborhood = address.neighborhood();
        this.cep = address.cep();
        this.city = address.city();
        this.uf = address.uf();
        this.number = address.number();
        this.complement = address.complement();
    }

    public void updateInfo(AddressData address) {
        if (address.public_place() != null) {
            this.public_place = address.public_place();
        }
        if (address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }
        if (address.cep() != null) {
            this.cep = address.cep();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.uf() != null) {
            this.uf = address.uf();
        }
        if (address.number() != null) {
            this.number = address.number();
        }
        if (address.complement() != null) {
            this.complement = address.complement();
        }
    }
}
