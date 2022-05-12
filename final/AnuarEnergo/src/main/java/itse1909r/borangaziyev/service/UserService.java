package itse1909r.borangaziyev.service;

import itse1909r.borangaziyev.model.User;
import itse1909r.borangaziyev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public boolean batchInsertUsers(List<User> users) {
        int []inserted = userRepository.batchInsert(users);
        if(inserted.length != 0 || Arrays.stream(inserted).allMatch(row -> row != 0)) return true;

        return false;
    }

    public boolean deleteUser(int userId) {
        if(userId == 0) {
            throw new RuntimeException("There cannot be user with id 0");
        }

        User user = userRepository.getById(userId);
        if(user == null) {
            throw new RuntimeException("There is no user with such ID");
        }

        return userRepository.deleteUserById(userId);
    }

    public boolean insertUser(User user) {
        return userRepository.insertUser(user);
    }

    public boolean batchDeleteUserRoles(int userId, int []roleIds) {
        if(userId == 0) {
            throw new RuntimeException("Roles cannot be deleted because userId is 0");
        }

        if(userRepository.getById(userId) == null) {
            throw new RuntimeException("No user with such Id");
        }

        if(roleIds == null || roleIds.length == 0) {
            throw new RuntimeException("No roles to be deleted by user!");
        }

        int []results = userRepository.batchDeleteUserRolesByUser(userId, roleIds);

        if(results.length != 0 || Arrays.stream(results).allMatch(row -> row!=0)) return true;

        return false;
    }
}
