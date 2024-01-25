package thalys.hair.api.address;

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
}
