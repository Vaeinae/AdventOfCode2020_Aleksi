package d1;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileInputStream; //needed to read the file over and over again 

public class Task1Main {
  public static void main(String[] args) {
    try {
    	
    	File myObj1 = new File("C:\\Users\\aleks\\OneDrive\\Työpöytä\\Univaasa\\2_Lukuvuosi\\Olio-ohjelmointi\\eclipse-workspace\\adventofcode\\src\\d1\\input.txt");
    	File myObj2 = new File("C:\\Users\\aleks\\OneDrive\\Työpöytä\\Univaasa\\2_Lukuvuosi\\Olio-ohjelmointi\\eclipse-workspace\\adventofcode\\src\\d1\\input.txt");
    	Scanner myReader1 = new Scanner(myObj1); //reader for value 1
    	Scanner myReader2 = new Scanner(new FileInputStream(myObj2)); //reader for value 2
    	boolean gotAnswer = false; //stops the loop when answer is gotten, 
    							//otherwise gives answer 2 times in different order
    	
    	while (myReader1.hasNextLine() && gotAnswer == false) {
    		int num1 = Integer.parseInt(myReader1.nextLine());
    		 //takes a value to be compared in the second while loop
    		
    		while (myReader2.hasNextLine()) {
    			int num2 = Integer.parseInt(myReader2.nextLine());
    			
    			if(num1 != num2) { //only two different values can be summed
	    			if(num1 + num2 == 2020) {
	    				System.out.println("Answer: " + num1 + " and " + num2 
	    						+ ". Multiplication: " + num2*num1);
	    				gotAnswer = true;
	    			} //compares first value with all values from data
    			}
    		}
    		myReader2.close();
    		myReader2 = null;
    		//reset scanner
    		myReader2 = new Scanner(new FileInputStream(myObj2));
    	}
    	myReader1.close();
    }
    catch (FileNotFoundException e) {
      
    	System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
