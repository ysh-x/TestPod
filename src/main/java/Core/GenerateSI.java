package Core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.glassfish.grizzly.utils.Pair;

import NLP.FileRead;
import NLP.NLPBean;

public class GenerateSI {
	
	List<List<Float>> SIM = new ArrayList<List<Float>>();
	List<Float> SI = new ArrayList<Float>();
	List<Float> CI = new ArrayList<Float>();

	int numberOfQuestions = 0;

	List<Pair<Integer, Integer>> limitersS = new ArrayList<Pair<Integer, Integer>>();
	List<Pair<String, String>> finalStructureS = new ArrayList<Pair<String, String>>();
	List<Pair<Integer, Integer>> answerCountS = new ArrayList<Pair<Integer, Integer>>();

	List<Pair<Integer, Integer>> limitersF = new ArrayList<Pair<Integer, Integer>>();
	List<Pair<String, String>> finalStructureF = new ArrayList<Pair<String, String>>();
	List<Pair<Integer, Integer>> answerCountF = new ArrayList<Pair<Integer, Integer>>();

	@SuppressWarnings("static-access")
	public ReportBean generate(int testID, int examID) throws IOException {

		NLPBean FB = new NLPBean();
		FileRead FR = new FileRead();
		FB = FR.FileDecode(testID);
		limitersF = FB.getLimiters();
		finalStructureF = FB.getFinalStructure();
		answerCountF = FB.getAnswerCount();

		NLPBean SB = new NLPBean();
		FileRead FR1 = new FileRead();
		SB = FR1.FileDecode(examID);
		answerCountS = SB.getAnswerCount();
		limitersS = SB.getLimiters();
		finalStructureS = SB.getFinalStructure();
		numberOfQuestions = SB.getNumberOfQuestions();

		ReportBean FinalRB = new ReportBean();
		FindSI FS = new FindSI();
		float similarity = 0;
		float temp = 0;
		int sentencesF = 0;
		int count = 0;
		float errorR = 0;
		float result = 0;

		for (int i = 0; i < numberOfQuestions; i++) {
			sentencesF = (i == 0) ? 0 : -1;

			similarity = 0;
			Pair<Integer, Integer> boundsS = answerCountS.get(i);
			Pair<Integer, Integer> boundsF = answerCountF.get(i);

			sentencesF = sentencesF + boundsF.getSecond() - boundsF.getFirst();
			count = 0;

			for (int j = boundsS.getFirst(); j < boundsS.getSecond(); j++) {
				if (count > sentencesF)
					break;

				Pair<Integer, Integer> sentenceBound = limitersS.get(j);
				if (sentenceBound.getFirst() == -1)
					continue;
				else {
					ReportBean MasterRB = new ReportBean();
					List<Float> ans;
					List<Float> error;
					
					
					MasterRB = FS.find(finalStructureF, finalStructureS, sentenceBound, boundsF, limitersF);
					ans = MasterRB.getSimilarityIndex();
					error = MasterRB.getCorrectiveIndex();
					
					SIM.add(ans);
					temp = ans.get(0);
					for (Float a : ans) {
						temp = Math.max(temp, a);
					}
					similarity += temp;
					errorR = error.get(0);
					for (Float a : error) {
						errorR = Math.min(temp, a);
					}
				}
				count++;
			}

			result = (similarity) / sentencesF;
			SI.add(result);
			CI.add(errorR);

			List<Float> delim = new ArrayList<Float>();
			delim.add((float) -1);
			SIM.add(delim);
		}
		FinalRB.setCorrectiveIndex(CI);
		FinalRB.setSimilarityIndex(SI);
		FinalRB.setSimilarityMatrix(SIM);

		return FinalRB;
	}
}
