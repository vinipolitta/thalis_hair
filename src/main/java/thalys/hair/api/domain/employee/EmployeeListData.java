package thalys.hair.api.domain.employee;

public record EmployeeListData(
        Long id,
        String name,
        String email,
        Specialty specialty,
        boolean active
) {
    public EmployeeListData(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getEmail(), employee.getSpecialty(), employee.getActive() != null ? employee.getActive() : true);
    }
}
