<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Categories page</title>
</head>
<body>

    <jsp:include page="/jsp/header.jsp"/>

    <h2>Manager categories:</h2>

<table border="1">



    <c:forEach items="${allCategories}" var="cat">
        <tr>
        <td style="background: #e6e6fa; width: 70%;">${cat.title}</td>
        <td style="background: #6495ed;"><a href="admin?action=edit&category=${cat.id}"><img src="icon/pencil.png" width="30" height="30" alt="Edit category" title="edit"></a></td>
        <td style="background: #f08080;"><a href="admin?action=delete&category=${cat.id}"><img src="icon/delete.png" width="30" height="30" alt="delete category" title="delete"></a></td>
        </tr>
    </c:forEach>

</table>

    <hr/><br/>

    <form action="admin" method="post">

        <label>
            <p>Add new category:</p><br/>
            <textarea rows="5" cols="50" name="title" required></textarea>
        </label>
        <input type="hidden" name="action" value="addCategory">
        <input type ="submit" name="Add" value="Add">
    </form>

</body>
</html>
