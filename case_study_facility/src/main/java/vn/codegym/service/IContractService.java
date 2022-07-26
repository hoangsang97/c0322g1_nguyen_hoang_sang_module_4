package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Contract;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
}
