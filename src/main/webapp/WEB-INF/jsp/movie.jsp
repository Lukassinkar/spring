
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Bodybuilding</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
</head>
<body class="container">
<div class="anketa">


    <div class="container">
    <form:form method="post" action="movieShow" modelAttribute="number">
            <h2>Create Form</h2>

            <div class="form-group">
                <form:input cssClass="form-control" type="text" path="title" placeholder="title"/>
                <form:errors path="title" cssClass="error"/><br><br>
            </div>
            <div class="form-group">
                <form:input cssClass="form-control" type="text" path="author" placeholder="author"/>
                <form:errors path="author" cssClass="error"/><br><br>
            </div>
            <div class="form-group">
                <form:input cssClass="form-control" type="text" path="rating"  placeholder="rating"/>
                <form:errors path="rating" cssClass="error"/><br><br>
            </div>
            <div class="form-group">
                <select class="form-contorl" name="groups">
                    <option selected="selected" value="Classic Physique">Genre</option>
                    <option value="Horror">Horror</option>
                    <option value="Action">Action</option>
                    <option value="Romance">Romance</option>
                </select><br><br>
            </div>
        <input type="submit" value="Confirm">
    </form:form>
    </div>
</body>
</html>
