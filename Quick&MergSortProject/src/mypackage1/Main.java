package mypackage1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*This class's job is to
 * 	(0) Quit
 *  (1)	Sort by County in Reverse Alphabetical Order
	(3)	Sort by 2015 Population 
	(5)	Sort by 2016 Population 
	(7)	Sort by 2017 Population
	(9)	Sort by 2018 Population
	(11)Sort by 2019 Population
	(13)Find information About County Via County Name
	(100)Display contents of file
*/
public class Main {
	/*
	 * This method reads the a csv file 
	 * Creates an array that holds the value of each category
	 * Contains the user options which are organized via Switch cases
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nElements = 67;
		County[] countyArray = new County[nElements];
		
		//county variables initialized
		String countyName = null;
		String population2015 = null;
		String population2016 = null;
		String population2017 = null;
		String population2018 = null;
		String population2019 = null;
		
		String countyFile = "Counties.csv";
		
		/*his class is used for creation of files and directories, 
		 *file searching, file deletion, etc. The File object represents 
		 *the actual file/directory on the disk.
		 *
		 *The File class is used to create objects that provide access 
		 *to the files and directories of a local file system.
		 **/
		File fileObject = new File(countyFile); 
		
		try {
			
			Scanner input = new Scanner(fileObject);
			input.useDelimiter(",|\n");
			input.nextLine();
			input.nextLine();
			System.out.println();
			
			for(int i = 0; input.hasNext(); i++) {
				countyName = input.next();
				population2015 = input.next();
				population2016 = input.next();
				population2017 = input.next();
				population2018 = input.next();
				population2019 = input.next();
				countyArray[i] = new County(countyName,population2015,population2016,population2017,population2018,population2019);
			}
			input.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error occured while getting file");
		}
		
		Scanner fileNameEntered = new Scanner(System.in);
		System.out.print("Please enter the file name with extension (example myfile.csv or file1.txt): ");
		String userFileName = fileNameEntered.next();
		System.out.println();
		
		if(userFileName.equals(countyFile) || userFileName.equals(countyFile.toLowerCase())  ) 
		{
			boolean endProgram = false;
			
			while(endProgram != true) {
				showChoices();
				System.out.println();
				endProgram = chooseUserChoices(countyArray);
			}
		}
		else {
			System.out.println("File name does not match any files please check spelling and remember to add extention");
		}
	}
	
	public static void showChoices() {
		System.out.println("Please choose an option");
		System.out.println("(0)	Quit");
		System.out.println("(1)	Sort by County in Reverse Alphabetical Order");
		System.out.println("(2)	Sort by 2015 Population");
		System.out.println("(3)	Sort by 2016 Population");
		System.out.println("(4)	Sort by 2018 Population");
		System.out.println("(5)	Sort by 2019 Population");
		System.out.println("(6)	Find information About County Via County Name");
		System.out.println("(10)	Display contents of file");
		System.out.println("(100)	Total Florida population in 2019");
	}
	
	public static boolean chooseUserChoices(County[] countyArray) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please make a selection");
		String userDecision = input.next();
		System.out.println();
		
		switch(userDecision) 
		{
		case "0":
			System.out.println("Program ended. Thank you");
			return true;
		case "1":
			System.out.println("Counties Sorted in Alphabetical Order");
			break;
		case "2":
			System.out.println("Counties Sorted by 2015 Population");
			break;
		case "3":
			System.out.println("Counties Sorted by 2016 Population");
			break;
		case "4":
			System.out.println("Counties Sorted by 2017 Population");
			break;
		case "5":
			System.out.println("Counties Sorted by 2018 Population");
			break;
		case "6":
			System.out.println("Counties Sorted by 2019 Population");
			break;
		case "10":
			System.out.println("List of Counties displayed");
			displayCountryInfo(countyArray);
			break;
		default:
			System.out.println("Incorrect information entered");
			}
		return false;
	}

	public static void displayCountryInfo(County[] countyArray) {
		System.out.printf("%-35s%-35s%-35s%-35s%-35s%-35s", "Country Name","Population 2015", "Population 2016", "Population 2017", "Population 2018", "Population 2019");
		System.out.println();
		
		for(int i = 0; i < 200; i++) {
			System.out.print("-");
		}
		
		System.out.println();
		
		for(int i = 0; i < 66; i++) {
			System.out.printf("%-35s%-35s%-35s%-35s%-35s%-35s",countyArray[i].getCountyName(), countyArray[i].getPopulation2015(), 
					countyArray[i].getPopulation2016(), countyArray[i].getPopulation2017(),
					countyArray[i].getPopulation2018(), countyArray[i].getPopulation2019());
					System.out.println();
		}
		
		int sumPopulation2019 = 0;
		for(int i = 0; i < 66; i++) {
			sumPopulation2019 = sumPopulation2019 + Integer.parseInt(countyArray[i].getPopulation2018());
		}
		System.out.println();
		System.out.println(" As of 2018 the Florida population is: " + sumPopulation2019);
		System.out.println();
	}
	
}

