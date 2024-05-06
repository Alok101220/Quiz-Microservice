package com.alok91340.quizservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alok91340.quizservice.dto.QuizDto;
import com.alok91340.quizservice.entities.QuestionWrapper;
import com.alok91340.quizservice.entities.Response;
import com.alok91340.quizservice.service.QuizService;

@RestController
@RequestMapping("api/quiz/")
public class QuizController {
	
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
		this.quizService.createQuiz(quizDto.getCategory(), quizDto.getNumQuestions(), quizDto.getTitle());
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		
	}
	
	@GetMapping("getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
		return new ResponseEntity<>(this.quizService.getQuizQuestions(id),HttpStatus.OK);
	}

	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
		return new ResponseEntity<>(this.quizService.calculateResult(id, response),HttpStatus.OK);
	}
}
