package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Listen;
import vn.codegym.repository.IListenRepository;
import vn.codegym.service.IListenService;

import java.util.Optional;

@Service
public class ListenService implements IListenService {
    @Autowired
    private IListenRepository listenRepository;

    @Override
    public Page<Listen> findAll(Pageable pageable) {
        return listenRepository.findAll(pageable);
    }

    @Override
    public Optional<Listen> findById(int id) {
        return listenRepository.findById(id);
    }

    @Override
    public void create(Listen listen) {
        listenRepository.save(listen);
    }

    @Override
    public void update(Listen listen) {
        listenRepository.update(listen.getListenName(), listen.getArtist(), listen.getCategory(), listen.getPathFile(), listen.getId());
    }

    @Override
    public void delete(int id) {
        listenRepository.deleteById(id);
    }

    @Override
    public Page<Listen> search(String name, Pageable pageable) {
        return listenRepository.findByName("%" + name + "%", pageable);
    }
}
