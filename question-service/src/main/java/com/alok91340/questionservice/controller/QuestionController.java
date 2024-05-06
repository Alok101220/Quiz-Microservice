package com.alok91340.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alok91340.questionservice.entities.Question;
import com.alok91340.questionservice.entities.QuestionWrapper;
import com.alok91340.questionservice.entities.Response;
import com.alok91340.questionservice.service.QuestionService;

@RestController
@RequestMapping("api/question/")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("addQuestion")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		
		return new ResponseEntity<>(questionService.addQuestion(question),HttpStatus.CREATED);
	}

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestion(){
		return new ResponseEntity<>(this.questionService.getAllQuestions(),HttpStatus.OK);
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getAllQuestionByCategory(@PathVariable String category){
		return new ResponseEntity<>(this.questionService.getByCategory(category),HttpStatus.OK);
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer> >getQuestionsForQuiz(@RequestParam String category, @RequestParam int numQ){
		
		return new ResponseEntity<>(this.questionService.getQuestionsForQuiz(category,numQ), HttpStatus.OK);
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> ids){
		return new ResponseEntity<>(this.questionService.getQuestionsFromId(ids),HttpStatus.OK);
	}
	
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> response){
		
		return new ResponseEntity<>(this.questionService.getScore(response), HttpStatus.OK);
	}
	
}
