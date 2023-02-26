package com.ysh.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDecoder {

	public ArrayList<String> decode(String location) throws FileNotFoundException {
		File fle = new File(location);
		Scanner myRead = new Scanner(fle);
		
		ArrayList<String> file = new ArrayList<String>();
		while (myRead.hasNext()) {
			file.add(myRead.nextLine());
		}
		
		myRead.close();
		return file;
		
	}
}
