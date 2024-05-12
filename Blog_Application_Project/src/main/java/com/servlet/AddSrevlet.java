package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.FactoryProvider;
import com.model.Blog;

public class AddSrevlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String author = request.getParameter("author");
		Blog b1 = new Blog();
		Session session = FactoryProvider.getFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		b1.setTitle(title);
		b1.setDescription(description);
		b1.setAuthor(author);
		
		
		session.save(b1);
		
		tx.commit();
		session.close();
//	    out.println("<html><body>");
//	    out.println("<h3 style='color: green;'>Blog added successfully!</h3>");
//
//        out.println("</body></html>");
		response.sendRedirect("show_all_blog.jsp");
		
		
	}

}
