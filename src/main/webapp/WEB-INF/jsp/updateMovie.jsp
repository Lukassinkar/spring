<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
</head>
<body class="container">
<div class = updatebody>
    <form:form name="movies" action="/updateBodyBuildings" method="post">
        <input type="hidden" name="id" value="${movies.id}"><p>
        Name:<br>
        <input type="text" name="title" value="${movies.title}"><p>
        Surname:<br>
        <input type="text" name="author" value="${movies.author}"><p>
        Age:<br>
        <input type="text" name="rating" value="${movies.rating}"><p>
        Group:<br>
        <div class="form-group">
            <select class="form-contorl" name="groups" value>
                <option selected="selected" value="Classic Physique">Genre</option>
                <option value="Horror">Horror</option>
                <option value="Action">Action</option>
                <option value="Romance">Romance</option>
            </select><br><br>
        </div>
        <input type="submit" value="Update">
</div>
    </form:form>
</body>

</html>
