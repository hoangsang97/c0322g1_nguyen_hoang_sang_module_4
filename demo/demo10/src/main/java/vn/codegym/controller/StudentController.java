package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.ClassRoom;
import vn.codegym.model.Student;
import vn.codegym.service.IClassRoomService;
import vn.codegym.service.ICourseService;
import vn.codegym.service.IStudentService;

import java.util.Date;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassRoomService classRoomService;

    @Autowired
    private ICourseService courseService;

    @GetMapping("showList")
    public String showList(@PageableDefault(value = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                           Model model) {
        Page<Student> studentList = studentService.findAll(pageable);
        model.addAttribute("student", studentList);
        return "student/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classRoomList", classRoomService.findAll());
        model.addAttribute("courseList", courseService.findAll());
        return "student/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Student student,
                         RedirectAttributes redirectAttributes) {
        student.getAccount().setDateCreate(new Date(System.currentTimeMillis()));
        studentService.create(student);
        redirectAttributes.addFlashAttribute("mess", "Create OK");
        return "redirect:/student/showList";
    }
}
