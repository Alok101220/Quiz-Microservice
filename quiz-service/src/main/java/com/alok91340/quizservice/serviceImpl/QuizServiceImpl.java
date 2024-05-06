package com.alok91340.quizservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alok91340.quizservice.entities.QuestionWrapper;
import com.alok91340.quizservice.entities.Response;
import com.alok91340.quizservice.feign.QuizInterface;
import com.alok91340.quizservice.repository.QuizRepository;
import com.alok91340.quizservice.service.QuizService;
import com.alok91340.quizservice.entities.Quiz;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuizInterface quizInterface;

	@Override
	public void createQuiz(String category, int numQ, String title) {
		
		List<Integer> questionIds = this.quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		
		Quiz quiz =  new Quiz();
		
		quiz.setTitle(title);
		quiz.setQuestionIds(questionIds);
		
		Quiz q =this.quizRepository.save(quiz);
		System.out.println(q);
	
		
	}

	@Override
	public List<QuestionWrapper> getQuizQuestions(Integer id) {
		Quiz quiz =  this.quizRepository.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		
		List<QuestionWrapper> questions = this.quizInterface.getQuestionsFromId(questionIds).getBody();
		return questions;
	}

	@Override
	public Integer calculateResult(Integer id, List<Response> response) {
		Integer result = this.quizInterface.getScore(response).getBody();
		return result;
	}

}
