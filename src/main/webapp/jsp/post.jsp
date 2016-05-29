<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${post.title}</title>
</head>
<body>

<jsp:include page="/jsp/header.jsp"/>

<a href="blog?action=edit&post=${post.id}">Edit post</a><br/>
<a href="blog?action=delete&post=${post.id}">Delete post</a><br/>

<span style="font-size: 32px; color: black">${post.title}</span>

<p>${post.summary}</p>
<hr/>
<p>${post.body}</p>

<table width="100%">

    <tr>
        <td width="70%" valign="top">
            <h3>Comments:</h3>
            
            <%--@elvariable id="comments" type="java.util.List"--%>
            <c:forEach items="${comments}" var="comments">
                <p>${comments.body}</p>
                <hr/>
            </c:forEach>

        </td>


</body>
</html>
