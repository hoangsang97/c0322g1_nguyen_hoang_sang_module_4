package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.CustomerType;
import vn.codegym.repository.ICustomerTypeRepository;
import vn.codegym.service.ICustomerTypeService;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
