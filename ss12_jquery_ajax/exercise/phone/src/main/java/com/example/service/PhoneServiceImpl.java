package com.example.service;

import com.example.model.Phone;
import com.example.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneServiceImpl implements IPhoneService{

    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(int id) {
        return phoneRepository.findById(id);
    }

    @Override
    public void create(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void update(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void delete(int id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public List<Phone> search(String name) {
        return null;
    }
}
