<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>Add new Author</title>
</head>

<style>
    .error {
        color: crimson;
    }
</style>

<body>

<form:form method="post" modelAttribute="author">
    <table>
        <tr>
            <td>First Name: </td>
            <td><form:input path="firstName" /></td>
            <td><form:errors path="firstName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td><form:input path="lastName" /></td>
            <td><form:errors path="lastName" cssClass="error" /></td>
        </tr>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>

<a href="http://localhost:8080/getAllAuthors">All authors</a>
</body>
</html>
