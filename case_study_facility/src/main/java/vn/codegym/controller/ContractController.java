package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.TotalDto;
import vn.codegym.dto.TotalMoneyDto;
import vn.codegym.model.*;
import vn.codegym.service.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("contract")
@CrossOrigin
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("showList")
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Contract> contracts = contractService.findAll(pageable);
        model.addAttribute("contract", contracts);
        List<TotalDto> totalDtoList = contractService.totalMoneyContract();
        model.addAttribute("totalDtoList", totalDtoList);
        model.addAttribute("contractDetail", new Contract());
        model.addAttribute("attachFacilityList", new AttachFacility());
        List<Customer> customerList = customerService.findAllCustomer();
        model.addAttribute("customerList", customerList);
        List<Facility> facilityList = facilityService.findAllFacility();
        model.addAttribute("facilityList", facilityList);
        List<AttachFacility> contractDetailList = attachFacilityService.findAll();
        model.addAttribute("contractDetailList", contractDetailList);
        List<Contract> contract = contractService.findAllContract();
        int idContract = 0;
        for (Contract item : contract) {
            idContract = item.getId();
        }
        model.addAttribute("idContract", idContract);
        return "contract/list";
    }

    @GetMapping("showListAttach/{id}")
    public String showListAttach(@PageableDefault(value = 5) Pageable pageable,
                                 @PathVariable int id, Model model) {
        Page<Contract> contracts = contractService.findAll(pageable);
        model.addAttribute("contract", contracts);
        List<TotalDto> totalDtoList = contractService.totalMoneyContract();
        model.addAttribute("totalDtoList", totalDtoList);
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

    @PostMapping("create")
    public String create(@ModelAttribute Contract contract,
                         RedirectAttributes redirectAttributes) {
        contractService.create(contract);
        redirectAttributes.addFlashAttribute("mess", "Create OK!");
        return "redirect:/contract/showList";
    }

    @PostMapping("createContractDetail")
    public String createContractDetail(@RequestBody ContractDetail contractDetail) {
        contractDetailService.create(contractDetail);
        return "redirect:/contract/showList";
    }

    @PostMapping("totalMoney")
    public ResponseEntity<?> totalMoney(@RequestBody String[][] totalMoney, @RequestParam int idFacility) {
        double total = 0;
        double costFacility = 0;
        List<Facility> facilityList = facilityService.findAllFacility();
        for (Facility item : facilityList) {
            if (item.getId() == idFacility) {
                costFacility = item.getCost();
            }
        }
        List<TotalMoneyDto> totalMoneyDtoList = new ArrayList<>();
        for (int i = 0; i < totalMoney.length; i++) {
            TotalMoneyDto totalMoneyDto = new TotalMoneyDto(parseInt(totalMoney[i][0]), parseDouble(totalMoney[i][1]));
            totalMoneyDtoList.add(totalMoneyDto);
        }

        for (TotalMoneyDto item : totalMoneyDtoList) {
            total = total + (item.getQuantity() * item.getCostContractDetail());
        }

        total = total + costFacility;
        return new ResponseEntity(total, HttpStatus.OK);
    }
}
