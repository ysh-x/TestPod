package NLP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.glassfish.grizzly.utils.Pair;

public class NLPDriver {

	private static int numberOfQuestions;
	private static List<Pair<Integer, Integer>> limiters = new ArrayList<>();
	private static List<Integer> sentenceCount = new ArrayList<>();
	static List<Pair<String, String>> finalStructure = new ArrayList<>();
	static List<Pair<Integer, Integer>> answerCount = new ArrayList<>();

	static List<String> answers = new ArrayList<>();

	public NLPDriver(ArrayList<String> answers) {
		NLPDriver.answers = answers;
	}

	@SuppressWarnings("static-access")
	public static NLPBean generateSkeleton() throws InvalidFormatException, IOException {
		NLPBean NLPB = new NLPBean();

		numberOfQuestions = answers.size();
		NLPBean.setNumberOfQuestions(numberOfQuestions);
		int tempCnt = 0;
		for (String answer : answers) {
			SentenceDetect SD = new SentenceDetect();
			String sentences[] = SD.sentenceFormation(answer);

			sentenceCount.add(sentences.length);

			Tokenizer TK = new Tokenizer();
			List<ArrayList<String>> tokenizedAns = new ArrayList<>();
			tokenizedAns = TK.tokenize(sentences);

					
			StopWordRemoval SWR = new StopWordRemoval();
			tokenizedAns = SWR.removeStopWords(tokenizedAns);
			
			for (ArrayList<String> l : tokenizedAns) {
				limiters.add(new Pair<Integer,Integer>(tempCnt,tempCnt + l.size()));
				tempCnt = tempCnt + l.size();

			}
			limiters.add(new Pair<Integer,Integer>(-1,-1));

			List<Pair<String,String>> tempAns = new ArrayList<>();
			POSTag PT = new POSTag();
			tempAns = PT.POSTagger(tokenizedAns);
			
		
			
			for(Pair<String,String> temp : tempAns) {
				finalStructure.add(new Pair<String, String>(temp.getSecond(),temp.getFirst()));
			}
		}
		
		int tmpSen = 0;
		for(int i = 0; i < limiters.size(); i++) {
			Pair<Integer,Integer> t = limiters.get(i);
			if(t.getFirst() == -1) {
				answerCount.add(new Pair<Integer,Integer> (tmpSen,i));
				tmpSen = i;
		}
		}
		NLPB.setLimiters(limiters);
		NLPB.setFinalStructure(finalStructure);
		NLPB.setAnswerCount(answerCount);
		
		return NLPB;
	}
}
