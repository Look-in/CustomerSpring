<%--
  Created by IntelliJ IDEA.
  User: shankunassv
  Date: 27.02.2018
  Time: 17:42
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
    <h1>${param.action} ${param.type}</h1>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div>
            <c:url var="logoutUrl" value="/logout"/>
            <form action="${logoutUrl}" id="logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <input class="user-form logout" type="submit" name="submit" value="Log Out">
            </form>
        </div>
        <div>
            <sec:authorize access="hasRole('USER')">
                <c:set var="shoppingcart" value="shopping-cart"/>
            </sec:authorize>
            <a class="user-form" href="${shoppingcart}"> Shopping cart ${countBasketItem}</a>
        </div>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <c:url var="url" value="login"></c:url>
        <div>
            <a class="user-form" href="${url}" title="">Login</a>
        </div>
        <div>
            <a class="user-form" href=""> Anonymous </a>
        </div>
    </c:if>
    <div>
        <sec:authorize access="hasRole('USER')">
            <c:set var="ordercart" value="/shopping-cart/show-orders"/>
        </sec:authorize>
        <a class="user-form" href="${ordercart}">Account</a>
    </div>
</header>