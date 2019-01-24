package com.emxcel.ass_1.services;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.emxcel.ass_1.connection.Database_Connection;
import com.emxcel.ass_1.entity.Employment;
import com.emxcel.ass_1.entity.Person;
import com.opencsv.CSVReader;


public class CSVDataService  implements DataService {
	//public static void Ass_main(String[] args) throws ClassNotFoundException, SQLException, IOException, ParseException {
	@Override
	public void export() {	
		try {
		Database_Connection dbcon=Database_Connection.getInstance();
		CSVReader csvReader=new CSVReader(new FileReader("C:\\Users\\admin\\eclipse-workspace\\project1\\src\\Ass_main\\resources\\person.txt"),',');
		String[] personDetails=null;
		
    	List<Person> personList=new ArrayList<Person>();
    	List<Employment> empList=new ArrayList<Employment>();
    	
    	
    	while((personDetails=csvReader.readNext()) != null) {
    		Employment emp=new Employment(personDetails[9],personDetails[10],personDetails[11].toString());
    		empList.add(emp);
    		Person person=new Person(personDetails[0],personDetails[1],personDetails[2],personDetails[3],
    				personDetails[4],personDetails[5],personDetails[6],personDetails[7],personDetails[8],emp);
    		personList.add(person);
    	}
		for(Person p:personList) {
			dbcon.insert(p);
			
			  /*System.out.println(p.getFirstName()+"   "+p.getMiddleName()+"   "+p.
			  getLastName()+"   "+p.getGender()+" "+
			  p.getCity()+"   "+p.getState()+"   "+p.getCountry()+"   "+p.getMobile()+"   "
			  +p.getEmail()+" "+p.getEmployment());*/
			 System.out.println("Data Successfully added");
			}
		
		csvReader.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

