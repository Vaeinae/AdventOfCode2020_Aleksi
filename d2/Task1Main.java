package d2;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Task1Main {

	public static void main(String[] args) {
		try {
			File obj = new File("C:\\Users\\aleks\\OneDrive\\Työpöytä\\Univaasa\\2_Lukuvuosi\\Olio-ohjelmointi\\eclipse-workspace\\adventofcode\\src\\d2\\input.txt");
	      
			Scanner reader = new Scanner(obj);
			int pwCount = 0;	//password count
			
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				
				int min = Integer.parseInt(data.substring(0, data.indexOf("-")));
				int max = Integer.parseInt(data.substring(data.indexOf("-")+1, data.indexOf(" ")));
				//above are the given minimum and maximum values in each password
				
				char testChar = data.charAt(data.indexOf(data.substring(data.indexOf(" ")+1, data.indexOf(":"))));
				//character that gets checked in the password
				
				String password = data.substring(data.indexOf(":")+2);
				//a password
				
				int charCount = 0;				
				//counter for specific characters in pw
				
				for (int i = 0; i < password.length(); i++) {
				    if (password.charAt(i) == testChar) {
				        charCount++;	//counts characters
				    }
				}
				
				if(charCount >= min && charCount <= max) {
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
