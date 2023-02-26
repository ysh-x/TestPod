package NLP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.glassfish.grizzly.utils.Pair;

public class NLPFileGenerate {

	@SuppressWarnings("static-access")
	public NLPFileGenerate(NLPBean NB, int examID) throws IOException {
		
		int numberOfQuestions;
		List<Pair<Integer, Integer>> limiters = new ArrayList<>();
		List<Pair<String, String>> finalStructure = new ArrayList<>();
		List<Pair<Integer, Integer>> answerCount = new ArrayList<>();

		numberOfQuestions = NB.getNumberOfQuestions();
		limiters = NB.getLimiters();
		finalStructure = NB.getFinalStructure();
		answerCount = NB.getAnswerCount();


		String loc = "/home/ysh-mi/MajorProjects/TestPod/lib/files" + examID + ".txt";
		@SuppressWarnings("unused")
		File f0 = new File(loc);
		f0.createNewFile();
		
		FileWriter fw = new FileWriter(loc);
		
		String numberOfQuestionS = String.valueOf(numberOfQuestions);

		fw.write(numberOfQuestionS);
		fw.write("\nEOS");
		fw.write("\n");

		for (Pair<Integer, Integer> l : limiters) {
			String temp = (l.getFirst() + " " + l.getSecond().toString());
			fw.write(temp);
			fw.write("\n");
		}
		fw.write("EOS\n");

		for (Pair<Integer, Integer> a : answerCount) {
			String temp = (a.getFirst() + " " + a.getSecond().toString());
			fw.write(temp);
			fw.write("\n");
		}
		fw.write("EOS\n");

		for (Pair<String, String> l : finalStructure) {
			String temp = l.getFirst() + " " + l.getSecond() + "\n";
			fw.write(temp);
		}
		fw.write("EOS\n");
		fw.flush();
		fw.close();

	}
}
