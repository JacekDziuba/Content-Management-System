<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>Update Author</title>
</head>
<body>
<form:form method="post" modelAttribute="authorToUpdate">
    <table>
        <tr>
            <td>First Name: </td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td><form:input path="lastName" /></td>
        </tr>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>

<a href="http://localhost:8080/getAllAuthors">All authors</a>
</body>
</html>
