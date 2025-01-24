package com.microservice.QuizService.service;

import com.microservice.QuizService.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8092", value = "Question-Client")
@FeignClient(name = "QUESTIONBANK")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionsFromQuizId(@PathVariable Long quizId);
}
