package NLP;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.glassfish.grizzly.utils.Pair;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;

public class POSTag {

	public List<Pair<String,String>> POSTagger(List<ArrayList<String>> sentences) throws IOException {
		List<Pair<String,String>> finalStructure = new ArrayList<>();
		InputStream inStream = new FileInputStream("./lib/en-pos-maxent.bin");
		POSModel model = new POSModel(inStream);
		POSTaggerME tagger = new POSTaggerME(model);

		for (ArrayList<String> sentence : sentences) {
			String[] tokens = (String[]) sentence.toArray(new String[0]);
			String[] tags = tagger.tag(tokens);
			POSSample sample = new POSSample(tokens, tags);

			String[] tagsF = sample.getTags();
			String[] sentenceF = sample.getSentence();

			for (int i = 0; i < tagsF.length; i++) {
				finalStructure.add(new Pair<String, String>(sentenceF[i],tagsF[i]));
			}
		}
		
		return finalStructure;
	}
}
