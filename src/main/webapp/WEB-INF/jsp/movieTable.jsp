
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BodybuildingTable</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
</head>
<body class="container">
<h1>Registered Contestants List</h1>
    <div class="table-responsive">
        <table class="table table-striped">
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Rating</th>
                <th>Genres</th>
                <th>Actions</th>
            </tr>

            <c:forEach var="movies" items="${movieTable}">

                <c:url var="updateBodyBuilding" value="/updateMovie">
                        <c:param name="id" value="${movies.id}"/>
                </c:url>

                <c:url var="deleting" value="/deleting">
                    <c:param name="id" value="${movies.id}"/>
                </c:url>

                <c:url var="show" value="/show">
                    <c:param name="id" value="${movies.id}"/>
                </c:url>

                <tr>
                    <td>${movies.name}</td>
                    <td>${movies.surname}</td>
                    <td>${movies.age}</td>
                    <td>${movies.groups}</td>

                    <td>
                        <a href="${updateBodyBuilding}">Update</a>
                        <a href="${deleting}"onclick="if (!(confirm('Ar tikrai norite istrinti si irasa'))) return false"
                           >Delete</a>
                        <a href="${show}">Show</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
