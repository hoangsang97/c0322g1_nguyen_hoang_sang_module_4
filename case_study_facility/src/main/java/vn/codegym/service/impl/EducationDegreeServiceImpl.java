package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.EducationDegree;
import vn.codegym.repository.IEducationDegreeRepository;
import vn.codegym.service.IEducationDegreeService;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
