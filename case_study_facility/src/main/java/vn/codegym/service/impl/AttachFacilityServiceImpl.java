package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.AttachFacility;
import vn.codegym.repository.IAttachFacilityRepository;
import vn.codegym.service.IAttachFacilityService;

import java.util.List;

@Service
public class AttachFacilityServiceImpl implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public List<AttachFacility> findAllById(int id) {
        return attachFacilityRepository.findAllAttachFacility(id);
    }

    @Override
    public void create(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }
}
