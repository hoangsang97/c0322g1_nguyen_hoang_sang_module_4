package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Facility;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    List<Facility> findAllFacility();

    Page<Facility> facilityAllById(int id, Pageable pageable);

    Optional<Facility> findById(int id);

    void create(Facility facility);

    void update(Facility facility);

    void delete(int id);
}
