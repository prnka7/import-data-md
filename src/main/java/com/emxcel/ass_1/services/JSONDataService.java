package com.emxcel.ass_1.services;

import java.io.FileReader;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.emxcel.ass_1.connection.Database_Connection;
import com.emxcel.ass_1.entity.Employment;
import com.emxcel.ass_1.entity.Person;

@SuppressWarnings("unused")
public class JSONDataService implements DataService {

	@SuppressWarnings("unchecked")
	public void export() {
		try {
			Database_Connection dbcon = Database_Connection.getInstance();

			List<Person> personList = new ArrayList<Person>();
			List<Employment> empList = new ArrayList<Employment>();

			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(new FileReader(
					"C:\\Users\\admin\\eclipse-workspace\\project1\\src\\Ass_main\\resources\\pattern.json"));

			for (Object objt : array) {

				JSONObject personobj = (JSONObject) objt;
				JSONArray emparr = new JSONArray();
				emparr.add(personobj.get("employment"));
				// System.out.println(emparr);
				Employment emp = new Employment();
				for (Object obj2 : emparr) {

					JSONObject empobj = (JSONObject) obj2;
					emp.setEmployerName(empobj.get("employerName").toString());
					emp.setDesignation(empobj.get("designation").toString());
					String d = empobj.get("employmentDate").toString();
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
					java.util.Date udate = sdf1.parse(d);
					java.sql.Date sdate = new java.sql.Date(udate.getTime());
					emp.setEmploymentDate(sdate);
					empList.add(emp);
				}
				Person pr = new Person();
				pr.setFirstName(personobj.get("firstName").toString());
				pr.setMiddleName((String) personobj.get("middleName"));
				pr.setLastName(personobj.get("lastName").toString());
				pr.setMobile(personobj.get("mobile").toString());
				pr.setEmail(personobj.get("email").toString());
				pr.setGender(personobj.get("gender").toString());
				pr.setCity(personobj.get("city").toString());
				pr.setState((String) personobj.get("state"));
				pr.setCountry(personobj.get("country").toString());
				pr.setEmployment(emp);
				personList.add(pr);
			}
			for (Person p : personList) {
				dbcon.insert(p);

				/*
				 * System.out.println(p.getFirstName()+"   "+p.getMiddleName()+"   "+p.
				 * getLastName()+"   "+p.getGender()+" "+
				 * p.getCity()+"   "+p.getState()+"   "+p.getCountry()+"   "+p.getMobile()+"   "
				 * +p.getEmail()+" "+p.getEmployment());
				 */
				System.out.println("Data Successfully added");

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
