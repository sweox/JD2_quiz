<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>Quiz</title>

    <!-- reference our style sheet -->

    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/css/style.css"/>"/>
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Input name, email and select QUIZ before start</h2>
    </div>
</div>
<br>

<form:form action="processParticipantQuiz" modelAttribute="newParticipant" method="post">

    Name: <form:input placeholder="enter your name" path="name"/>
    <br>
    Email: <form:input  placeholder="enter your email" path="email"/>

    <br><br>

    <table>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Select</th>
        </tr>

        <c:forEach var="quizList" items="${quizList}">
            <tr>
                <td>${quizList.title}</td>
                <td>${quizList.description}</td>
                <td><input type="radio" name="idQuiz" value="${quizList.idQuiz}"/> </td>
            </tr>
        </c:forEach>



    </table>
    <br>

    <input type="submit" value="Begin">



</form:form>

</body>

</html>









