<%@page import="org.hibernate.Query"%>
<%@page import="com.connection.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.Blog"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show-all-blog</title>
<%@ include file="all_css.html"%>
</head>
<center>
	<body>
	
	<div class="container"></div>
		<h1>Show All Blog:</h1>
		<div>
			<div class="col-12">
				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Blog");

				List<Blog> list = q.list();
				for (Blog blog : list) {
					// 					out.priantln(blog.getBlogid() + "  :  " + blog.getTitle() + " :  " + blog.getDescription() + "  :" + blog.getAuthor()
					// 					+ "<br>");
				%>
				<div class="card mt-3 " style="width: 30rem;">
					<img class="card-img-top p-3" style="width: width:22px;">
					<div class="card-body">
						<h5 class="card-title">
							Title:
							<%=blog.getTitle()%></h5>
							<h4 class="card-text">Author:
						 <%=blog.getAuthor()%></h4>
							
						<p class="card-text">Description:  
						 <%=blog.getDescription()%></p>
						<br> <a href="DeleteServlet?blogid=<%=blog.getBlogid()%>"
							class="btn btn-danger">Delete</a> <a
							href="update_blog.jsp?blogid=<%=blog.getBlogid()%>"
							class="btn btn-primary">Update</a>
					</div>
				</div>
				<%
				}

				s.close();
				%>
			</div>
		</div>
	</body>
</html>