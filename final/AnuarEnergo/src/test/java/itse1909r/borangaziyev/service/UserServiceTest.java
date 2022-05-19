package itse1909r.borangaziyev.service;

import itse1909r.borangaziyev.model.User;
import itse1909r.borangaziyev.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.getAll()).thenReturn(Arrays.<User>asList(new User()));

        List<User> result = userService.getAllUsers();
        Assertions.assertEquals(Arrays.<User>asList(new User()), result);
    }

    @Test
    void testBatchInsertUsers() {
        when(userRepository.batchInsert(Arrays.asList(new User()))).thenReturn(new int[]{1});
        when(userRepository.batchInsert(Arrays.asList())).thenReturn(new int[]{});

        boolean result = userService.batchInsertUsers(Arrays.<User>asList(new User()));
        boolean result2 = userService.batchInsertUsers(Arrays.<User>asList());

        Assertions.assertEquals(true, result);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteUser() {
        when(userRepository.getById(1)).thenReturn(new User());
        when(userRepository.deleteUserById(1)).thenReturn(true);

        boolean result = userService.deleteUser(1);
        Assertions.assertEquals(true, result);
        Assertions.assertThrows(RuntimeException.class, ()->{
            userService.deleteUser(0);
        });
        Assertions.assertThrows(RuntimeException.class, ()->{
            userService.deleteUser(2);
        });
    }

    @Test
    void testInsertUser() {
        when(userRepository.insertUser(any())).thenReturn(true);

        boolean result = userService.insertUser(new User());
        Assertions.assertEquals(true, result);
    }

    @Test
    void testBatchDeleteUserRoles() {
        User user = new User();
        user.setUserId(1);
        when(userRepository.getById(1)).thenReturn(user);
        when(userRepository.getById(2)).thenReturn(null);
        when(userRepository.getById(3)).thenReturn(user);

        when(userRepository.batchDeleteUserRolesByUser(1, new int[]{1})).thenReturn(new int[]{1,2});
        when(userRepository.batchDeleteUserRolesByUser(3, new int[]{1})).thenReturn(new int[]{});

        boolean result = userService.batchDeleteUserRoles(1, new int[]{1});
        boolean result2 = userService.batchDeleteUserRoles(3, new int[]{1});
        Assertions.assertEquals(true, result);
        Assertions.assertEquals(false, result2);


        Assertions.assertThrows(RuntimeException.class, ()->{
            userService.batchDeleteUserRoles(0, new int[]{1});

        });
        Assertions.assertThrows(RuntimeException.class, ()->{
            userService.batchDeleteUserRoles(1, new int[]{});
        });
        Assertions.assertThrows(RuntimeException.class, ()->{
            userService.batchDeleteUserRoles(2, new int[]{1});

        });
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme