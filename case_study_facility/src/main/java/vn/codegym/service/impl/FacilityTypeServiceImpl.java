package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.FacilityType;
import vn.codegym.repository.IFacilityTypeRepository;
import vn.codegym.service.IFacilityTypeService;

import java.util.List;

@Service
public class FacilityTypeServiceImpl implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;


    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
