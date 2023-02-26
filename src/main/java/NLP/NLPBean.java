package NLP;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.grizzly.utils.Pair;

public class NLPBean {
	private static int numberOfQuestions;
	private static List<Pair<Integer,Integer>> limiters = new ArrayList<Pair<Integer, Integer>>();
	static List<Pair<String, String>> finalStructure = new ArrayList<Pair<String, String>>();
	public static List<Pair<Integer, Integer>> answerCount = new ArrayList<Pair<Integer, Integer>>();
	public static int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public static void setNumberOfQuestions(int numberOfQuestions) {
		NLPBean.numberOfQuestions = numberOfQuestions;
	}
	public static List<Pair<Integer, Integer>> getLimiters() {
		return limiters;
	}
	public static void setLimiters(List<Pair<Integer, Integer>> limiters) {
		NLPBean.limiters = limiters;
	}
	public static List<Pair<String, String>> getFinalStructure() {
		return finalStructure;
	}
	public static void setFinalStructure(List<Pair<String, String>> finalStructure) {
		NLPBean.finalStructure = finalStructure;
	}
	public static List<Pair<Integer, Integer>> getAnswerCount() {
		return answerCount;
	}
	public static void setAnswerCount(List<Pair<Integer, Integer>> answerCount) {
		NLPBean.answerCount = answerCount;
	}
	
}
