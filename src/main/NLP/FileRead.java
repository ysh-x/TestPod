package NLP;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.glassfish.grizzly.utils.Pair;

public class FileRead {

	@SuppressWarnings("static-access")
	public NLPBean FileDecode(Integer location) throws IOException {
		@SuppressWarnings("unused")
		int numberOfQuestions;
		List<Pair<Integer, Integer>> limiters = new ArrayList<>();
		List<Pair<String, String>> finalStructure = new ArrayList<>();
		List<Pair<Integer, Integer>> answerCount = new ArrayList<>();

		String Location = "./lib/files/" + location.toString() + ".txt";
		File fle = new File(Location);
		Scanner myRead = new Scanner(fle);

		ArrayList<String> file = new ArrayList<>();
		while (myRead.hasNext()) {
			file.add(myRead.nextLine());
		}

		numberOfQuestions = Integer.parseInt(file.get(0));
		List<Integer> sizes = new ArrayList<>();
		for (int i = 1; i < file.size(); i++) {
			if (file.get(i).equals("EOS")) {
				sizes.add(i+1);
			}
		}
		
		for(int i = sizes.get(0); i < sizes.get(1)-1; i++) {
			String[] temp = file.get(i).split(" ");
			Pair<Integer,Integer> tempPair  = new Pair<Integer,Integer>(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
			limiters.add(tempPair);
		}
		for(int i = sizes.get(1); i < sizes.get(2)-1; i++) {
			String[] temp = file.get(i).split(" ");
			Pair<Integer,Integer> tempPair  = new Pair<Integer,Integer>(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
			answerCount.add(tempPair);
		}
		
		for(int i = sizes.get(2); i < sizes.get(3)-1; i++) {
			String[] temp = file.get(i).split(" ");
			Pair<String,String> tempPair  = new Pair<String,String>((temp[0]),(temp[1]));
			finalStructure.add(tempPair);
		}

		NLPBean NLPB = new NLPBean(); 
		NLPB.setAnswerCount(answerCount);
		NLPB.setLimiters(limiters);
		NLPB.setAnswerCount(answerCount);
		NLPB.setFinalStructure(finalStructure);
		
		myRead.close();
		return NLPB;

	}
}
