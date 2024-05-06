package com.alok91340.questionservice.entities;

import lombok.Data;

@Data
public class QuestionWrapper {
	
	private Integer questionId;
	
	private String questionName;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String category;
	private String difficultyLevel;
}
