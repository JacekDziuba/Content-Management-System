<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>Add new article</title>
</head>

<style>
    .error {
        color: crimson;
    }
</style>

<body>

<form:form method="post" modelAttribute="article">
    <a href="http://localhost:8080/getAllArticles">All articles</a>
    <table>
        <tr>
            <td>Title: </td>
            <td><form:input path="title" /></td>
            <td><form:errors path="title" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Content: </td>
            <td><form:input path="content" /></td>
            <td><form:errors path="content" cssClass="error"/></td>
        <tr>
            <td>Author: </td>
            <td><form:select path="author.id" items="${authors}" itemValue="id" itemLabel="lastName" /></td>
            <td><form:errors path="author.id" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Category: </td>
            <td><form:select path="category.id" items="${categories}" itemValue="id" itemLabel="name" /></td>
            <td><form:errors path="category.id" cssClass="error" /></td>
        </tr>
        </tr>
        <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>

</body>
</html>

