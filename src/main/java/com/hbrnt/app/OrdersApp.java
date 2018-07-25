package com.hbrnt.app;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import com.hbrnt.app.service.OrdersServ;
import com.hbrnt.dao.IOrdersDAO;

@Configuration
@ComponentScan({ "com.hbrnt.app", "com.hbrnt.app.service", "com.hbrnt.dao", "com.hbrnt.pojo", "com.hbrnt.utl"})
public class OrdersApp {
	static Scanner scan = new Scanner(System.in);
	
	@Autowired
	IOrdersDAO orderDao;

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(OrdersApp.class);
		OrdersServ ordersServ = context.getBean(OrdersServ.class);

		System.out.println("Choose your operation: ");
		int option;

		do {
			System.out.println("\n 1. CREATE \n 2. DELETE \n 3. UPDATE \n 4. Get Order " + "\n 5. Exit");
			option = scan.nextInt();

			switch (option) {
			case 1:
				ordersServ.createOrder();
				break;

			case 2:
				ordersServ.deleteOrder();
				break;

			case 3:
				ordersServ.updateOrder();
				break;

			case 4:
				ordersServ.loadOrder();
				break;
				default:
					System.exit(0);
			}

		} while (true);
	}
}
