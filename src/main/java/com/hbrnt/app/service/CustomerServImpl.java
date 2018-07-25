package com.hbrnt.app.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbrnt.dao.CustomerDAO;
import com.hbrnt.pojo.Address;
import com.hbrnt.pojo.Customer;

@Service
public class CustomerServImpl implements CustomerServ{
	static Scanner scan = new Scanner(System.in);
	
	@Autowired
	CustomerDAO customerDao;

	@Override
	public void getCustomers() {
		System.out.println("Enter Zip: ");
		String zip = scan.next();
		List<Customer> customers = customerDao.getCustomers(zip);
		System.out.println(customers);
	}

	@Override
	public void loadCustomer() {
		System.out.println("Enter Customer id: ");
		int id = scan.nextInt();
		Customer cust = customerDao.loadCustomer(id);
		System.out.println(cust);
	}

	@Override
	public void updateCustomer() {
		System.out.println("Enter Customer ID: ");
        int custId = scan.nextInt();
        Address address = new Address("1214", "San Jacinto", "Irving", "75063");
        Customer customer = new Customer("Mr.", "Vivek", "K", "B", "vivek@gmail.com", "IMCS", "ViVek", "Vivek B K",
				"nothing");   
        customer.setAddress(address);
        customer.setCustID(custId);
        System.out.println(customerDao.updateCustomer(customer));
	}

	@Override
	public void deleteCustomer() {
		System.out.println("Enter Customer ID: ");
		int custId = scan.nextInt();
    	System.out.println(customerDao.deleteCustomer(custId));
	}

	@Override
	public void addCustomer() {
		Customer customer = new Customer("Mr.", "Vivek", "K", "B", "vivek@gmail.com", "IMCS", "ViVek", "Vivek B K",
				"nothing");
		Address address = new Address("1214", "San Jacinto", "Irving", "75063");
		customer.setAddress(address);
		System.out.println(customerDao.addCustomer(customer));
	}
	
	@Override
	public void getMonthlySales() {
		System.out.println("Enter year: ");
		int year = scan.nextInt();
		Map<String, Double> result = customerDao.getMonthlySales(year);
		result.forEach((k,v) -> System.out.println("Month = "
                + k + ", Sales = " + v));
	}
	
	@Override
	public void getReport() {
		System.out.println("Enter Month: ");
		int month = scan.nextInt();
		customerDao.getReport(month).stream().forEach(System.out::println);
	}

}
