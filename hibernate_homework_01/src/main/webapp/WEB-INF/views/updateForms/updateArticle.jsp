<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>Update article</title>
</head>
<body>

<form:form method="post" modelAttribute="articleToUpdate">
    <a href="http://localhost:8080/getAllArticles">All articles</a>
    <table>
        <tr>
            <td>Title: </td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td>Content: </td>
            <td><form:input path="content" /></td>
        <tr>
            <td>Author: </td>
            <td><form:select path="author.id" items="${authors}" itemValue="id" itemLabel="lastName" /></td>
        </tr>
        <tr>
            <td>Category: </td>
            <td><form:select path="category.id" items="${categories}" itemValue="id" itemLabel="name" /></td>
        </tr>
        </tr>
        <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
