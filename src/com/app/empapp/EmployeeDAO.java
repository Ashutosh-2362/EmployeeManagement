package com.app.empapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	static Connection con = DBConnect.getConnection();
	
	public List<Employee> getRecords(){
		List<Employee> emp = new ArrayList<Employee>();
		String query = "select * from employee";
	
		try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				Employee s = new Employee();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setSalary(rs.getDouble("salary"));
				s.setAge(rs.getInt("age"));
				
				emp.add(s);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		return emp;
	}
	
	public boolean insertRecord(String name, double salary, int age) {
		String query = "insert into employee(name,salary,age) values(?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setInt(3, age);
			
			
			//Here the query will return int value indicating the number of rows inserted
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
	public boolean deleteRecord(int id) {
		String query = "delete from employee where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			
			
			//Here the query will return int value indicating the number of rows inserted
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Employee searchRecord(String name) {
		Employee em=null;
		String query = "select * from employee where name=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			
			
			ResultSet rs = ps.executeQuery();
			
		
			
			if(rs.next()) {
				em=new Employee();
			em.setId(rs.getInt("id"));
			em.setName(rs.getString("name"));
			em.setSalary(rs.getDouble("salary"));
			em.setAge(rs.getInt("age"));
			
			} 
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return em;
	}
	
	public boolean updateRecord(Employee em) {
		
		String query = "update  employee set name=?,salary=?,age=? where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, em.getName());
			ps.setDouble(2, em.getSalary());
			ps.setInt(3, em.getAge());
			ps.setInt(4, em.getId());
			
			
			
             int i = ps.executeUpdate();
			
			    if(i>0)
				return true;
		
			
			
			
			 
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
}

