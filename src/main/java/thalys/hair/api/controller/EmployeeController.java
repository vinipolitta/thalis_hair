package thalys.hair.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import thalys.hair.api.employee.Employee;
import thalys.hair.api.employee.EmployeeListData;
import thalys.hair.api.employee.EmployeeRegistrationData;
import thalys.hair.api.employee.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid EmployeeRegistrationData dados)  {

        repository.save(new Employee(dados));
    }

    @GetMapping
    public Page<EmployeeListData> getListEmployees(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        return repository.findAll(pagination).map(EmployeeListData::new);
    }

}
