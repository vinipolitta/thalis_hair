package thalys.hair.api.domain.customer;

public record CustomerListData(
        Long id,
        String name,
        String phone,
        boolean active
) {
    public CustomerListData(Customer customer) {
        this(customer.getId(), customer.getName(), customer.getPhone(), customer.getActive() != null ? customer.getActive() : true);
    }
}