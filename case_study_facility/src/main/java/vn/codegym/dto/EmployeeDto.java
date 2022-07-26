package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.Division;
import vn.codegym.model.EducationDegree;
import vn.codegym.model.Position;

import javax.validation.constraints.NotBlank;

public class EmployeeDto implements Validator {
    private int id;

    @NotBlank
    private String name;
    private String dateOfBirth;
    private String idCard;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;
    private int status;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name, String dateOfBirth, String idCard, double salary, String phoneNumber, String email, String address, int status, Position position, EducationDegree educationDegree, Division division) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;

        String employeeDtoName = employeeDto.getName();
        String employeeDtoPhone = employeeDto.getPhoneNumber();
        String employeeDtoIdCard = employeeDto.getIdCard();
        String employeeDtoEmail = employeeDto.getEmail();
        String employeeDtoDateOfBirth = employeeDto.getDateOfBirth();

        if (!employeeDtoName.matches("^([A-Z]{1}[a-z]{1,}\\s{1}){1,}([A-Z]{1}[a-z]{1,})+$")) {
            errors.rejectValue("name", "employeeDtoName", "kí tự đầu tiên của mỗi từ phải viết hoa");
        }
        if (!employeeDtoPhone.matches("^(091|090|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}+$")) {
            errors.rejectValue("phoneNumber", "employeeDtoPhone", "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }
        if (!employeeDtoIdCard.matches("^\\d{9}+$")) {
            errors.rejectValue("idCard", "employeeDtoIdCard", "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX");
        }
        if (!employeeDtoEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", "employeeDtoEmail", "Địa chỉ email phải đúng định dạng.");
        }
        if (!employeeDtoDateOfBirth.matches("^(?:\\d{4}\\/(?:(?:(?:(?:0[13578]|1[02])\\/(?:0[1-9]|[1-2][0-9]|3[01]))|(?:(?:0[469]|11)\\/(?:0[1-9]|[1-2][0-9]|30))|(?:02\\/(?:0[1-9]|1[0-9]|2[0-8]))))|(?:(?:\\d{2}(?:0[48]|[2468][048]|[13579][26]))|(?:(?:[02468][048])|[13579][26])00)\\/02\\/29)$")) {
            errors.rejectValue("dateOfBirth", "employeeDtoDateOfBirth", "đúng định dạng ngày giờ theo format DD/MM/YYYY");
        }
    }
}
