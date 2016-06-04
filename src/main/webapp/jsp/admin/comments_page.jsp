<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comments page</title>
</head>
<body>

<jsp:include page="/jsp/header.jsp"/>

<h2>Manager comments:</h2>

<table border="1">


    <c:forEach items="${commentList}" var="comment">
    <tr>
        <td style="background: #e6e6fa; width: 70%;">${comment.body}</td>
        <td style="background: #f08080;"><a href="admin?action=delete&comment=${comment.id}"><img src="icon/delete.png" width="30" height="30" alt="delete comment" title="delete"></a></td>
        <td style="background: #6495ed;"><a href="blog?post=${comment.post.id}">Show post</a></td>

    </tr>
    </c:forEach>

</body>
</html>
