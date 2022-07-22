package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
}
