package NLP;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

/**
 * @author ysh
 * */

public class SentenceDetect {

	public String[] sentenceFormation(String paragraph) throws InvalidFormatException, IOException {

		// refer to model file "en-sent,bin", available at link
		// http://opennlp.sourceforge.net/models-1.5/
		InputStream is = new FileInputStream("/home/ysh-mi/MajorProjects/TestPod/lib/en-sent.bin");
		SentenceModel model = new SentenceModel(is);

		// load the model
		SentenceDetectorME sdetector = new SentenceDetectorME(model);

		// detect sentences in the paragraph
		String sentences[] = sdetector.sentDetect(paragraph);
		is.close();

		// print the sentences detected, to console
		for (int i = 0; i < sentences.length; i++) {
			sentences[i] = sentences[i].toLowerCase();
		}
		return sentences;
	}
}