package itse1909r.borangaziyev.controller;

import itse1909r.borangaziyev.model.SocketMessage;
import itse1909r.borangaziyev.model.User;
import itse1909r.borangaziyev.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class UserControllerTest {
    @Mock
    UserService userService;
    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllUsers() {
        when(userService.getAllUsers()).thenReturn(Arrays.<User>asList(new User()));

        List<User> result = userController.getAllUsers();
        Assertions.assertEquals(Arrays.<User>asList(new User()), result);
    }

    @Test
    void testAddUser() {
        when(userService.insertUser(any())).thenReturn(true);

        String result = userController.addUser(new User());
        Assertions.assertEquals("User(userId=0, firstName=null, lastName=null, username=null, password=null)", result);
    }

    @Test
    void testDeleteUser() {
        when(userService.deleteUser(anyInt())).thenReturn(true);

        String result = userController.deleteUser(0);
        Assertions.assertEquals("Successfully Deleted", result);
    }

    @Test
    void testGetUserChat() {
        String result = userController.getUserChat(null);
        Assertions.assertEquals("chat", result);
    }

    @Test
    void testSend() {
        SocketMessage result = userController.send(new SocketMessage());
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme