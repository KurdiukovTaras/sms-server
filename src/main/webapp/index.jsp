<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My first web page</title>
    <link href="style.css" rel="stylesheet" type="text/css">
    <!--<script type="text/javascript">-->
    <script src="jquery-3.0.0.min.js"></script>
    <script src="script.js"></script>
</head>
<body>

<div id="forSearch">

        Поиск по номеру или имени
    <form  action="client" method="get">
    <input type="text" name="phoneNumber"><br/>
        <button type="submit">Выбрать</button>
    <br>
    </form>
</div>

<div id="sms">

       <h1> Содержание смсок</h1>

    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
</div>

<div id="clients">
    <h1>
        Клиенты:
        <p>
        Макс
        <p>
        Вениамин
        <p>
        Сергей
        <p>
        Андрей
        <p>
        Денис
        </h1>
</div>

<div id="writeSms">
        <h1>Тут можно написать смску</h1>
        <input type="text" id='val2'><br/>
    <br/>
    <button type="submit">Submit</button>
</div>

</body>
<footer>
    </footer>

</html>