<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>All Categories</title>
</head>
<body>

<br>
<c:forEach var="category" items="${categories}">
    <table border="1">
        <tr>
            <td><c:out value="${category.id} ${category.name}"/><br></td>
            <td>
                <a href="<c:url value="/deletecategorytoconfirm/${category.id}" />">Delete</a>
                <a href="<c:url value="/updateCategory/${category.id}" />">Edit</a>
            </td>
        </tr>
    </table>
</c:forEach>
<br>
<a href="http://localhost:8080/homePage">Take me home</a>
</body>
</html>
