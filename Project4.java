/** 
 * COP 3530: Project 2 – Stacks and Queues 
 * 
 *  This class reads a file path in from a user, parses the values, inserts each row of CSV file into a country object, the country object then is  inserted in
 *  a binary search tree based on country names
 *  menu options in main method allow user to print inorder, pre order, or post order;
 *  menu options in main method allow user to remove a country from the tree by input of country name 
 *  menu option in main method allow user to find a country by input of country name
 *  menu option in main method allow a user to insert a new country into tree by input of country name and GDPPC. Country position is based on comparision value from insert method
 *  menu option in main method allow a user to see lowest and highest countries based on input number of country requested by the user
 *  
 * @author Jared Henry
 * @version 11/16/2022
 */ 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project4 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Data Structures\nProject 2\nN01484167 Jared Henry");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file or path to file you wish to load:");
		String fileName = sc.next();
		System.out.println(fileName);
		Scanner inFile = null;
		
		BinarySearchTree Tree = new BinarySearchTree();

		try
		{
			 inFile = new Scanner(new File(fileName));
			 System.out.println("File Read");
			 //System.out.println("Enter 8 to view options:");
		}//end of try for file scanner
		
		catch (FileNotFoundException e)
		{
			
			System.out.println("\nCould not open the file!");
			System.exit(1);
		}//end catch for file error
		inFile.useDelimiter(",|\n");
		inFile.nextLine();
		while(inFile.hasNext())
		{
			String name = inFile.next();
			String capital = inFile.next();
			double population = Double.parseDouble(inFile.next());
			double gDP = Double.parseDouble(inFile.next());
			double cOVIDCases = Double.parseDouble(inFile.next());
			double cOVIDDeaths = Double.parseDouble(inFile.next());
			double area = Double.parseDouble(inFile.next());
			
			double GDPPC = gDP/population;
			double CFR = cOVIDDeaths/cOVIDCases;
			double CaseRate = (cOVIDCases/population)*100000;
			double DeathRate = cOVIDDeaths/(population/100000);
			double PopDensity = population/area;
			
			Country c = new Country(name, GDPPC);
			
			Tree.insertIt(c);
			
			
		}// end of while loop	
		
		int menuOption = 1;
		do {
			if(menuOption > 9 || menuOption < 1) {
				System.out.println("Invalid entry! Please enter number from the menu.");
			}
			
			try {
				System.out.println("\n1) Print tree in order."
						+ "\n2) Print tree preorder."
						+ "\n3) Print tree postorder."
						+ "\n4) Insert a country with name and GDP per capita."
						+ "\n5) Delete a country and its path for a given name."
						+ "\n6) Search and print a country and its path for a given name."
						+ "\n7) Print bottom countries regarding GDPPC."
						+ "\n8) Print top countries regarding GDPPC."
						+ "\nPlease enter your choice: ");

					menuOption = sc.nextInt();
						//menuOption = Integer.valueOf(sc.next());
			}//end try 
			catch (InputMismatchException e) {
				sc.nextLine();
				System.err.print("Try again! Please enter an integer value for menu option.\n");		
				menuOption = sc.nextInt();
			}//end of catch for string input
		
	
		
		if(menuOption == 1 ) {
			
		System.out.println("Inorder Traversal: \n");
		System.out.println("Name\t\t\t\t GDP Per Capita");
		System.out.println("----------------------------------------------"
				+ "--");
		Tree.inOrder();
		
		}//end menuOption 1
		
		if(menuOption == 2) {
			
			System.out.println("Preorder Traversal: \n");
			System.out.println("Name\t\t\t\t GDP Per Capita");
			System.out.println("----------------------------------------------"
					+ "--");
			Tree.preOrder();
			
		}//end menuOption 2
		
		if(menuOption == 3) {
			
			System.out.println("Inorder Traversal: \n");
			System.out.println("Name\t\t\t\t GDP Per Capita");
			System.out.println("----------------------------------------------"
					+ "--");
			Tree.postOrder();
			
		}//end menuOption 3
		
		if(menuOption == 4) {
			
		
			System.out.println("Enter country name:");
			String countryName = sc.next();
			System.out.println("Enter country GDP per capita: ");
			double userGDPPC = sc.nextDouble();
			
			Country c = new Country(countryName, userGDPPC);
			Tree.insertIt(c);
			System.out.println(countryName + " with GPD per capita of " + userGDPPC + " is inserted.");
			
			
		}//end menuOption 4
		
		if(menuOption == 5) {
			
		
		System.out.println("Enter the country you wish to delete:");
		String countryValue = sc.next();
		
		
		 boolean didDelete = Tree.delete(countryValue);
		 
		 if(didDelete) {
			 System.out.println("Deleted " + countryValue + '\n' );
			
		 }//end if statement
		 if(!didDelete) {
			 System.out.println("Could not delete " + countryValue +'\n');
		 }//end else statement
		 
			
			
		}//end menuOption 5
		
		if(menuOption == 6) {
			
			System.out.print("Enter country you wish to find: "); 
			String countrySearch = sc.next();
			Node found = Tree.find(countrySearch); 
			if(found != null) 

			{ 
			 
			System.out.printf("\n" + "%s ",found.iData.getName() + " is found with GDP per capita of ");
			System.out.printf("%.3f", found.iData.getGDPPC());
			System.out.println(".");
			System.out.print("\n"); 
			Tree.foundPrint(countrySearch);
			}//end if statement
			else 
				System.out.print("Could not find "); 
				System.out.print(countrySearch + '\n'); 

		}//end menuOption 6
		
		if(menuOption == 7) {
			
			Tree.lowestValue();
			
		}//end menuOption 7
		
		if(menuOption == 8) {
			
		}//end menuOption 8
		
		if(menuOption == 9 ) {
			
			System.out.println("You have exited the program! Thank you! ");
		}//end menuOption
		}
		while(menuOption != 9);
		
		//sc.close();
		
	}//end main method	
}//end class
