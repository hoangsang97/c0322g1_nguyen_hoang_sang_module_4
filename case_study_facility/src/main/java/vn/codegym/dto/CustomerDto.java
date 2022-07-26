package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.CustomerType;

import javax.validation.constraints.NotBlank;

public class CustomerDto implements Validator {
    private int id;

    @NotBlank
    private String name;
    private String dateOfBirth;
    private int gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private int status;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String dateOfBirth, int gender, String idCard, String phoneNumber, String email, String address, int status, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.customerType = customerType;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        String customerDtoName = customerDto.getName();
        String customerDtoPhone = customerDto.getPhoneNumber();
        String customerDtoIdCard = customerDto.getIdCard();
        String customerDtoEmail = customerDto.getEmail();
        String customerDtoDateOfBirth = customerDto.getDateOfBirth();

        if (!customerDtoName.matches("^([A-Z]{1}[a-z]{1,}\\s{1}){1,}([A-Z]{1}[a-z]{1,})+$")) {
            errors.rejectValue("name", "customerDtoName", "kí tự đầu tiên của mỗi từ phải viết hoa");
        }
        if (!customerDtoPhone.matches("^(091|090|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}+$")) {
            errors.rejectValue("phoneNumber", "customerDtoPhone", "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }
        if (!customerDtoIdCard.matches("^\\d{9}+$")) {
            errors.rejectValue("idCard", "customerDtoIdCard", "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX");
        }
        if (!customerDtoEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", "customerDtoEmail", "Địa chỉ email phải đúng định dạng.");
        }
        if (!customerDtoDateOfBirth.matches("^(?:\\d{4}\\/(?:(?:(?:(?:0[13578]|1[02])\\/(?:0[1-9]|[1-2][0-9]|3[01]))|(?:(?:0[469]|11)\\/(?:0[1-9]|[1-2][0-9]|30))|(?:02\\/(?:0[1-9]|1[0-9]|2[0-8]))))|(?:(?:\\d{2}(?:0[48]|[2468][048]|[13579][26]))|(?:(?:[02468][048])|[13579][26])00)\\/02\\/29)$")) {
            errors.rejectValue("dateOfBirth", "customerDtoDateOfBirth", "đúng định dạng ngày giờ theo format DD/MM/YYYY");
        }

    }
}
