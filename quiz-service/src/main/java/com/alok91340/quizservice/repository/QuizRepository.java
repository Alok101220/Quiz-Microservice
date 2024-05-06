package com.alok91340.quizservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alok91340.quizservice.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Integer>{

}
