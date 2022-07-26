package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.AttachFacility;
import vn.codegym.model.Contract;
import vn.codegym.model.Customer;
import vn.codegym.model.Facility;
import vn.codegym.service.IAttachFacilityService;
import vn.codegym.service.IContractService;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.IFacilityService;

import java.util.List;

@Controller
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @GetMapping("showList")
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Contract> contracts = contractService.findAll(pageable);
        model.addAttribute("contract", contracts);
        model.addAttribute("contractDetail", new Contract());
        model.addAttribute("attachFacilityList", new AttachFacility());
        List<Customer> customerList = customerService.findAllCustomer();
        model.addAttribute("customerList", customerList);
        List<Facility> facilityList = facilityService.findAllFacility();
        model.addAttribute("facilityList", facilityList);
        List<AttachFacility> contractDetailList = attachFacilityService.findAll();
        model.addAttribute("contractDetailList", contractDetailList);
        return "contract/list";
    }

    @GetMapping("showListAttach/{id}")
    public String showListAttach(@PageableDefault(value = 5) Pageable pageable,
                                 @PathVariable int id, Model model) {
        Page<Contract> contracts = contractService.findAll(pageable);
        model.addAttribute("contract", contracts);
        model.addAttribute("contractDetail", new Contract());
        List<AttachFacility> attachFacilityList = attachFacilityService.findAllById(id);
        model.addAttribute("attachFacilityList", attachFacilityList);
        List<Customer> customerList = customerService.findAllCustomer();
        model.addAttribute("customerList", customerList);
        List<Facility> facilityList = facilityService.findAllFacility();
        model.addAttribute("facilityList", facilityList);
        List<AttachFacility> contractDetailList = attachFacilityService.findAll();
        model.addAttribute("contractDetailList", contractDetailList);
        model.addAttribute("flag", 1);
        return "contract/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("contractDetail", new Contract());
        List<Customer> customerList = customerService.findAllCustomer();
        model.addAttribute("customerList", customerList);
        List<Facility> facilityList = facilityService.findAllFacility();
        model.addAttribute("facilityList", facilityList);
        return "contract/list";
    }
}
