package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private int id;

    @NotEmpty
    @Size(min = 5, max = 45, message = "size phai tu 5 -> 45 tu")
    private String name;
    private int phone;

    @Min(value = 18, message = "phai tren 18 tuoi")
    private String dateOfBirth;
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String name, int phone, String dateOfBirth, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        String phone = String.valueOf(userDto.getPhone());
        String email = userDto.getEmail();
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "phone.regex", "phone khong dung dinh dang");
        }
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            errors.rejectValue("email", "email.regex", "email khong dung dinh dang");
        }
    }
}
