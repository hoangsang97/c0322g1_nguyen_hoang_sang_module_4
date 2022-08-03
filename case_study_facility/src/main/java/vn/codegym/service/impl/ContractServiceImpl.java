package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.dto.TotalDto;
import vn.codegym.model.AttachFacility;
import vn.codegym.model.Contract;
import vn.codegym.model.ContractDetail;
import vn.codegym.repository.IAttachFacilityRepository;
import vn.codegym.repository.IContractDetailRepository;
import vn.codegym.repository.IContractRepository;
import vn.codegym.service.IContractService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Autowired
    private IContractDetailRepository contractDetailRepository;


    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<TotalDto> totalMoneyContract() {
        List<Contract> contractList = contractRepository.findAll();
        List<TotalDto> totalDtoList = new ArrayList<>();
        List<AttachFacility> attachFacilityList = attachFacilityRepository.findAll();
        List<ContractDetail> contractDetailList = contractDetailRepository.findAll();
        for (int i = 0; i < contractList.toArray().length; i++) {
            double totalDetail = 0;
            double costFacility = 0;

            costFacility = contractList.get(i).getFacility().getCost();
            for (ContractDetail item : contractDetailList) {
                if (item.getContract().getId() == contractList.get(i).getId()) {
                    for (AttachFacility attach : attachFacilityList) {
                        if (attach.getId() == item.getAttachFacility().getId()) {
                            totalDetail = totalDetail + (item.getQuantity() * attach.getCost());
                        }
                    }
                }
            }

            totalDtoList.add(new TotalDto(contractList.get(i).getId(), contractList.get(i).getStartDate(),
                    contractList.get(i).getEndDate(), contractList.get(i).getDeposit(),
                    contractList.get(i).getCustomer(), contractList.get(i).getFacility(),
                    costFacility + totalDetail));
        }

        return totalDtoList;
    }

    @Override
    public List<Contract> findAllContract() {
        return contractRepository.findAll();
    }


    @Override
    public void create(Contract contract) {
        contractRepository.save(contract);
    }
}
