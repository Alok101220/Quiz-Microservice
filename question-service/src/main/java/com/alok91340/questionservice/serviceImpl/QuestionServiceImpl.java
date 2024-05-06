package com.alok91340.questionservice.serviceImpl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alok91340.questionservice.entities.Question;
import com.alok91340.questionservice.entities.QuestionWrapper;
import com.alok91340.questionservice.entities.Response;
import com.alok91340.questionservice.repository.QuestionRepository;
import com.alok91340.questionservice.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		Question savedQuestion = this.questionRepository.save(question);
		return savedQuestion;
		
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public List<Question> getAllQuestions() {
		
		return this.questionRepository.findAll();
	}

	@Override
	public void deleteQuestion(Integer questionId) {
		Question question = this.questionRepository.findById(questionId).get();
		
		this.questionRepository.delete(question);
		
	}

	@Override
	public List<Question> getByCategory(String category) {
		
		return this.questionRepository.findByCategory(category);
	}

	@Override
	public List<Integer> getQuestionsForQuiz(String category, int numQ) {
		List<Integer> questions=this.questionRepository.findRandomQuestionsByCategory(category, numQ);
		return questions;
	}

	@Override
	public List<QuestionWrapper> getQuestionsFromId(List<Integer> ids) {
		List<QuestionWrapper> questionWrappers= new ArrayList<>();
		List<Question> questions= new ArrayList<>();
		for(Integer id:ids) {
			questions.add(this.questionRepository.findById(id).get());
		}
		
		for(Question que:questions) {
			QuestionWrapper questionWrapper = new QuestionWrapper();
			questionWrapper.setQuestionId(que.getId());
			questionWrapper.setQuestionName(que.getQuestionName());
			questionWrapper.setOption1(que.getOption1());
			questionWrapper.setOption2(que.getOption2());
			questionWrapper.setOption3(que.getOption3());
			questionWrapper.setOption4(que.getOption4());
			questionWrapper.setDifficultyLevel(que.getDifficultyLevel());
			questionWrapper.setCategory(que.getCategory());
			
			questionWrappers.add(questionWrapper);
		}
		return questionWrappers;
	}

	@Override
	public Integer getScore(List<Response> responses) {
		int right=0;
		for(Response response:responses) {
			
			Question question = this.questionRepository.findById(response.getQuestionId()).get();
			if(response.getResponse().equals(question.getAnswer())) {
				right++;
			}
		}
		return right;
	}

}
