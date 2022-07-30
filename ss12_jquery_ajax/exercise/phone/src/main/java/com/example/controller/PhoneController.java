package com.example.controller;

import com.example.model.Phone;
import com.example.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/phone/api/v1")
@CrossOrigin
public class PhoneController {

    @Autowired
    private IPhoneService phoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> showPhone() {
        List<Phone> phoneList = phoneService.findAll();
        if (phoneList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phoneList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createPhone(@RequestBody Phone phone) {
        phoneService.create(phone);
        return new ResponseEntity(HttpStatus.OK);
    }
}
