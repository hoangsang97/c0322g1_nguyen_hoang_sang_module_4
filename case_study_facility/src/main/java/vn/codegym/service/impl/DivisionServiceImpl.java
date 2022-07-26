package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Division;
import vn.codegym.repository.IDivisionRepository;
import vn.codegym.service.IDivisionService;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {

    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
