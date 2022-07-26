package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Facility;
import vn.codegym.model.FacilityType;
import vn.codegym.model.RentType;
import vn.codegym.service.IFacilityService;
import vn.codegym.service.IFacilityTypeService;
import vn.codegym.service.IRentTypeService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @GetMapping("showList/{id}/{page}")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @PathVariable int page,
                           @PathVariable int id, Model model) {
        Page<Facility> facilities = null;
        if (id == 0) {
            facilities = facilityService.findAll(pageable.withPage(page));
        } else if (id == 1) {
            facilities = facilityService.facilityAllById(id, pageable.withPage(page));
        } else if (id == 2) {
            facilities = facilityService.facilityAllById(id, pageable.withPage(page));
        } else if (id == 3) {
            facilities = facilityService.facilityAllById(id, pageable.withPage(page));
        }

        model.addAttribute("facility", facilities);
        model.addAttribute("id", id);
        return "facility/list";
    }

    @GetMapping("showCreate/{id}")
    public String showCreate(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("facility", new Facility());
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityTypeList", facilityTypeList);
        return "facility/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Facility facility,
                         RedirectAttributes redirectAttributes) {
        facilityService.create(facility);
        redirectAttributes.addFlashAttribute("mess", "Create Ok!");
        return "redirect:/facility/showList/0/0";
    }

    @GetMapping("showUpdate/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        Optional<Facility> facility = facilityService.findById(id);
        model.addAttribute("facility", facility);
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityTypeList", facilityTypeList);
        return "facility/update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Facility facility,
                         RedirectAttributes redirectAttributes){
        if (facility.getFacilityType().getId() == 1) {
            facility.setFacilityFree(null);
        } else if (facility.getFacilityType().getId() == 2) {
            facility.setPoolArea(0);
        } else if (facility.getFacilityType().getId() == 3) {
            facility.setStandardRoom(null);
            facility.setDescriptionOtherConvenience(null);
            facility.setPoolArea(0);
            facility.setNumberOfFloors(0);
        }
        facilityService.update(facility);
        redirectAttributes.addFlashAttribute("mess", "Update OK");
        return "redirect:/facility/showList/0/0";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        facilityService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete OK");
        return "redirect:/facility/showList/0/0";
    }
}
