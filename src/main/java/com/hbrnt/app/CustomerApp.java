package com.hbrnt.app;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import com.hbrnt.app.service.CustomerServ;

@Configuration
@ComponentScan({ "com.hbrnt.app", "com.hbrnt.app.service", "com.hbrnt.dao", "com.hbrnt.pojo", "com.hbrnt.utl"})
public class CustomerApp {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		@SuppressWarnings("resource")
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				CustomerApp.class);
		CustomerServ customerServ = applicationContext.getBean(CustomerServ.class);

		System.out.println("Choose your operation: ");
		int option;

		do {
			System.out.println("\n 1. Add \n 2. DELETE \n 3. UPDATE \n 4. Load Customer "
					+ "\n 5. List Customers \n 6. Get Monthly Sales \n 7. Query Report \n 8. Exit");
			option = scan.nextInt();

			switch (option) {
			case 1:
				customerServ.addCustomer();
				break;

			case 2:
				customerServ.deleteCustomer();
				break;

			case 3:
				customerServ.updateCustomer();
				break;

			case 4:
				customerServ.loadCustomer();
				break;

			case 5:

				customerServ.getCustomers();
				break;

			case 6:
				customerServ.getMonthlySales();
				break;

			case 7:
				customerServ.getReport();
				break;

			default:
				System.exit(0);
			}
		} while (true);

	}

}
