package vn.codegym.service;

import vn.codegym.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void create(User user);
}
