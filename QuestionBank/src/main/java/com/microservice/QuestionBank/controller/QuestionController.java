package com.microservice.QuestionBank.controller;

import com.microservice.QuestionBank.entity.Question;
import com.microservice.QuestionBank.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    @Autowired
    private final QuestionService questionService;

    // Create
    @PostMapping
    public Question addQuestion(@RequestBody Question question){
        return questionService.add(question);
    }

    // Get All
    @GetMapping
    public List<Question> getAllQuestion(){
        return questionService.getAll();
    }

    // Get
    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id){
        return questionService.get(id);
    }

    // Get questions from particular quiz id
    @GetMapping("/quiz/{quizId}")
    public List<Question> getAllQuestionsFromQuizId(@PathVariable Long quizId){
        return questionService.getQuestionsFromQuizId(quizId);
    }
}
