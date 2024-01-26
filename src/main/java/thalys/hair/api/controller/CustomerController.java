package thalys.hair.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import thalys.hair.api.domain.customer.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid CustomerRegistrationData dados, UriComponentsBuilder uriBuilder)  {

        var customer = new Customer(dados);

        repository.save(customer);

        var uri = uriBuilder.path("/employee/{id}").buildAndExpand(customer.getId()).toUri();

        var dto = new CustomerDetailData(customer);

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<CustomerListData>> getListCustomers(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAll(pagination).map(CustomerListData::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/isActive")
    public ResponseEntity<Page<CustomerListData>> getListCustomersIsActive(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(CustomerListData::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id) {
        var customer = repository.getReferenceById(id);

        return  ResponseEntity.ok(new CustomerDetailData(customer));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateEmployee(@RequestBody @Valid CustomerUpdateData dados) {
        var customer = repository.getReferenceById(dados.id());
        customer.updateInfo(dados);

        return ResponseEntity.ok(new CustomerDetailData(customer));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        var customer = repository.getReferenceById(id);
        customer.deleteCustomer();
        return  ResponseEntity.noContent().build();

    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity restoreCustomer(@PathVariable Long id) {
        var customer = repository.getReferenceById(id);
        customer.restoreCustomer();
        return  ResponseEntity.noContent().build();

    }

}
