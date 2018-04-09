<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.04.2018
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="../resources/global.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="../resources/item.css"/>" rel="stylesheet" type="text/css"/>
    <title>Title</title>
</head>
<body>
<h1>Error Page</h1>
<div class="exception">
    <div>
        <p>Application has encountered an error. Please contact support on ...</p>
        Failed URL: ${url}
        Exception: ${ex.message}
        <c:forEach items="${ex.stackTrace}" var="ste">    ${ste}
        </c:forEach>
    </div>
    <a href="/" title="">Return</a>
</div>
</body>
</html>
