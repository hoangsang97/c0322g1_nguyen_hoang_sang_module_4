package vn.codegym.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoom> findAll();
}
