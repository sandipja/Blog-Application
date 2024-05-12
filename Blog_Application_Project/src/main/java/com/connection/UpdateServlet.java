package com.connection;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.model.Blog;

public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {

			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String author = request.getParameter("author");
			int blogid = Integer.parseInt(request.getParameter("blogid").trim());

			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();

			Blog blog = s.get(Blog.class, blogid);

			blog.setTitle(title);
			blog.setDescription(description);
			blog.setAuthor(author);

			tx.commit();

			s.close();
			 out.println("<html><body>");
			    out.println("<h3 style='color: green;'>Blog Update successfully!</h3>");

		        out.println("</body></html>");

			response.sendRedirect("show_all_blog.jsp");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
