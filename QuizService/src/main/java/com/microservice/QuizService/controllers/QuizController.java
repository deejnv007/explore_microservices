package com.microservice.QuizService.controllers;

import com.microservice.QuizService.entities.Quiz;
import com.microservice.QuizService.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    @Autowired
    private final QuizService quizService;

    // Create
    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    // Get All
    @GetMapping
    public List<Quiz> getAllQuiz(){
        return quizService.getAll();
    }

    // Get
    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable Long id){
        return quizService.get(id);
    }
}
