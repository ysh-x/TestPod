package com.ysh.exam;

import com.ysh.model.CreateExamBean;

public class ExamFactory {
	public Exam createExam(CreateExamBean examBean) {
		if(examBean.getQuestions().size() == 10) {
			TenQuestionExam exam = new TenQuestionExam();
			return exam;
		}
		return null;
	}
}
