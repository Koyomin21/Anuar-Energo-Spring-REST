package itse1909r.borangaziyev.repository;

import itse1909r.borangaziyev.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class UserRepositoryTest {
    @Mock
    NamedParameterJdbcTemplate jdbcTemplate;
    @InjectMocks
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {
        List<User> result = userRepository.getAll();
        Assertions.assertEquals(Arrays.<User>asList(new User()), result);
    }

    @Test
    void testGetById() {
        User result = userRepository.getById(0);
        Assertions.assertEquals(new User(), result);
    }

    @Test
    void testBatchDeleteUserRolesByUser() {
        int[] result = userRepository.batchDeleteUserRolesByUser(0, new int[]{0});
        Assertions.assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void testDeleteUserById() {
        boolean result = userRepository.deleteUserById(0);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testBatchInsert() {
        int[] result = userRepository.batchInsert(Arrays.<User>asList(new User()));
        Assertions.assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void testInsertUser() {
        boolean result = userRepository.insertUser(new User());
        Assertions.assertEquals(true, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme