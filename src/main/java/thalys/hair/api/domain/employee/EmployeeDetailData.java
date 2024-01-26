package thalys.hair.api.domain.employee;

import thalys.hair.api.domain.address.Address;

public record EmployeeDetailData(Long id, String name, String phone, Boolean active, Specialty specialty, Address address) {

    public EmployeeDetailData(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getPhone(), employee.getActive(), employee.getSpecialty(), employee.getAddress());
    }
}
