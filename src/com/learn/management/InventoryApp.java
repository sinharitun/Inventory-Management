package com.learn.management;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class InventoryApp {
	
	private static int id;
	private static String pName;
	private static int quantity;
	private static double price;

	public static void main(String[] args) {
		
		try(Scanner scan=new Scanner(System.in)){
			
			System.out.println("-------- WELCOME TO INVENTORY MANAGEMENT SYSTEM --------\n");
			
			String conOrNot="No";
			
			ProductDAO productObject = new ProductDAO();
			
			do {
				
				System.out.println("------------------------ MENU ------------------------");
				
				System.out.println("1. Insert product details.");
				System.out.println("2. Get all product details.");
				System.out.println("3. Update the quantity of product using id.");
				System.out.println("4. Delete product detail using id./n");
				System.out.println("Choose an option form the above (Ex: 1 or ...");
				
				int option=scan.nextInt();
				scan.nextLine();
				
				switch(option) {
				case 1:
					
					System.out.println("Enter Product Name: ");
					pName=scan.nextLine();
					System.out.println("Enter Quantity: ");
					quantity = scan.nextInt();
					System.out.println("Enter Price: ");
					price=scan.nextDouble();
					
					Product product=new Product(pName, quantity, price);
					
					try {
						productObject.addProduct(product);
					} catch (SQLException e) {
						System.err.println("Issue Occured during insertion"+e.getMessage());
					}
					
					break;
				
				case 2:
					
					System.out.println("---------------------------------------------------------------");
					System.out.println("| id  | Product Name           | Quantity        | Price      |");
					System.out.println("---------------------------------------------------------------");
					
					try {
						List<Product> records=productObject.getAllData();
						for(Product data : records) {
							System.out.printf("| %-3d | %-22s | %-15d | %-10.2f |\n",data.getId(),data.getProductName(),data.getQuantity(),data.getPrice());
						}
						System.out.println("---------------------------------------------------------------");
					} catch (SQLException e) {
						System.err.println("Issued occured during record fetching.");
					}
					break;
					
				case 3:
					
					System.out.println("Enter id: ");
					id=scan.nextInt();
					System.out.println("Enter updated Quantity: ");
					quantity = scan.nextInt();
					
					try {
						productObject.updateProductQuantity(id, quantity);
					} catch (SQLException e) {
						System.err.println("Issued occured while updating record.");
					}
					break;
					
				case 4:
					
					System.out.println("Enter id: ");
					id=scan.nextInt();
					
					try {
						productObject.deleteProduct(id);
					} catch (SQLException e) {
						System.err.println("Issued occured while deleting record.");
					}
					break;
					
				default:
					System.err.println("Choose a correct option between 1 to 4");
				}
				
				System.out.println("Want to continue or not(Yes or No)");
				conOrNot=scan.next();
				
			}while(conOrNot.equalsIgnoreCase("Yes"));
		}
		catch(Exception e) {
			System.err.println("Somthing happend in main method");
		}

	}

}
