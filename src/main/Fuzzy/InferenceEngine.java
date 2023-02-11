package Fuzzy;

import java.util.*;


public class InferenceEngine {

	int getSClass(float x) {
		if(x >= 0 && x<=0.2)
				return 0;
		else if(x>0.2 && x<=0.4)
				return 1;
		else if(x>0.4 && x<=0.6)
				return 2;
		else if(x>=0.6 && x<= 0.8)
				return 3;
		else
			return 4;		
	}
	
	int getCClass(float x) {
		if(x >= 0.6 && x<0.7)
				return 0;
		else if(x>=0.7 && x<0.8)
				return 1;
		else if(x>=0.8 && x<=0.9)
				return 2;
		else
			return 3;		
	}
	public List<String> getCorrectiveness(List<Float> CI) {
		List<String> remarks = new ArrayList<>();
		
		List <String> C = new ArrayList<>();
		C.add("The spelling error rate in the sentences are high");
		C.add("The spelling error rate in the sentences are moderate");
		C.add("The spelling error rate in the sentences are low");
		C.add("The are no spelling errors");
		

		for (float x : CI) {
			remarks.add(C.get(getCClass(x)));
		}
		return remarks;
	}

	public List<String> getSimilarity(List<Float> SI) {
		List<String> remarks = new ArrayList<>();
		
		List <String> S = new ArrayList<>();
		
		S.add("The answers did not match the expected answer");
		S.add("The answers somewhat matched the expected answer");
		S.add("The answers did partially the expected answer");
		S.add("The answers are very close to the  expected answer");
		S.add("The answers exactly matched the expected answer");		

		for (float x : SI) {
			remarks.add(S.get(getSClass(x)));
		}

		return remarks;
	}

}
