package com.alok91340.questionservice.service;

import java.util.List;

import com.alok91340.questionservice.entities.Question;
import com.alok91340.questionservice.entities.QuestionWrapper;
import com.alok91340.questionservice.entities.Response;

public interface QuestionService {
	
	Question addQuestion(Question question);
	
	Question updateQuestion(Question question);
	
	List<Question> getAllQuestions();
	
	void deleteQuestion(Integer questionId);

	List<Question> getByCategory(String category);

	List<Integer> getQuestionsForQuiz(String category, int numQ);

	List<QuestionWrapper> getQuestionsFromId(List<Integer> ids);

	Integer getScore(List<Response> response);

}
