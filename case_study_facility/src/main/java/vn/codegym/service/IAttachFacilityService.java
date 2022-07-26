package vn.codegym.service;

import vn.codegym.model.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    List<AttachFacility> findAllById(int id);
}
