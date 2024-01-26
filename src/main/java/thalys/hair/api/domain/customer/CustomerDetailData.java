package thalys.hair.api.domain.customer;


public record CustomerDetailData(Long id, String name, String phone, Boolean active) {

    public CustomerDetailData(Customer customer) {
        this(customer.getId(), customer.getName(), customer.getPhone(), customer.getActive());
    }
}


