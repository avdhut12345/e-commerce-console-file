package user_management;

import java.util.Scanner;

	public class UserManagementMain {
		
		private static String password;

		public static void userManagement() { //Entry Point => User defined method
			
			System.out.println("######### Welcome to User Management ######### ");
			
			Scanner sc = new Scanner(System.in);
			
			User user =  new User();
			
			boolean shallIKeepRunnningCode = true;
			
			while(shallIKeepRunnningCode) {
				
				System.out.println("  What would you like to do today ?");
				System.out.println("     1. Add User");
				System.out.println("     2. Update User");
				System.out.println("     3. Search User");
				System.out.println("     4. Delete User");
				System.out.println("     5. Print User");
				System.out.println("     6. Exit User");
				
				int option = sc.nextInt();
				
				switch (option) {
				case 1 :
					System.out.println("     1. Add User");
					System.out.println("     Enter first name : ");
					String firstName = sc.next();
					
					System.out.println("     Enter last name : ");
					String lastName = sc.next();
					
					System.out.println("     Enter gender : ");
					String gender = sc.next();
					
					System.out.println("     Enter age : ");
					int age = sc.nextInt();
					
					System.out.println("     Enter email : ");
					String email = sc.next();
					
					System.out.println("     Enter password : ");
					String confirmPassword  = sc.next();
					
					if(password.equals(confirmPassword)) { //password == confirmPassword => Will not work. Why ?? User
						user.password = password;
					}else {
						System.out.println("  Password and confirm passowrd does not match");
						System.out.println("    !!! User addition fail");
					}
					
					System.out.println("      ********** User added succesfully");
					user.printUser(); // Function Call
					
					break;
					
				case 2 :
					System.out.println("Update User operation not yet implemented");
					
					break;
					
				case 3 :
					System.out.println("Search User operation not yet implemented");
					break;
					
				case 4 :
					System.out.println("Delete User operation not yet implemented");
					break;
					
					
				case 6 :
					
					shallIKeepRunnningCode = false;
					System.out.println("Exiting the user application");
					
				
					break;
					
					default:
						System.out.println("Unknown Option");
				}
			}
		}
	}

