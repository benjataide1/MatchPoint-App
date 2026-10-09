package com.app.matchpoint.service;

import com.app.matchpoint.model.User;
import com.app.matchpoint.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User createUser(User user) {

        if (!this.validator(user)) {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {

        User userToUpdate = userRepository.findById(id).orElse(null);

        if(userToUpdate == null){
            return null;
        }
        if(!this.validator(user)){
            return null;
        }

        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());

        return userRepository.save(userToUpdate);
    }

    @Override
    public boolean deleteUser(Long id) {

        User userToDelete = userRepository.findById(id).orElse(null);

        if(userToDelete == null){
            return false;
        }
        userRepository.delete(userToDelete);
        return true;
    }

    private boolean validator(User user) {

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return false;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return false;
        }
        if ((user.getName() == null) || user.getName().isEmpty()) {
            return false;
        }
        return true;
    }

}
