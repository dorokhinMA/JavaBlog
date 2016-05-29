<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Java Blog</title>
</head>
<body>

    <jsp:include page="/jsp/header.jsp"/>

    <table width="100%">
        <tr>
            <td colspan="2" align="right"><a href="new_post">Create Post</a></td>
        </tr>

        <tr>
            <td width="70%" valign="top">
                <h2>Posts:</h2>

                <%--@elvariable id="allPosts" type="java.util.List"--%>
                <c:forEach items="${allPosts}" var="post">
                    <h1>${post.title}</h1>
                    <p>${post.summary}</p>
                    <a href="blog?post=${post.id}">Read more...</a>
                    <hr/>
                </c:forEach>

            </td>


            <td  valign="top" style="background-color: cadetblue">
                <h2>Categories:</h2>
                <ul>
                    <%--@elvariable id="categories" type="java.util.List"--%>
                    <c:forEach items="${categories}" var="category">
                        <li><a href="blog?category=${category.id}">${category.title}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>

    </table>


</body>
</html>
