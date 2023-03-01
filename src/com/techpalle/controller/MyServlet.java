package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Student;

@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getServletPath();
		switch(path)
		{
		case "/studform":
			String op=request.getParameter("crud");
			if("Insert".equalsIgnoreCase(op))
				insertDetails(request, response);
			else if("Update".equalsIgnoreCase(op))
				updateDetails(request, response);
			else if("Delete".equalsIgnoreCase(op))
				deleteDetails(request, response);
			else
				showDetails(request, response);
			
			break;
		default:
			getStartUpPage(request, response);
			break;
		}
	}

	private void showDetails(HttpServletRequest request, HttpServletResponse response)
	{
		ArrayList<Student> a=DataAccess.showDetails();
		request.setAttribute("show", a);
		try
		{
			RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e)
		{ 
			e.printStackTrace();
		}
	}

	private void deleteDetails(HttpServletRequest request, HttpServletResponse response)
	{
		String email=request.getParameter("tbemail");
		String password=request.getParameter("tbpw");
		DataAccess.deleteDetails(email, password);
	}

	private void updateDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		String name=request.getParameter("tbname");
		String email=request.getParameter("tbemail");
		String password=request.getParameter("tbpw");
		String state=request.getParameter("ddlstates");
		DataAccess.updateDetails(name,state,email,password);
	}

	private void insertDetails(HttpServletRequest request, HttpServletResponse response)
	{
		String name=request.getParameter("tbname");
		String email=request.getParameter("tbemail");
		String password=request.getParameter("tbpw");
		String state=request.getParameter("ddlstates");
		Student s=new Student(name, email, password, state);
	   DataAccess.insertDetails(s);	
	}

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			RequestDispatcher rd=request.getRequestDispatcher("student_form.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e)
		{ 
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
