<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>Should you delete or should you go??</title>
</head>
<body>

<tr>
    <td>Confirm :</td>
    <td><a href="<c:url value="/deletecategory/${categoryId}" />">Delete</a></td>
    <td><a href="<c:url value="/homePage/" />">Cancel</a></td>
</tr>

</body>
</html>
