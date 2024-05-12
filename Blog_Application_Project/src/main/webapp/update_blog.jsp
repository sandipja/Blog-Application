<%@page import="com.connection.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.Blog"%>
<%@page import="org.hibernate.Transaction"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update-blog</title>
<%@ include file="all_css.html"%>
</head>
<body>
	<h1>Update blog</h1>
	<%
	int blogid = Integer.parseInt(request.getParameter("blogid").trim());
	Session s = FactoryProvider.getFactory().openSession();
	Blog blog = s.get(Blog.class, blogid);
	%>
	<div class="container w-50">
		<form action="UpdateServlet" method="post">
			<input value="<%=blog.getBlogid()%>" name="blogid" hidden="hidden">
			<div class="form-group">
				<label for="blogname">Blog Title</label><input type="text"
					class="form-control" id="blogname" placeholder="Enter blog title"
					name="title" value="<%=blog.getTitle()%>">

			</div>

			<div class="form-group">
				<label for="author">Author</label> <input type="text"
					class="form-control" id="author" placeholder="Enter Author"
					name="author" value="<%=blog.getAuthor()%>">
			</div>

			<div class="form-group">
				<label for="content"> Blog Description:-</label>

				<textarea name="description" required id="content"
					placeholder="Enter your content here" class="form-control"
					style="height: 300px;"><%=blog.getDescription()%>
    </textarea>
			</div>


			<br> <br>
			<div class="container text-center">
				<button type="submit" class="btn btn-success">Edit Blog</button>
			</div>
		</form>
	</div>

</body>
</html>