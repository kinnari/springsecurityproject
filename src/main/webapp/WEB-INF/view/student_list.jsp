<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>name</td>
<td>email</td>
<td>update</td>
</tr>
<tr><td colspan="3"> <a href="/add-student" class="btn btn-primary">Add student</a></td></tr>
<c:forEach items="${students}" var="student">
<tr><td>${student.name}</td>
<td>${student.emailId}</td>
<td><a href="/edit/${student.id}">Update</a></td>
<td><a href="/delete/${student.id}">Delete</a></td>
</tr>

</c:forEach>
</table>
</body>
</html>