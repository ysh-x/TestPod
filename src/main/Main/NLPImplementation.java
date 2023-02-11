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
		
		ArrayList<String> answers = new ArrayList<>();
		answers.add("An array is a data structure consisting of elements (values or variables), each identified by at least one array index or key. Depending on the language, array types may overlap (or be identified with) other data types that describe aggregates of values, such as lists and strings.");
		answers.add("Linked lists are data structures that hold data in nodes.");
		answers.add("Stack is a data structure which follows a particular order in which the operations are performed. The order may be LIFO(Last-In-First-Out) or FILO(First-In-Last-Out).");
		answers.add("A queue is a collection of items where the addition of new items happens at one end, called the “rear,” and the removal of existing items occurs at the other end, commonly called the “front.” As an element enters the queue it starts at the rear and makes its way toward the front, waiting until that time when it is the next element to be removed.");
		answers.add("Binary Tree is defined as a data structure. Since each element in a binary tree can have only 2 children, we typically name them the left and right child.");
		answers.add("A file is a location that stores information and data. Files are always stored inside a storage device using the name given to the file. Files keep data and information permanently or until deleted.");
		answers.add("A class is used to define the characteristics of an object, such as how they will respond to a message and what type of message the object will respond to. A superclass is the basis of the class being considered.");
		answers.add("Inheritance is the property that has been passed on from a superclass to a subclass.");
		answers.add("The primary components of most computer systems are the central processing unit, the memory and the input and output devices. The CPU is typically an arithmetic logic unit, control unit or both. The memory of a computer system refers to both the primary and secondary memory.");
		answers.add("A computer's chipset is what controls the communication between all computer components, including the RAM, CPU and storage. The chipset denotes which and how many USB devices and high-speed components a motherboard can support. Chipsets are often used to control peripherals like the mouse, monitor and keyboard.");
		answers.add("An operating system enables computer software to communicate with computer hardware. The operating system supports a computer's basic functions and allows the user to perform various computer tasks. Commonly used operating systems include Microsoft Windows, OSX and Linux.");
		answers.add("Primary memory is the main memory of a computer that can be accessed via the CPU. Semiconductor chips are the most commonly used technology for primary memory. The secondary memory is an external storage device that can be used to keep data and information permanently. Examples of secondary memory include floppy disks, hard drives and USB flash drives.");
		answers.add("A few of the latest and most commonly used computer processors include Intel Core i5, Intel Core i7, Intel Core i9, AMD Ryzen5 and AMD Ryzen7.");
		answers.add("A constructor is the method or methods used when creating an object of class. Parameterized and default constructors are the two different kinds of constructors used.");
		answers.add("An interface is a reference type in program java.");
		answers.add("DBMS is Data Base Management System, which consists of a collection of interrelated data and a set of programs to access those data. The collection of data is database. These are designed to manage large bodies of information.");
		answers.add("Physical,Logical");
		answers.add("The collection of information stored in the database at a particular moment is called instance. The overall design of the database is called the database schema.");
		answers.add("The entity relationship model is a collection of objects called entities and relationship among those entities. An entity is a thing or object in the real world entity.");
		answers.add("A collection of conceptual tools for describing data, data relationships, data semantics and consistency constraints for underlying the structure of a database is data model.");
		answers.add("An entity is represented by a set of attribute. Attribute are descriptive properties possessed by each member of an entity set.");
		answers.add("It is a process of salvaging data from damaged, failed, corrupted secondary storage media when it cannot accessed normally. Recovery may be required due to physical damage to the storage device or logical damage to the file system that prevents it from being mounted by the host operation system.");
		answers.add("A transaction is a collection of operations that performs a single logical function in a database application. Each transaction is a unit of both atomicity and consistency.");
		answers.add("It is a process of analyzing the given relation schemas based set of functional dependencies and primary key to achieve the properties ,minimizing redundancy.");
		answers.add("Lock is the most common used to implement the requirement is to allow a transaction to access a data item only if it is currently holding a lock on that item.");
		answers.add("Data warehouse is a subject-oriented, integrated, non-volatile, time-variant collection of data in support of management’s decisions. (OR) Data warehouse is a collection of decision support technologies, aimed at enabling the knowledge worker to make better and faster decisions.");

		int testID = 51211;
		int examID = 100;
		
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
		NLPFileGenerate N1 = new NLPFileGenerate(NB2,examID);
		
		
		System.out.println("Status: Decoding Faculty AnswerScript");
		NLPBean FB = new NLPBean();
		FileRead FR = new FileRead();
		FB = FR.FileDecode(testID);

		System.out.println("Status: Loading Answers to NLP Java Bean");
		NLPBean SB = new NLPBean();
		FileRead FR1 = new FileRead();
		SB = FR1.FileDecode(examID);
		
		System.out.println("Status: Generating Report....");	
		GenerateSI GS = new GenerateSI();
		ReportBean RB = new ReportBean();
		RB = GS.generate(testID, examID);
		
		GenerateReport GR = new GenerateReport(testID,RB,answers);
		System.out.println("Status: Report Generated for the testID:."+testID);
				
		
	}
}
