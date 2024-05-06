package com.alok91340.quizservice.service;

import java.util.List;

import com.alok91340.quizservice.entities.QuestionWrapper;
import com.alok91340.quizservice.entities.Response;

public interface QuizService {
	
	void createQuiz(String category, int numQ, String title);
	List<QuestionWrapper> getQuizQuestions(Integer id);
	Integer calculateResult(Integer id, List<Response> response);

}
