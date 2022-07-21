package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.ClassRoom;
import vn.codegym.repository.IClassRoomRepository;
import vn.codegym.service.IClassRoomService;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {
    @Autowired
    IClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }
}
