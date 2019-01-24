package com.emxcel.ass_1.services;

public class DataServiceFactory {
	CSVDataService csv;
	JSONDataService json;

	public DataServiceFactory(int choice) {

		// TODO Auto-generated constructor stub
		switch (choice) {
		case 1:
			csv = new CSVDataService();
			csv.export();
			break;
		case 2:
			json = new JSONDataService();

			json.export();
			break;
		default:
			System.out.println("");

		}

	}

}
