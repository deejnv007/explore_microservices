package com.microservice.QuestionBank.service;

import com.microservice.QuestionBank.entity.Question;

import java.util.List;

public interface QuestionService {

    Question add(Question question);

    List<Question> getAll();

    Question get(Long id);

    List<Question> getQuestionsFromQuizId(Long quizId);
}
