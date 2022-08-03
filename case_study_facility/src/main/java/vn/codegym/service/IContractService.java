package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.dto.TotalDto;
import vn.codegym.model.Contract;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    List<TotalDto> totalMoneyContract();

    List<Contract> findAllContract();

    void create(Contract contract);
}
