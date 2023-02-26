package NLP;

import java.util.*;

import opennlp.tools.tokenize.SimpleTokenizer;

public class Tokenizer {

	public List<ArrayList<String>> tokenize(String[] sentences) {
		List<ArrayList<String>> tokenizedSentences = new ArrayList<ArrayList<String>>();
		SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
		for (String sentence : sentences) {
			ArrayList<String> tokenAL = new ArrayList<String>();

			String tokens[] = tokenizer.tokenize(sentence);
			for (String token : tokens) {
				tokenAL.add(token);
			}
			tokenizedSentences.add(tokenAL);
		}
		return tokenizedSentences;

	}
}