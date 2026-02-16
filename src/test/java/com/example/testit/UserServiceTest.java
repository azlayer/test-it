package com.example.testit;

import com.example.testit.model.User;
import com.example.testit.repository.UserRepository;
import com.example.testit.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService UserService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Test User", "test");
        user.setId(1L);
    }

    @Test
    void loadUserByUsername_UserExists_ReturnsUserDetails() {
        when(userRepository.findByUsername("Test User")).thenReturn(Optional.of(user));

        UserDetails result = UserService.loadUserByUsername("Test User");

        assertThat(result.getUsername()).isEqualTo("Test User");
    }

}