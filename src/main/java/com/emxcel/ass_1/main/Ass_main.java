package com.emxcel.ass_1.main;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.emxcel.ass_1.services.DataServiceFactory;

public class Ass_main {

	public static void main(String[] args) throws ClassNotFoundException, IOException, ParseException, SQLException {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your choice ");

		System.out.println("1.CSV File");
		System.out.println("2.JSON File");
		System.out.println("Enter Your Choice:");
		int choice = sc.nextInt();

		@SuppressWarnings("unused")
		DataServiceFactory dsf = new DataServiceFactory(choice);

	}

}
