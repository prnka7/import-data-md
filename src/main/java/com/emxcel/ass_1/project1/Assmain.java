package com.emxcel.ass_1.project1;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Assmain {

	public static void main(String[] args) throws ClassNotFoundException, IOException, ParseException, SQLException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("1.CSV File");
		System.out.println("2.JSON File");
		System.out.println("Enter Your Choice:");
		int choice=sc.nextInt();
		
		Test T1=new Test();
		ForJSON F1=new ForJSON();
		
			switch(choice)
			{
			case 1:T1.Test1();
				break;
			case 2:F1.Json1();
				break;
			default: System.out.println("");
			}
		

	}

}
