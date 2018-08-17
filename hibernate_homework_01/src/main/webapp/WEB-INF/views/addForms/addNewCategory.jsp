<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>Add new category</title>
</head>

<style>
    .error {
        color: crimson;
    }
</style>

<body>
<form:form method="post" modelAttribute="category">
    <table>
        <tr>
            <td>Name: </td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Description: </td>
            <td><form:input path="description" /></td>
            <td><form:errors path="description" cssClass="error" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>

<a href="http://localhost:8080/getAllCategories">All categories</a>
</body>
</html>
