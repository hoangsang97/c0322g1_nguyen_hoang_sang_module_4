package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import vn.codegym.model.Facility;
import vn.codegym.repository.IFacilityRepository;
import vn.codegym.service.IFacilityService;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityServiceImpl implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAllFacility(pageable);
    }

    @Override
    public List<Facility> findAllFacility() {
        return facilityRepository.findAll();
    }

    @Override
    public Page<Facility> facilityAllById(int id, Pageable pageable) {
        return facilityRepository.facilityAllById(id, pageable);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void create(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void update(Facility facility) {
        facilityRepository.update(facility.getName(), facility.getArea(), facility.getCost(), facility.getMaxPeople(),
                facility.getRentType().getId(), facility.getFacilityType().getId(), facility.getStandardRoom(), facility.getDescriptionOtherConvenience()
                , facility.getPoolArea(), facility.getNumberOfFloors(), facility.getFacilityFree(), facility.getId());
    }

    @Override
    public void delete(int id) {
        facilityRepository.delete(id);
    }
}
