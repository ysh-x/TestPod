package com.ysh.exam;

import java.util.Collections;
import java.util.List;

import com.ysh.model.StudentReportBean;

public class GeneratePersonalisedReport {

	public String generatePersonalisedReport(StudentReportBean bean) {
		StringBuilder ansBuilder = new StringBuilder();
		float total = 0.0f;
		float average = 0.0f;
		List<Float> marks = bean.getMarks();
		List<String> remarks = bean.getRemarks();

		for (Float mark : marks) {
			total = total + mark;
		}
		average = total / 10.0f;
		
		ansBuilder.append("The student has scored a total of " + total + " out of 30. "
				+ "The average score of the student in the test is " + average + ". ");
		
		String tempRemark = null;
		int max = 0;
		for(String remark:remarks) {
			if(Collections.frequency(remarks, remark) > max) {
				tempRemark = remark;
			}
		}
		ansBuilder.append(" Overall, "+tempRemark);
		return ansBuilder.toString();
	}
}
