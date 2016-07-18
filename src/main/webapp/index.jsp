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
    <iframe name="smsName" src="smsList.jsp" width="600" height="600" >
        Ваш браузер не поддерживает встроенные фреймы!
    </iframe>
     </div>

<div id="clients">
    <iframe src="clientList.jsp" name="clientsName" width="240" height="600" align="left">
        Ваш браузер не поддерживает встроенные фреймы!
    </iframe>

</div>

<div id="writeSms">
    <iframe src="writeSms.jsp" name="writeSmsName" width="610" height="120" align="left">
        Ваш браузер не поддерживает встроенные фреймы!
    </iframe>
</div>

</body>
<footer>
    </footer>

</html>