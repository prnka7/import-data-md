package com.emxcel.ass_1.project1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class dbconn
{
	
	private static dbconn db;
	
	public dbconn() {
		
	}
	
	public static dbconn getInstance() throws ClassNotFoundException, SQLException {
		if(db == null) {
			db=new dbconn();
		}
		return db;
	}
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn=null;
		 Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection( "jdbc:postgresql://localhost:5432/Assignment1","postgres", "admin");
		System.out.println("connection done");
		return conn;
	}
	
	public void insert(Person prsn) throws ClassNotFoundException, SQLException {
		Connection cn=null;
		PreparedStatement stat1=null;
		PreparedStatement stat2=null;
		ResultSet rs=null;
		
		cn=dbconn.getConnection();
		stat2=cn.prepareStatement("insert into tbl_employment (employer_name,designation,employment_date) values(?,?,?)"
				,Statement.RETURN_GENERATED_KEYS);
		stat2.setString(1, prsn.getEmployment().getEmployerName());
		stat2.setString(2, prsn.getEmployment().getDesignation());
		stat2.setDate(3, prsn.getEmployment().getEmploymentDate());
		stat2.execute();
		rs=stat2.getGeneratedKeys();
		
		if(rs.next()) {
			
		}
		
		stat1=cn.prepareStatement("insert into tbl_person(first_name,last_name,middle_name,mobile,email,gender,city,state,country,employment_id)values(?,?,?,?,?,?,?,?,?,?)");
		stat1.setString(1, prsn.getFirstName());
		stat1.setString(2, prsn.getLastName());
		stat1.setString(3, prsn.getMiddleName());
		stat1.setString(4, prsn.getMobile());
		stat1.setString(5, prsn.getEmail());
		stat1.setString(6, prsn.getGender());
		stat1.setString(7, prsn.getCity());
		stat1.setString(8, prsn.getState());
		stat1.setString(9, prsn.getCountry());
		stat1.setInt(10, rs.getInt(1));
		
		stat1.executeUpdate();
	}
	


}
