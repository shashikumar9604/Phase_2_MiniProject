package com.shashi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/Product";
		String uname="root";
		String pass="Simplilearn";
		
		response.setContentType("text/html");
		
		String pId = request.getParameter("p_ID");
	
		PrintWriter out = response.getWriter();
		
		String query="select * from Product where p_id=?";
		out.print("<h1>Displaying the Product Details...</h1>");
		out.print("<table border='1'><tr><th>Product Id</th><th>Product Name</th><th>Product Price</th></tr>");
		
		try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection dbCon = DriverManager.getConnection(url, uname, pass);
	      PreparedStatement st=  dbCon.prepareStatement(query);
	      
	      st.setString(1, pId);
	      
	      ResultSet rs =st.executeQuery();
	      
	      while(rs.next()) {
	    	  
	    	  out.print("<tr><td>");
	    	  out.println(rs.getInt("p_id"));
	    	  out.print("</td>");
	    	  out.print("<td>");
	    	  out.print(rs.getString("p_name"));
	    	  out.print("</td>");
	    	  out.print("<td>");
	    	  out.print(rs.getInt("p_price"));
	    	  out.print("</td>");
	    	  out.print("</tr>");
	    
	    	  
			}
	      
		}
		catch(ClassNotFoundException | SQLException e){
			
			System.out.println("Some Issue : "+ e.getMessage());
			
			
		}
		
		out.print("</table>");
		
	}

}
