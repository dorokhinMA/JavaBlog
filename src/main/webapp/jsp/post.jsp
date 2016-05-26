<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${post.title}</title>
</head>
<body>

<jsp:include page="/jsp/header.jsp"/>

<span style="font-size: 32px; color: #00008b">${post.title}</span>

<p>${post.summary}</p>
<hr/>
<p>${post.body}</p>


</body>
</html>
