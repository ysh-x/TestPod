package Core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import Fuzzy.InferenceEngine;

public class GenerateReport {

	public List<String> generateReport(int testID, ReportBean RB, List<String> answers) throws IOException {
		
		List<Float> SimilarityIndex = new ArrayList<Float>();
		List<Float> CorrectiveIndex = new ArrayList<Float>();
		List<List<Float>> SimilarityMatrix = new ArrayList<List<Float>>();
		List<String> FinalRemarks = new ArrayList<String>();
		
		String loc = "/home/ysh-mi/MajorProjects/TestPod/lib/files/" + testID + "S.txt";
		@SuppressWarnings("unused")
		File f0 = new File(loc);
		f0.createNewFile();
		FileWriter fw = new FileWriter(loc);

		fw.write("TestPod | An automated tool for subjective answer correction\n");
		fw.write("Version 1.0\n\n");

	  
		fw.write("Student report for the test ID: " + testID);
		fw.write("\n");
		fw.write("\n");

		SimilarityIndex = RB.getSimilarityIndex();
		CorrectiveIndex = RB.getCorrectiveIndex();
		SimilarityMatrix = RB.getSimilarityMatrix();
		InferenceEngine IE = new InferenceEngine();

		List<String> R1 = new ArrayList<String>();
		List<String> R2 = new ArrayList<String>();

		R1 = IE.getCorrectiveness(CorrectiveIndex);
		R2 = IE.getSimilarity(SimilarityIndex);

		fw.write("Similarity Metrics (With Respect To Faculty Answer Script)\n\n");

		int count = 1;
		final int marks = 3;
		int n = answers.size();
		fw.write("Answer " + count++);
		fw.write("\n");

		for (List<Float> x : SimilarityMatrix) {

			
			if (x.get(0) == -1) {
				if(count == n+1)
					break;
				fw.write("\n");
				fw.write("Answer " + count);
				fw.write("\n");
				count++;

			} else {
				fw.write(x.toString());
				fw.write("\n");

			}
		}

		count = 1;
		fw.write("\n");
		fw.write("Result Matrix");
		fw.write("\n");

		fw.write("Question\tSimilarity\tCorrectiveness\tMarks Awarded");
		fw.write("\n");

		float finale = 0;
		for (int i = 0; i < SimilarityIndex.size(); i++) {
			String x1 = String.format("%.2f", SimilarityIndex.get(i));
			String x2 = String.format("%.2f", CorrectiveIndex.get(i));
			String x3 = String.format("%.1f", (marks * SimilarityIndex.get(i)));
			finale += marks * SimilarityIndex.get(i);
			fw.write(count++ + "       \t\t       " + x1 + "\t\t         " + x2 + "\t\t\t" + x3);
			fw.write("\n");

		}
		String x4 = String.format("%.1f",finale);
		fw.write("\t\tFinal Score\t\t"+ x4);
		fw.write("\n");


		count = 1;
		fw.write("\nRemarks");
		fw.write("\n");

		for (int i = 0; i < R1.size(); i++) {
			fw.write("Answer " + count++);
			fw.write("\n");

			fw.write(R1.get(i));
			fw.write("\n");

			fw.write(R2.get(i));
			fw.write("\n");
			fw.write("\n");
			
			FinalRemarks.add(R1.get(i) + ". "+R2.get(i)+".");
		}
		fw.flush();
		fw.close();
		System.out.println("Report Generated");
		return FinalRemarks;
	}
	
}
