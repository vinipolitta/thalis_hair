package thalys.hair.api.employee;

public record EmployeeListData(
        String name,
        String email,
        Specialty specialty
) {
    public EmployeeListData(Employee employee) {
        this(employee.getName(), employee.getEmail(), employee.getSpecialty());
    }
}
