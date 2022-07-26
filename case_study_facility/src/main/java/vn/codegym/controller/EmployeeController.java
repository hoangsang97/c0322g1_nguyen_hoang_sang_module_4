package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.EmployeeDto;
import vn.codegym.model.Division;
import vn.codegym.model.EducationDegree;
import vn.codegym.model.Employee;
import vn.codegym.model.Position;
import vn.codegym.service.IDivisionService;
import vn.codegym.service.IEducationDegreeService;
import vn.codegym.service.IEmployeeService;
import vn.codegym.service.IPositionService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IDivisionService divisionService;

    @GetMapping("showList")
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employee", employees);
        model.addAttribute("employeeEmpty", new Employee());
        model.addAttribute("employeeById", new Employee());
        return "employee/list";
    }

    @GetMapping("showCreate")
    public String showCreate(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employee", employees);
        model.addAttribute("employeeEmpty", new Employee());
        model.addAttribute("employeeById", new Employee());
        List<Position> positionList = positionService.findAll();
        model.addAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        model.addAttribute("educationDegreeList", educationDegreeList);
        List<Division> divisionList = divisionService.findAll();
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("flag", 1);
        return "employee/list";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Employee employee,
                         RedirectAttributes redirectAttributes) {
        employeeService.create(employee);
        redirectAttributes.addFlashAttribute("mess", "Create OK");
        return "redirect:/employee/showList";
    }

    @GetMapping("showUpdate/{id}")
    public String showUpdate(@PageableDefault(value = 5) Pageable pageable,
                             @PathVariable int id, Model model) {
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employee", employees);
        model.addAttribute("employeeEmpty", new Employee());
        Optional<Employee> employeeById = employeeService.findById(id);
        model.addAttribute("employeeById", employeeById);
        List<Position> positionList = positionService.findAll();
        model.addAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        model.addAttribute("educationDegreeList", educationDegreeList);
        List<Division> divisionList = divisionService.findAll();
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("check", 1);
        return "employee/list";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Employee employee,
                         RedirectAttributes redirectAttributes) {
        employeeService.update(employee);
        redirectAttributes.addFlashAttribute("mess", "Update OK");
        return "redirect:/employee/showList";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete OK");
        return "redirect:/employee/showList";
    }
}
