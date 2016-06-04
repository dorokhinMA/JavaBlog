<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${post.title}</title>
</head>
<body>

<jsp:include page="/jsp/header.jsp"/>

<span style="font-size: 32px; color: black">${post.title}

<a href="blog?action=edit&post=${post.id}"><img src="icon/pencil.png" width="30" height="30" alt="Edit post" title="Edit post"></a>

<a href="blog?action=delete&post=${post.id}"><img src="icon/delete.png" width="30" height="30" alt="Delete post" title="Delete post"></a><br/>

</span>

<p>${post.summary}</p>
<hr/>
<p>${post.body}</p>

<table width="100%">

    <tr>
        <td width="70%" valign="top">
            <h3>Comments:</h3>

            <c:forEach items="${comments}" var="comments">
                <p>${comments.body}</p>
                <hr/>
            </c:forEach>

        </td>
    </tr>
</table>

<form action="blog" method="post">

    <label>
        <p>Add comment:</p><br/>
        <textarea rows="10" cols="45" name="body" required></textarea>
    </label><br/>
    <input type="hidden" name="mode" value="addComment">
    <input type="hidden" name="id" value="${post.id}">

    <input type ="submit" name="Add" value="Add">
</form>

</body>
</html>
