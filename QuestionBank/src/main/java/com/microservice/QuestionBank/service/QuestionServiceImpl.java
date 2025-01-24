package com.microservice.QuestionBank.service;

import com.microservice.QuestionBank.entity.Question;
import com.microservice.QuestionBank.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private final QuestionRepository questionRepository;

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found!"));
    }

    @Override
    public List<Question> getQuestionsFromQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
