package com.example.testit.repository;

import com.example.testit.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskRepositoryIT {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void test1FindByAssignedUserId() {
        var assigned1 = new User();
        var assigned2 = new User();

        Long assigned1Id = 1L;
        Long assigned2Id = 2L;

        assigned1.setId(assigned1Id);
        assigned2.setId(assigned2Id);

        assigned1 = userRepository.save(assigned1);
        assigned2 = userRepository.save(assigned2);

        var assigned1UserId = userRepository.findById(assigned1.getId()).orElseThrow();
        var assigned2UserId = userRepository.findById(assigned2.getId()).orElseThrow();

        Assertions.assertThat(assigned1UserId.getId()).isEqualTo(1L);
        Assertions.assertThat(assigned2UserId.getId()).isEqualTo(2L);

    }
}
