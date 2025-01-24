package com.microservice.QuizService.service;

import com.microservice.QuizService.entities.Quiz;
import com.microservice.QuizService.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{

    @Autowired
    private final QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizzes =  quizRepository.findAll();
        List<Quiz> updatedQuizzes = quizzes.stream().map(quiz -> {
           quiz.setQuestions(questionClient.getQuestionsFromQuizId(quiz.getId()));
           return quiz;
        }).collect(Collectors.toList());
        return updatedQuizzes;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz =  quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found!"));
        quiz.setQuestions(questionClient.getQuestionsFromQuizId(quiz.getId()));
        return quiz;
    }
}
