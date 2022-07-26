package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Contract;
import vn.codegym.repository.IContractRepository;
import vn.codegym.service.IContractService;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private IContractRepository contractRepository;


    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }
}
