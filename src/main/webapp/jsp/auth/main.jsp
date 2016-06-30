<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>

    <h2>Авторизация</h2>
    <form action="authorization" method="POST">
        <div id="loginBox">
            <p><strong>Ваш логин:</strong>
                <input placeholder="Введите логин" type="text" size="20" name="login"></p>
            <p><strong>Пароль:</strong>
                <input placeholder="Введите пароль" type="password" size="20" name="pass"></p>
            <p><input type="submit" value="Авторизоваться"></p>
        </div>
    </form>

</body>
</html>
