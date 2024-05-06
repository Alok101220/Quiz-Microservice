package com.alok91340.questionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alok91340.questionservice.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	List<Question> findByCategory(String category);
	
	@Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	List<Integer> findRandomQuestionsByCategory(String category, int numQ);

}