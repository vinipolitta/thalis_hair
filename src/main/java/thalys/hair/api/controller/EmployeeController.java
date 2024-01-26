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
import thalys.hair.api.domain.employee.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid EmployeeRegistrationData dados, UriComponentsBuilder uriBuilder)  {

        var employee = new Employee(dados);

        repository.save(employee);

        var uri = uriBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri();

        var dto = new EmployeeDetailData(employee);

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeListData>> getListEmployees(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAll(pagination).map(EmployeeListData::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/isActive")
    public ResponseEntity<Page<EmployeeListData>> getListEmployeesIsActive(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(EmployeeListData::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Long id) {
        var employee = repository.getReferenceById(id);

        return  ResponseEntity.ok(new EmployeeDetailData(employee));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateEmployee(@RequestBody @Valid EmployeeUpdateData dados) {
        var employee = repository.getReferenceById(dados.id());
        employee.updateInfo(dados);

        return ResponseEntity.ok(new EmployeeDetailData(employee));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var employee = repository.getReferenceById(id);
        employee.deleteEmployee();
        return  ResponseEntity.noContent().build();

    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity restoreEmployee(@PathVariable Long id) {
        var employee = repository.getReferenceById(id);
        employee.restoreEmployee();
        return  ResponseEntity.noContent().build();

    }

}
