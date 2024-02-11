package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.*;
import entities.enums.*;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("Enter Client Data:");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("E-mail: ");
		String email = sc.nextLine();
		System.out.println("Birth Date (DD/MM/YYY): ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = sdf.parse(sc.nextLine());
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter Order data:");
		System.out.println("Status: ");
		String status = sc.nextLine();

		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		
		
		System.out.println();
		System.out.println("How many items to this order?");
		int n = sc.nextInt();
	
		
		for (int i = 0 ; i < n ; i++) {
			System.out.println("Enter #" + (i+1) + " item  data:");
			System.out.println("Product Name: ");
			String productName = sc.next();
			
			System.out.println("Product Price: ");
			double price = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			Product product = new Product(productName, price);
			OrderItem orderItem = new OrderItem (quantity, price, product);
			order.addItem(orderItem);
			
			System.out.println(orderItem);
		}
		System.out.println();
		
		System.out.println(order);
		
		
		
		sc.close();

	}
	
	
}
