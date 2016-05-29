<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Post</title>
</head>
<body>

        <jsp:include page="/jsp/header.jsp"/><br/>

<form action="blog" method="post">

    <label>Title:</label>
    <p><label>
        <textarea rows="10" cols="45" name="title"  required><c:out value="${editablePost.title}"/></textarea>
    </label></p><br/>

    <label>Summary:</label>
    <p><label>
        <textarea rows="10" cols="45" name="summary" required><c:out value="${editablePost.summary}"/></textarea>
    </label></p><br/>

    <label>Body:</label>
    <p><label>
        <textarea rows="10" cols="45" name="body" required><c:out value="${editablePost.body}"/></textarea>
    </label></p><br/>

    <c:if test="${editablePost ne null}">
        <c:set var="modeEdit" value="editable"/>
        <c:set var="id" value="${editablePost.id}"/>
    </c:if>
    <input type="hidden" name="mode" value="${modeEdit}">
    <input type="hidden" name="id" value="${id}">

    <label>
        <p>Category:</p>
    <select name="category">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}">${category.title}</option>
        </c:forEach>
    </select>
    </label>

    <input type ="submit" name="Create">

</form>

</body>
</html>
