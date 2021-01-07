package d1;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileInputStream; //used to reset file reading scanners

public class Task2Main {
  public static void main(String[] args) {
    try {
    	
    	File myObj1 = new File("C:\\Users\\aleks\\OneDrive\\Työpöytä\\Univaasa\\2_Lukuvuosi\\Olio-ohjelmointi\\eclipse-workspace\\adventofcode\\src\\d1\\input.txt");
    	File myObj2 = new File("C:\\Users\\aleks\\OneDrive\\Työpöytä\\Univaasa\\2_Lukuvuosi\\Olio-ohjelmointi\\eclipse-workspace\\adventofcode\\src\\d1\\input.txt");
    	File myObj3 = new File("C:\\Users\\aleks\\OneDrive\\Työpöytä\\Univaasa\\2_Lukuvuosi\\Olio-ohjelmointi\\eclipse-workspace\\adventofcode\\src\\d1\\input.txt");
    	Scanner myReader1 = new Scanner(myObj1); 						//reader for value 1
    	Scanner myReader2 = new Scanner(new FileInputStream(myObj2)); 	//reader for value 2
    	Scanner myReader3 = new Scanner(new FileInputStream(myObj3));	//reader for value 3
    	boolean gotAnswer = false; 										/*stops the loop when answer is gotten, 
    																	otherwise gives answer 2 times in different order*/
    	
    	while (myReader1.hasNextLine() && gotAnswer == false) {
    		int val1 = Integer.parseInt(myReader1.nextLine());				//takes first value to be compared in the second while loop
    		 
    		while (myReader2.hasNextLine()) {
    			int val2 = Integer.parseInt(myReader2.nextLine());			//takes second value to be compared in the third while loop
    			
    			if(val1 != val2) {		//only different values can be summed
    			
	    			while (myReader3.hasNextLine()) {
	    				int val3 = Integer.parseInt(myReader3.nextLine());	//takes third value
	        			
	    				if (val3 != val2 && val3 != val1) {		//only different values can be summed
	    	    			if(val1 + val2 + val3 == 2020) {	//prints answer when sum is 2020
	    	    				
	    	    				System.out.println("Answer: " + val1 + ", " + val2
	    	    									+ ", and " + val3 + ". Multiplication: "
	    	    									+ val1*val2*val3);
	    	    				gotAnswer = true;							//takes forever to process but works :D
	    	    			}
	    				}
	    			}
	    			myReader3.close();
					myReader3 = null;
					//reset scanner
					myReader3 = new Scanner(new FileInputStream(myObj3));
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
