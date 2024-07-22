package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDProject {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		create();
		insert(1,"jyothi","java");
		insert(2,"revathi","python");
		insert(3,"deepika","java");
		insert(4,"sunil","AI");
		insert(5,"supriya","dot net");
		read();
		update(3,"python");
		delete(2);
	}
	public static void create() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "Jyo@912001");
			Statement s=con.createStatement();
			s.executeUpdate("create table student(sno int,sname varchar(40),scourse varchar(20))");
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void insert(int sno,String name,String course) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "Jyo@912001");
			String query="insert into student values(?,?,?)";
			PreparedStatement s=con.prepareStatement(query);
			s.setInt(1,sno);
			s.setString(2, name);
			s.setString(3, course);
			s.executeUpdate();
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void read() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "Jyo@912001");
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery("select * from student");
			while(r.next()==true) {
				System.out.println("sno :"+r.getInt(1));
				System.out.println("name :"+r.getString(2));
				System.out.println("course :"+r.getString(3));
			}
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void update(int sno,String course) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "Jyo@912001");
			String query="update student set scourse=? where sno=?";
			PreparedStatement s=con.prepareStatement(query);
			s.setString(1, course);
			s.setInt(2, sno);
			s.executeUpdate();
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void delete(int sno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "Jyo@912001");
			String query="delete from student where sno=?";
			PreparedStatement s=con.prepareStatement(query);
			s.setInt(1, sno);
			s.executeUpdate();
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
