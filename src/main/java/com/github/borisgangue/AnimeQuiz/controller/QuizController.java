package com.github.borisgangue.AnimeQuiz.controller;

import com.github.borisgangue.AnimeQuiz.model.Quiz;
import com.github.borisgangue.AnimeQuiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = {"http://localhost:4200", "https://gangueboris.github.io"}) // Allow requests from Angular app (for testing) & // For deployed angular app

public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // Get all quiz
    @GetMapping("/quiz")
    public ResponseEntity<List<Quiz>> getAllQuiz() {
        return  new ResponseEntity<>(quizService.findAllQuiz(), HttpStatus.OK);
    }

    // Get quiz by id
    @GetMapping("/quiz/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("id") Long id) {
        return  new ResponseEntity<>(quizService.findQuizById(id), HttpStatus.OK);
    }

    // Add quiz
    @PostMapping("/quiz")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        return  new ResponseEntity<>(quizService.addQuiz(quiz), HttpStatus.CREATED);
    }

    // Update quiz
    @PutMapping("/quiz")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        return new ResponseEntity<>(quizService.updateQuiz(quiz), HttpStatus.OK);
    }

    // Delete quiz
    @DeleteMapping("/quiz/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable("id") Long id) {
        quizService.deleteQuiz(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}
