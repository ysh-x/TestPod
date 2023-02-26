package NLP;

import java.util.ArrayList;
import java.util.List;
import org.glassfish.grizzly.utils.Pair;

public class NLPRead {

	@SuppressWarnings("static-access")
	public NLPRead(NLPBean NB) {
		int numberOfQuestions;
		List<Pair<Integer, Integer>> limiters = new ArrayList<Pair<Integer, Integer>>();
		List<Pair<String, String>> finalStructure = new ArrayList<Pair<String, String>>();
		List<Pair<Integer, Integer>> answerCount = new ArrayList<Pair<Integer, Integer>>();

		numberOfQuestions = NB.getNumberOfQuestions();
		limiters = NB.getLimiters();
		finalStructure = NB.getFinalStructure();
		answerCount = NB.getAnswerCount();

		System.out.println("Answer Information");
		System.out.println("The question set has " + numberOfQuestions + " answers");


		for (int i = 0; i < numberOfQuestions; i++) {
			System.out.println("\n\nAnswer " + (i + 1));
			System.out.println("------------------------\n\n");
			System.out.println();
			Pair<Integer, Integer> bounds = answerCount.get(i);
			for (int j = bounds.getFirst(); j < bounds.getSecond(); j++) {
				Pair<Integer, Integer> inbound = limiters.get(j);
				if (inbound.getFirst() == -1)
					continue;
				for (int k = inbound.getFirst(); k < inbound.getSecond(); k++) {
					Pair<String, String> ans = finalStructure.get(k);
					System.out.print("<" + ans.getFirst() + ">\t" + ans.getSecond() + "\n");
				}
				System.out.println("..............................");
			}
		}
	}
}
