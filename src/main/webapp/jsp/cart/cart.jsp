<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>			
        <section class="header_text sub">
            <h2><span>Shopping Cart</span></h2>
        </section>
        <section class="main-content">				
            <div class="row">
                <div class="span12">					
                    <h4 class="title"><span class="text"><strong>Your</strong> Cart</span></h4>
                    <div id="cart_items">
                    <c:if test="${fn:length(cart.cartItems) eq 0}">
                        <h2 class="center">No item in the Cart</h2>
                    </c:if>
                    <c:if test="${fn:length(cart.cartItems) gt 0}">
                        <jsp:include page="/jsp/cart/cart_items.jsp" ></jsp:include>
                    </c:if>

                </div>
                <hr/>
                <p class="buttons center">
                    <button class="btn" type="button" id="conShopping">Continue Shopping</button>
                    <c:if test="${fn:length(cart.cartItems) gt 0}">
                        <button class="btn" type="button" onclick="updateCart()">Update</button>
                        <button class="btn btn-inverse" type="button" id="checkout">Checkout</button>
                    </c:if>
                </p>					
            </div>
        </div>
    </section>			
    <jsp:include page="/jsp/common/footer.jsp"></jsp:include>
    </div>
    <script src="${pageContext.request.contextPath}/themes/js/common.js"></script>
<script>
                            $(document).ready(function () {
                                $('#checkout').click(function (e) {
                                    document.location.href = "${pageContext.request.contextPath}/checkout";
                                });
                            });

                            $(document).ready(function () {
                                $('#conShopping').click(function (e) {
                                    document.location.href = "${pageContext.request.contextPath}";
                                });
                            });
</script>		
</body>
</html>