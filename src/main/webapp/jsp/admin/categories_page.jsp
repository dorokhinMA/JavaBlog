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

        <c:if test="${editableCategory ne null}">
            <c:set var="action" value="editCategory"/>
            <c:set var="id" value="${editableCategory.id}"/>
            <c:set var="button" value="Edit"/>
        </c:if>

        <c:if test="${editableCategory eq null}">
            <c:set var="action" value="addCategory"/>
            <c:set var="button" value="Add"/>
        </c:if>
        <input type="hidden" name="id" value="${id}">

        <label>
            <p>${button} category:</p><br/>
            <textarea rows="5" cols="50" name="title" required><c:out value="${editableCategory.title}"/></textarea>
        </label>
        <input type="hidden" name="action" value="${action}">
        <input type ="submit" name="Add" value="${button}">
    </form>

</body>
</html>
