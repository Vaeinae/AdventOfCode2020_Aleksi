package d2;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Task2Main {

	public static void main(String[] args) {
		try {
			File obj = new File("C:\\Users\\aleks\\OneDrive\\Työpöytä\\Univaasa\\2_Lukuvuosi\\Olio-ohjelmointi\\eclipse-workspace\\adventofcode\\src\\d2\\input.txt");
	      
			Scanner reader = new Scanner(obj);
			int pwCount = 0;	//password count
			
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				
				int pos1 = Integer.parseInt(data.substring(0, data.indexOf("-"))) - 1;	// minus one(1) because if the given value is 1, it turns to 0 which is correct indexing.
				int pos2 = Integer.parseInt(data.substring(data.indexOf("-")+1, data.indexOf(" "))) - 1;	//also here
				//above are the given character positions in each password
				
				char testChar = data.charAt(data.indexOf(data.substring(data.indexOf(" ")+1, data.indexOf(":"))));
				//character that gets checked in the password
				
				String password = data.substring(data.indexOf(":")+2);
				//a password
				
				if(testChar == password.charAt(pos1) ^ testChar == password.charAt(pos2)) {	// ^ is a xor gate
					pwCount++;	//counts valid passwords
				}			
				
	      	}
			System.out.println(pwCount);	//prints valid password count
			reader.close();
			
		      
			} catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
		    }

	}

}
