package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.Account;
import vn.codegym.model.ClassRoom;
import vn.codegym.model.Course;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class StudentDto implements Validator {
    private int id;

    @NotBlank(message = "khong dc de trong")
    private String name;
    private int gender;
    private Account account;
    private ClassRoom classRoom;
    private Set<Course> courses;

    public StudentDto() {
    }

    public StudentDto(int id, String name, int gender, Account account, ClassRoom classRoom, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.account = account;
        this.classRoom = classRoom;
        this.courses = courses;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto = (StudentDto) target;
        if ("admin".equals(studentDto.getName())) {
            errors.rejectValue("name", "name.forbidden", "Khong dc nhap admin");
        }
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        StudentDto studentDto = (StudentDto) target;
//        if ("sang".equals(studentDto.getName())) {
//            errors.rejectValue("name", "name.forbidden", "khong duoc nhap admin");
//        }
//    }
}
