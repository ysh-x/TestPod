package NLP;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.grizzly.utils.Pair;

public class NLPBeanS {
	private static int numberOfQuestions;
	private static List<Pair<Integer,Integer>> limiters = new ArrayList<>();
	static List<Pair<String, String>> finalStructure = new ArrayList<>();
	public static List<Pair<Integer, Integer>> answerCount = new ArrayList<>();
	public static int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public static void setNumberOfQuestions(int numberOfQuestions) {
		NLPBeanS.numberOfQuestions = numberOfQuestions;
	}
	public static List<Pair<Integer, Integer>> getLimiters() {
		return limiters;
	}
	public static void setLimiters(List<Pair<Integer, Integer>> limiters) {
		NLPBeanS.limiters = limiters;
	}
	public static List<Pair<String, String>> getFinalStructure() {
		return finalStructure;
	}
	public static void setFinalStructure(List<Pair<String, String>> finalStructure) {
		NLPBeanS.finalStructure = finalStructure;
	}
	public static List<Pair<Integer, Integer>> getAnswerCount() {
		return answerCount;
	}
	public static void setAnswerCount(List<Pair<Integer, Integer>> answerCount) {
		NLPBeanS.answerCount = answerCount;
	} 
	
	
}
