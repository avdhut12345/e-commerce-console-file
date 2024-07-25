package ecommerse;

import java.io.IOException;
import java.util.*;

import product_management.ProductManagementMain;
import user_management.UserManagementMain;

public class ApplicationMain {
	
	public static void main(String[] args) throws IOException { //Entry point => User defined method

		System.out.println("######### Welcome to Ecommerse ######### ");
		
		

		Scanner sc = new Scanner(System.in); //Constructor | in => it is a static variable because it does not create any object

		boolean shallIKeepRunnningCode = true;
		
		while (shallIKeepRunnningCode) {
			System.out.println("  What would you like to do today ?");
			System.out.println("     1. Product Management");
			System.out.println("     2. User Management");
			System.out.println("     3. Exit");
            int option = sc.nextInt();
            
            System.out.println(option);

			switch (option) {
			case 1:
				ProductManagementMain pm = new ProductManagementMain();
				pm.prodcutManagement();// Static direct class Method call
				break;
			case 2:
				UserManagementMain.userManagement(); // Method call
				break;
				
			case 3:
				System.out.println("Exiting the application...");
				shallIKeepRunnningCode = false;
				break;
			default:
				System.out.println("Unknown Option");
			}
		}
	}
}

