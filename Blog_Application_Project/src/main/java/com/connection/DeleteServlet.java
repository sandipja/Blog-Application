package com.connection;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.model.Blog;

public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int blogid = Integer.parseInt(request.getParameter("blogid").trim());
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			Blog blog = s.get(Blog.class, blogid);
			if (blog != null) {
				s.delete(blog);
			}
			tx.commit();
			s.close();

			response.sendRedirect("show_all_blog.jsp");
		} catch (Exception e) {
			e.printStackTrace();

			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting blog");
		}
	}
}
