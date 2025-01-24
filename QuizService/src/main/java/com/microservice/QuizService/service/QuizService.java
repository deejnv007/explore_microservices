package com.microservice.QuizService.service;

import com.microservice.QuizService.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);

    List<Quiz> getAll();

    Quiz get(Long id);
}
