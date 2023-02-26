package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import NLP.NLPBean;

import NLP.NLPDriver;
import NLP.NLPFileGenerate;

public class Faculty {
	@SuppressWarnings("static-access")
	public static void main(String arg[]) throws IllegalFormatException, InvalidFormatException, IOException {

		ArrayList<String> fac = new ArrayList<String>();
		fac.add("Keywords are predefined reserved words, which possess special meaning. An identifier is a unique name given to a particular variable, function or label of class in the program.");

		fac.add("Python comes with some built-in objects. Some are used so often that Python has a quick way to make these objects called literals. The literals include the string, Unicode string, integer, float, long, list, tuple, dictionary.");

		fac.add("Three Types of Sequences are supported in python. They are String, List, Tuple.");

		fac.add("An identifier must start with a letter or underscore followed by any number of digits and letters. No reserved word should be used. No special character (Other than underscore) should be included in the identifier.");

		fac.add("A statement is an instruction that the Python interpreter can execute. An expression is a combination of values variables operators and calls to functions.");

		fac.add("Tokens are the smallest unit of the program. There are following tokens in Python. Keywords, Identifiers, Literals, Operators, Punctuators.");

		fac.add("Operators are those symbols used with operands which tells compiler which operation is to be done on operands. Operators are tokens that trigger some computation when applied to variables and other objects in an expression. They are Unary and Binary.");

		fac.add("A group of statements is part of another statement of function.  Such a group of one or more statements is called block or code-block or suit in python.");

		fac.add("Python uses indentation to create blocks of code. Statements at same indentation level are part of same block.");

		fac.add("Python supports two types. They are Single-line string and Multi-line string.");

		int testID = 51212;

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

		System.out.println("Status: Creating NLP Java Bean");
		NLPDriver NLPD1 = new NLPDriver(fac);
		NLPBean NB1 = new NLPBean();

		System.out.println("Status: Generating NLP <Key,Value> Based Structure");
		NB1 = NLPD1.generateSkeleton();

		System.out.println("Status: Generating file...");
		@SuppressWarnings("unused")
		NLPFileGenerate N1 = new NLPFileGenerate(NB1, testID);

		System.out.println("Status: Answer Script Generated for the ID:." + testID);

	}
}
