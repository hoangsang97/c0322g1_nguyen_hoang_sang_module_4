package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class ListenDto implements Validator {
    private int id;

    @NotBlank
    @Max(800)
    private String listenName;
    @NotBlank
    @Max(300)
    private String artist;
    @NotBlank
    @Max(1000)
    private String category;
    private String pathFile;

    public ListenDto() {
    }

    public ListenDto(int id, String listenName, String artist, String category, String pathFile) {
        this.id = id;
        this.listenName = listenName;
        this.artist = artist;
        this.category = category;
        this.pathFile = pathFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListenName() {
        return listenName;
    }

    public void setListenName(String listenName) {
        this.listenName = listenName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ListenDto listenDto = (ListenDto) target;
        String listenName = listenDto.getListenName();
        String artist = listenDto.getArtist();
        String category = listenDto.getCategory();
        if (listenName.matches("[@&'(\\\\s)<>#]")){
            errors.rejectValue("listenName", "listenName.regex", "name Khong dung dinh dang");
        }
        if (artist.matches("[@&'(\\\\s)<>#]")){
            errors.rejectValue("artist", "artist.regex", "artist Khong dung dinh dang");
        }
        if (category.matches("[@&'(\\\\s)<>#]")){
            errors.rejectValue("category", "category.regex", "category Khong dung dinh dang");
        }
    }
}
