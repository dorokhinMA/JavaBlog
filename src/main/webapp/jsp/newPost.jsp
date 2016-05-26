<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Post</title>
</head>
<body>

<label>
    <select name="category">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}">${category.title}</option>
        </c:forEach>
    </select>
</label>

</body>
</html>
