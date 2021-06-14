<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kinpa Blog</title>
</head>
<body>
	<form:form method="POST" modelAttribute="blog" action="posts">
		<p>Texto: <form:input path="texto"/></p>
		<!-- prototipo de imagem <p>Imagem: <input type="image" name="imagem"> -->
		<p><form:button>Postar</form:button></p>
		<p>${mensagem}</p>
	</form:form>
	
	<p>
		<table>
			<thead>
				<tr>
					<th>Texto</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="blog" items="${blogs}">
					<tr>
						<td>${blog.texto}</td>
						<td>
							<a href="editar/${blogs.indexOf(blog)}">Editar</a>
							<a href="excluir/${blogs.indexOf(blog)}">Excluir</a>
						</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
</body>
</html>