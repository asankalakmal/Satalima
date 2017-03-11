<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="./head.jsp"></jsp:include>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>		
        <div id="top-bar" class="container">
            <div class="row">
                <div class="span4">
                    <!--<form method="POST" class="search_form">
                        <input type="text" class="input-block-level search-query" Placeholder="eg. T-sirt">
                    </form>-->
                    <c:if test="${sessionScope.user.userType == 2}">
                        <a href="${pageContext.request.contextPath}/ViewProductList" class="logo pull-left"><img src="${pageContext.request.contextPath}/themes/images/logo.png" class="site_logo" alt=""></a>
                    </c:if>
                    <c:if test="${sessionScope.user.userType != 2}">
                        <a href="./" class="logo pull-left"><img src="${pageContext.request.contextPath}/themes/images/logo.png" class="site_logo" alt=""></a>
                    </c:if>
                    
                </div>
                <div class="span8">
                    <div class="account pull-right">

                        <ul class="user-menu">	
                            <c:if test="${sessionScope.user != null}"><li>Welcome ${sessionScope.user.firstName} ${sessionScope.user.lastName} </li>
                                <li><!--<a href="#">My Account</a></li>-->
                                    <c:if test="${sessionScope.user.userType == 1}">
                                    <li><a href="${pageContext.request.contextPath}/ViewCart">Your Cart</a></li>
                                    <li><a href="${pageContext.request.contextPath}/ViewOrderHistory">Order History</a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.user.userType == 2}">
                                    <li><a href="${pageContext.request.contextPath}/ViewProductList">Products</a></li>
                                    <!--<li><a href="${pageContext.request.contextPath}/ViewOrders">Order List</a></li>-->
                                    <li><a href="${pageContext.request.contextPath}/addProduct">Add Product</a></li>
                                    </c:if>
                                <li><a href="${pageContext.request.contextPath}/Logout">Logout</a></li>

                            </c:if>
                            <c:if test="${sessionScope.user == null}"><li><a href="${pageContext.request.contextPath}/register">Login</a></li></c:if>

                        </ul>
                    </div>
                </div>

            </div>
        </div>
