<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>Add new Tweet</title>
</head>

<style>
    .error {
        color: crimson;
    }
</style>

<body>

<form:form method="post" modelAttribute="tweet">
    <table>
        <tr>
            <td>Title: </td>
            <td><form:input path="title" /></td>
            <td><form:errors path="title" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Tweet Text: </td>
            <td><form:textarea path="tweetText" /></td>
            <td><form:errors path="tweetText" cssClass="error" /></td>
        </tr>
        <tr>
            <td>User: </td>
            <td><form:select path="user.id" items="${users}" itemValue="id" itemLabel="lastName" /></td>
            <td><form:errors path="user.id" cssClass="error" /></td>
        </tr>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
