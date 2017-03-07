<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="./head.jsp"></jsp:include>
    </head>
    <body>		
        <div id="top-bar" class="container">
            <div class="row">
                <div class="span4">
                    <form method="POST" class="search_form">
                        <input type="text" class="input-block-level search-query" Placeholder="eg. T-sirt">
                    </form>
                </div>
                
                
                <div class="span8">
                    <div class="account pull-right">
                        <ul class="user-menu">				
                            <li><a href="#">My Account</a></li>
                            <li><a href="${pageContext.request.contextPath}/cart">Your Cart</a></li>
                            <li><a href="${pageContext.request.contextPath}/cart">Checkout</a></li>					
                            <li><a href="${pageContext.request.contextPath}/register">Login</a></li>		
                        </ul>
                    </div>
                </div>
                
            </div>
        </div>
