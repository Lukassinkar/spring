
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bodybuilding</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
</head>
<body class="container">
    <div class="table-responsive">
        <caption>Contestant information</caption>
        <table class="table table-striped">
            <tr>
                <td><b>Id:</b></td>
                <td>${movies.id}</td>
            </tr>
            <tr>
                <td><b>Name:</b></td>
                <td>${movies.name}</td>
            </tr>
            <tr>
                <td><b>Surname:</b></td>
                <td>${movies.surname}</td>
            </tr>
            <tr>
                <td><b>Age:</b></td>
                <td>${movies.age}</td>
            </tr>
            <tr>
                <td><b>Group:</b></td>
                <td>${movies.groups}</td>
            </tr>
        </table>
    </div>
<br>
<a type="button" href="/movieTable" class="button">Back</a>
</body>
</html>
