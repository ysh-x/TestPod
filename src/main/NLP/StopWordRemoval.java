package NLP;

import java.util.*;
import java.io.*;

public class StopWordRemoval {
		
	public List<ArrayList<String>> removeStopWords(List<ArrayList<String>> sentences) throws IOException {
		Set<String> stopWords = new HashSet<String>();
		File file = new File("./lib/assets/StopWords.txt");
		FileReader fRead = new FileReader(file);
		BufferedReader bRead = new BufferedReader(fRead);
		String line;

		while ((line = bRead.readLine()) != null) {
			stopWords.add(line);
		}
		fRead.close();

		List<ArrayList<String>> newSentences = new ArrayList<>();

		for (ArrayList<String> sentence : sentences) {
			ArrayList<String> newSentence = new ArrayList<>();

			for (String token : sentence) {
				if (token.matches("^[a-zA-Z0-9]+$") && !(stopWords.contains(token))) {
					newSentence.add(token);
				}
			}
			newSentences.add(newSentence);
		}
		return newSentences;
	}
}
