package product_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.DBUtils;

public class ProductManagementMain {
	
	public void prodcutManagement() throws IOException, SQLException { // Entry point => User defined method

		System.out.println("######### Welcome to Product Management ######### ");

		Scanner sc = new Scanner(System.in);
		
		boolean shallIKeepRunnningCode = true;
		
		Product product = new Product(); // Object

		while (shallIKeepRunnningCode) {

			System.out.println("  What would you like to do today ?");
			System.out.println("     1. Add Product");
			System.out.println("     2. Update Product");
			System.out.println("     3. Search Product");
			System.out.println("     4. Delete Product");
			System.out.println("     5. Print Product");
			System.out.println("     6. Exit Product");

			int option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.println("       Add Product");
				System.out.println("         Enter your product Name ");
				product.name = sc.next();

				System.out.println("         Enter your product Quantity ");
				product.quantity = sc.nextInt();

				System.out.println("         Enter your product price ");
				product.price = sc.next();
				
				System.out.println("    ***** Product added succefully");
			
				String query = "insert into product (name, quantity, price) values ('" + product.name + "', " + product.quantity + ", '" + product.price + "')";
				
				DBUtils.executeQuery(query);
//				productListFromFile.add(product.name + "," + product.quantity + product.price);
				break;
				
			case 2:
				
				System.out.println("          Update Product :");
				System.out.println("              Enter Product name to update : ");
			
				Scanner scToUpdate = new Scanner(System.in);
				String productNameToUpdate = scToUpdate.next();
				
				
				String selectQuery = "Select count(*) from product where name = '"+productNameToUpdate+"'";
				
				ResultSet rs = DBUtils.executeSelectQuery(selectQuery);
				rs.next();
				int countOfProduct = rs.getInt(0);
				
					if(countOfProduct==1) {
						scToUpdate = new Scanner(System.in);
						
						System.out.println("Update product name");
						String updatedProductName = scToUpdate.next();
						
						System.out.println("Update product quantity");
						int updatedQty = scToUpdate.nextInt();
						
						System.out.println("Update product price");
						String updatedProductPrice = scToUpdate.next();
						
						String productUpdateQuery = "update product set name = '"+updatedProductName+"',quantity = "+updatedQty+", price = '"+updatedProductPrice+"'";
						
					}else {
						System.out.println("Prodcuct not found");
					}
				
				break;
				
			case 3:
				System.out.println("          Search Product :");
				System.out.println("              Enter Product name to search : ");
				
				Scanner scToSerach = new Scanner(System.in);
				String productNameToSearch = scToSerach.next();
				
				String selectQueryForSearch = "Select * from product where name = '"+productNameToSearch+"'";
				ResultSet SearchResultSet = DBUtils.executeSelectQuery(selectQueryForSearch);
				
				while(SearchResultSet.next()) 
				{
					System.out.println(SearchResultSet.getString(1)+" "+SearchResultSet.getString(2)+" "+SearchResultSet.getString(3));
				}
				
				break;
				
			case 4:
				
				System.out.println("          Delete Product :");
				System.out.println("              Enter Product name to delete : ");
			
				Scanner scToDelete = new Scanner(System.in);
				String productNameToDelete = scToDelete.next();
					
				String deleteQuery = "delete from product where name = '"+productNameToDelete+"'";
				DBUtils.executeQuery(deleteQuery);
				
				break;
				
			case 5:	
				String selectAllQueryForSearch = "Select * from product";
				ResultSet printResultSet = DBUtils.executeSelectQuery(selectAllQueryForSearch);
				
				while(printResultSet.next()) 
				{
					System.out.println(printResultSet.getString(1)+" "+printResultSet.getString(2)+" "+printResultSet.getString(3));
				}
				
				break;	
				
			case 6:
				System.out.println("Exiting the product management...");
				shallIKeepRunnningCode = false;
				break;
				
			default:
				System.out.println("Unknown Option");
			}
		}
	}
}