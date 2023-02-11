package Main;

import java.io.IOException;
import java.util.ArrayList;
import NLP.NLPBean;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import NLP.NLPDriver;
import NLP.NLPFileGenerate;

public class Faculty {
	@SuppressWarnings("static-access")
	public static void main(String arg[]) throws InvalidFormatException, IOException {

		ArrayList<String> fac = new ArrayList<>();
		fac.add("An array is a data structure consisting of elements (values or variables), each identified by at least one array index or key. Depending on the language, array types may overlap (or be identified with) other data types that describe aggregates of values, such as lists and strings.");
		fac.add("Linked lists are data structures that hold data in individual objects called nodes. These nodes hold both the data and a reference to the node in the list. Linked lists are often used because of their efficient insertion and deletion.");
		fac.add("Stack is a data structure which follows a particular order in which the operations are performed. The order may be LIFO(Last-In-First-Out) or FILO(First-In-Last-Out).");
		fac.add("A queue is a collection of items where the addition of new items happens at one end, called the “rear,” and the removal of existing items occurs at the other end, commonly called the “front.” As an element enters the queue it starts at the rear and makes its way toward the front, waiting until that time when it is the next element to be removed.");
		fac.add("Binary Tree is defined as a data structure. Since each element in a binary tree can have only 2 children, we typically name them the left and right child.");
		fac.add("A file is a location that stores information and data. Files are always stored inside a storage device using the name given to the file. Files keep data and information permanently or until deleted.");
		fac.add("A class is used to define the characteristics of an object, such as how they will respond to a message and what type of message the object will respond to. A superclass is the basis of the class being considered.");
		fac.add("Inheritance is the property that has been passed on from a superclass to a subclass.");
		fac.add("The primary components of most computer systems are the central processing unit, the memory and the input and output devices. The CPU is typically an arithmetic logic unit, control unit or both. The memory of a computer system refers to both the primary and secondary memory.");
		fac.add("A computer's chipset is what controls the communication between all computer components, including the RAM, CPU and storage. The chipset denotes which and how many USB devices and high-speed components a motherboard can support. Chipsets are often used to control peripherals like the mouse, monitor and keyboard.");
		fac.add("An operating system enables computer software to communicate with computer hardware. The operating system supports a computer's basic functions and allows the user to perform various computer tasks. Commonly used operating systems include Microsoft Windows, OSX and Linux.");
		fac.add("Primary memory is the main memory of a computer that can be accessed via the CPU. Semiconductor chips are the most commonly used technology for primary memory. The secondary memory is an external storage device that can be used to keep data and information permanently. Examples of secondary memory include floppy disks, hard drives and USB flash drives.");
		fac.add("A few of the latest and most commonly used computer processors include Intel Core i5, Intel Core i7, Intel Core i9, AMD Ryzen5 and AMD Ryzen7.");
		fac.add("A constructor is the method or methods used when creating an object of class. Parameterized and default constructors are the two different kinds of constructors used.");
		fac.add("An interface is a reference type in program java.");
		fac.add("DBMS is Data Base Management System, which consists of a collection of interrelated data and a set of programs to access those data. The collection of data is database. These are designed to manage large bodies of information.");
		fac.add("Physical,Logical,View");
		fac.add("The collection of information stored in the database at a particular moment is called instance. The overall design of the database is called the database schema.");
		fac.add("The entity relationship model is a collection of objects called entities and relationship among those entities. An entity is a thing or object in the real world entity.");
		fac.add("A collection of conceptual tools for describing data, data relationships, data semantics and consistency constraints for underlying the structure of a database is data model.");
		fac.add("An entity is represented by a set of attribute. Attribute are descriptive properties possessed by each member of an entity set.");
		fac.add("It is a process of salvaging data from damaged, failed, corrupted secondary storage media when it cannot accessed normally. Recovery may be required due to physical damage to the storage device or logical damage to the file system that prevents it from being mounted by the host operation system.");
		fac.add("A transaction is a collection of operations that performs a single logical function in a database application. Each transaction is a unit of both atomicity and consistency.");
		fac.add("It is a process of analyzing the given relation schemas based set of functional dependencies and primary key to achieve the properties ,minimizing redundancy.");
		fac.add("Lock is the most common used to implement the requirement is to allow a transaction to access a data item only if it is currently holding a lock on that item.");
		fac.add("Data warehouse is a subject-oriented, integrated, non-volatile, time-variant collection of data in support of management’s decisions. (OR) Data warehouse is a collection of decision support technologies, aimed at enabling the knowledge worker to make better and faster decisions.");

		int testID = 51211;
		
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
		NLPFileGenerate N1 = new NLPFileGenerate(NB1,testID);

		System.out.println("Status: Answer Script Generated for the ID:."+testID);

	}
}
