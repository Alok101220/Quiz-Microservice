package com.alok91340.quizservice.dto;

import lombok.Data;

@Data
public class QuizDto {
	private String category;
	private Integer numQuestions;
	private String title;
}
