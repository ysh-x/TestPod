package Main;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import NLP.NLPBean;
import NLP.NLPDriver;
import NLP.NLPFileGenerate;

public class FacultyMain {
	
	String loc;
	@SuppressWarnings("static-access")
	public FacultyMain(ArrayList<String> fac, int testID) throws InvalidFormatException, IOException {
		NLPDriver NLPD1 = new NLPDriver(fac);
		NLPBean NB1 = new NLPBean();

		System.out.println("Status: Generating NLP <Key,Value> Based Structure");
		NB1 = NLPD1.generateSkeleton();		

		System.out.println("Status: Generating file...");		
		@SuppressWarnings("unused")
		NLPFileGenerate N1 = new NLPFileGenerate(NB1,testID);
		loc = N1.getFileLocation();
		System.out.println("Status: Answer Script Generated for the ID:."+testID);
	}
	
	public String getFileLocation() {
		return loc;
	}
}
