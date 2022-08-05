package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.model.MyUserDetail;
import vn.codegym.model.User;
import vn.codegym.repository.IUserRepository;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUserName(username);
       if (user == null) {
           throw new UsernameNotFoundException("Login That Bai");
       }

       return new MyUserDetail(user);
    }
}
