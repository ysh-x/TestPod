
package Main;

import java.io.IOException;
import java.util.ArrayList;
import NLP.FileRead;
import NLP.NLPBean;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Core.GenerateReport;
import Core.GenerateSI;
import Core.ReportBean;
import NLP.NLPDriver;
import NLP.NLPFileGenerate;

public class NLPImplementation {

	@SuppressWarnings({ "static-access", "unused" })
	public static void main(String arg[]) throws InvalidFormatException, IOException {

		ArrayList<String> answers = new ArrayList<String>();
		answers.add("label of class in the program. Keywords are predefined reserved words, which possess special meaning.");

		answers.add("Python comes with some built-in objects. Some are used so often that Python has a quick way to make these objects called literals. The literals include the string, Unicode string, tuple, dictionary.");

		answers.add("Three Types of Sequences are supported in python. They are Strig, Tuple.");

		answers.add("An identifer must start with a letter or underscore followed by any letters. No reserved word should be used. No special character (Other than underscore) should be included in the identifier.");

		answers.add("A statement is an instruction that the interprter can execute. An expression is a combination of values variables operators and calls to functions.");

		answers.add("Tokens are a unit of the program. There are following tokens in Python. Keywords, Identifers, Punctuators.");

		answers.add("Operators are those symbols used with operands which tells compiler which operation is to be done on operands.");

		answers.add("A group of statements is part of another statement of function.");

		answers.add("Python uses indentation to create blocks of code. Statements at same indentation level are part of same block.");

		answers.add("Single-line string and multi string.");

		int testID = 51212;
		int examID = 90;

		System.out.println("oOoOOoOOo                         OooOOo.            o");
		System.out.println("    o                             O     `O           O");
		System.out.println("    o                   O         o      O           o");
		System.out.println("    O                  oOo        O     .o           o");
		System.out.println("    o     .oOo. .oOo    o         oOooOO'  .oOo. .oOoO");
		System.out.println("    O     OooO' `Ooo.   O         o        O   o o   O");
		System.out.println("    O     O         O   o         O        o   O O   o");
		System.out.println("    o'    `OoO' `OoO'   `oO       o'       `OoO' `OoO'o");
		System.out.println("____________________________________________________________");
		System.out.println("Version 1.0\n\n");

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

		System.out.println("Status: Generating Report....");
		GenerateSI GS = new GenerateSI();
		ReportBean RB = new ReportBean();
		RB = GS.generate(testID, examID);

		GenerateReport GR = new GenerateReport();
		GR.generateReport(examID, RB, answers);
		System.out.println("Status: Report Generated for the testID:." + examID);

	}
}
