<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>			
        <section class="header_text sub">
            <h2><span>YOUR ORDER</span></h2>
        </section>
        <section class="main-content">				
            <div class="row">
                <div class="span12">					
                    <h4 class="title"><span class="text">Order ID: <strong>${order.id}</strong></span></h4>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Image</th>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${order.cartItems}" varStatus="index">
                            <tr>
                                <td><a href="${pageContext.request.contextPath}/ViewProduct?productIndex=${item.productIndex}">
                                    <c:choose>
                                        <c:when test="${not empty item.product.image}">
                                            <img src="${pageContext.request.contextPath}/Images/${item.product.seller.userId}/${item.product.image}" class="product-cart-img"/>
                                        </c:when>
                                        <c:otherwise>
                                            <img src="${pageContext.request.contextPath}/themes/images/no_image.png" class="product-cart-img"/>
                                        </c:otherwise>
                                    </c:choose>
                                 </a>
                                </td>
                                <td>${item.product.name}</td>
                                <td>${item.quantity}</td>
                                <td><fmt:formatNumber value="${item.product.unitPrice}" type="currency"/></td>
                                <td><fmt:formatNumber value="${item.amount}" type="currency"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td><strong><fmt:formatNumber value="${order.totalPrice}" type="currency"/></strong></td>
                        </tr>		  
                    </tbody>
                </table>

                <hr>
                <p class="cart-total right">
                    <strong>Sub-Total</strong>:	<fmt:formatNumber value="${order.totalPrice}" type="currency"/><br>
                    <strong>Admin Fee</strong>: <fmt:formatNumber value="${order.adminFee}" type="currency"/><br>
                    <strong>Total</strong>: <fmt:formatNumber value="${order.cartTotal}" type="currency"/><br>
                </p>
                <hr/>					
            </div>
        </div>
    </section>			
    <jsp:include page="/jsp/common/footer.jsp"></jsp:include>
    </div>
    <script src="${pageContext.request.contextPath}/themes/js/common.js"></script>
<script>
    $(document).ready(function () {
        $('#checkout').click(function (e) {
            document.location.href = "checkout.html";
        })
    });
</script>		
</body>
</html>