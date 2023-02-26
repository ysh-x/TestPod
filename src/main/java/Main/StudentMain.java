package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import NLP.FileRead;
import NLP.NLPBean;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Core.GenerateReport;
import Core.GenerateSI;
import Core.ReportBean;
import NLP.NLPDriver;
import NLP.NLPFileGenerate;

public class StudentMain {

	@SuppressWarnings({ "static-access", "unused" })
	public ReportBean studentMain(ArrayList<String> answers, int testID, int examID)
			throws InvalidFormatException, IOException {

		System.out.println("Status: Loading Answers...");
		NLPDriver NLPD2 = new NLPDriver(answers);

		System.out.println("Status: Creating NLP Java Bean");
		NLPBean NB2 = new NLPBean();

		System.out.println("Status: Generating NLP <Key,Value> Based Structure");
		NB2 = NLPD2.generateSkeleton();

		System.out.println("Status: Generating file...");
		NLPFileGenerate N1 = new NLPFileGenerate(NB2, examID);

		System.out.println("Status: Decoding Faculty AnswerScript");
		NLPBean FB = new NLPBean();
		FileRead FR = new FileRead();
		FB = FR.FileDecode(testID);

		System.out.println("Status: Loading Answers to NLP Java Bean");
		NLPBean SB = new NLPBean();
		FileRead FR1 = new FileRead();
		SB = FR1.FileDecode(testID);
		
		FB.getFinalStructure().toString();
		SB.getFinalStructure().toString();
		
		System.out.println("Status: Generating Report....");
		GenerateSI GS = new GenerateSI();
		ReportBean RB = new ReportBean();
		RB = GS.generate(testID, examID);

		GenerateReport GR = new GenerateReport();
		List<String> remarks = GR.generateReport(examID, RB, answers);
		RB.setRemarks(remarks);
		System.out.println("Status: Report Generated for the testID:." + testID);
		return RB;

	}
}
