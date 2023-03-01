package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.techpalle.model.Student;

public class DataAccess 
{
	private static final String classname="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/Anuj2ee";
	private static final String username="root";
	private static final String pw="admin";
	
	private static Connection con=null;
	private static Statement stm=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	public static void insertDetails( Student s)
	{
		try
		{
			Class.forName(classname);
			con=DriverManager.getConnection(url, username, pw);
			String qry="insert into student(name,email,password,state) values(?,?,?,?)";
			ps=con.prepareStatement(qry);
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3,s.getPassword());
			ps.setString(4,s.getState());
			ps.executeUpdate();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			try
			{
				if( ps!=null)
				ps.close();
				if(con!=null)
					con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
		public static void updateDetails( String name,String state,String email,String password)
		{
			try
			{
				Class.forName(classname);
				con=DriverManager.getConnection(url, username, pw);
				String qry="update student set name=?,state=? where email=? and password=? ";
				ps=con.prepareStatement(qry);
				ps.setString(1,name);
				ps.setString(2,state);
				ps.setString(3,email);
				ps.setString(4,password);
				ps.executeUpdate();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				
			}
			finally
			{
				try
				{
					if( ps!=null)
					ps.close();
					if(con!=null)
						con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
	}
		public static void deleteDetails(String email,String password)
		{
			try
			{
				Class.forName(classname);
				con=DriverManager.getConnection(url, username, pw);
				String qry="delete from student where email=? and password=?";
				ps=con.prepareStatement(qry);
				ps.setString(1,email);
				ps.setString(2, password);
				ps.executeUpdate();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				
			}
			finally
			{
				try
				{
					if( ps!=null)
					ps.close();
					if(con!=null)
						con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		public static ArrayList<Student> showDetails()
		{
			ArrayList<Student>als=new ArrayList<Student>();
			try
			{
				Class.forName(classname);
				con=DriverManager.getConnection(url, username, pw);
				String qry="select * from student";
				stm=con.createStatement();
				 rs=stm.executeQuery(qry);
				 while(rs.next())
				 {
					 int id=rs.getInt(1);
 					String name=rs.getString(2);
 					String email=rs.getString(3);
 					String password=rs.getString(4);
 					String state=rs.getString(5);
 					Student sd=new Student(id,name,email,password,state);
					als.add(sd);
 					
				 }
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				
			}
			finally
			{
				try
				{
					if( stm!=null)
					  stm.close();
					if(con!=null)
						con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			return als;
		}
}
