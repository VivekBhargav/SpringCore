package com.hbrnt.app;

public class Test {
public static void main(String[] args) {
	Long l1 = new Long(101);
	Long l2 = l1;
	l1++;
	if(l1==l2) {
		System.out.println("True");
	}
	else
		System.out.println("false"+l1+l2);
}
}
