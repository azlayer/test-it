package com.example.testit.service;

import com.example.testit.adapter.mail.MailService;
import com.example.testit.model.Task;
import com.example.testit.model.User;
import com.example.testit.repository.TaskRepository;
import com.example.testit.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class TaskServiceTest {

    TaskService taskService;
    UserRepository userRepository;
    MailService mailService;
    TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        mailService = Mockito.mock(MailService.class);
        taskRepository = Mockito.mock(TaskRepository.class);
        taskService = new TaskService(taskRepository, userRepository, mailService);
    }


    @Test
    void testCreateTask() {
        var assigned = new User();
        var requester = new User();

        Long requesterId = 1L;
        Long assignedId = 2L;

        assigned.setId(assignedId);
        requester.setId(requesterId);

        String title = "Task de test";
        String description = "test task description";

        Mockito.when(userRepository.findById(requesterId)).thenReturn(Optional.of(requester));
        Mockito.when(userRepository.findById(assignedId)).thenReturn(Optional.of(assigned));

        taskService.createTask(title, description, requesterId, assignedId);

        Assertions.assertThat(title).isEqualTo("Task de test");
        Assertions.assertThat(description).isEqualTo("test task description");
        Assertions.assertThat(requesterId).isEqualTo(1L);
        Assertions.assertThat(assignedId).isEqualTo(2L);
    }

    @Test
    void testDeleteTask() {
        Long taskId = 1L;
        taskService.deleteTask(taskId);
    }

    @Test
    void testFindAll() {
    taskService.findAll();
    }

    @Test
    void testFindById() {
        Long taskId = 1L;
        taskService.findById(taskId);
    }

    @Test
    void testFindByUserId() {
        Long userId = 2L;
        taskService.findByUserId(userId);
    }

    @Test
    void testFinishTask() {
        Long taskId = 1L;
        Long userId = 2L;
        taskService.finishTask(taskId, userId);

    }

    @Test
    void testStartTask() {
        Long taskId = 1L;
        Long userId = 2L;
        taskService.startTask(taskId, userId);
    }

    @Test
    void testUpdateTask() {
        Task task = new Task();
        task.setId(1L);
    }
}