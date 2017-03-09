<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>			
            <section class="header_text sub">
                <img class="pageBanner" src="${pageContext.request.contextPath}/themes/images/pageBanner.png" alt="New products" >
                <h4><span>YOUR ORDER</span></h4>
            </section>
            <section class="main-content">				
                <div class="row">
                    <div class="span9">					
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
                                            <img alt="" src="themes/images/ladies/9.jpg" ></a>
                                    </td>
                                    <td>${item.product.name}</td>
                                    <td>${item.quantity}</td>
                                    <td>$${item.product.unitPrice}</td>
                                    <td>$${item.amount}</td>
                                </tr>
                                </c:forEach>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td><strong>$${order.totalPrice}</strong></td>
                                </tr>		  
                            </tbody>
                        </table>
           
                        <hr>
                        <p class="cart-total right">
                            <strong>Sub-Total</strong>:	$${order.totalPrice}<br>
                            <strong>Admin Fee</strong>: $${order.adminFee}<br>
                           <strong>Total</strong>: $${order.cartTotal}<br>
                        </p>
                        <hr/>					
                    </div>
                    <div class="span3 col">
                        <div class="block">	
                            <ul class="nav nav-list">
                                <li class="nav-header">SUB CATEGORIES</li>
                                <li><a href="products.html">Nullam semper elementum</a></li>
                                <li class="active"><a href="products.html">Phasellus ultricies</a></li>
                                <li><a href="products.html">Donec laoreet dui</a></li>
                                <li><a href="products.html">Nullam semper elementum</a></li>
                                <li><a href="products.html">Phasellus ultricies</a></li>
                                <li><a href="products.html">Donec laoreet dui</a></li>
                            </ul>
                            <br/>
                            <ul class="nav nav-list below">
                                <li class="nav-header">MANUFACTURES</li>
                                <li><a href="products.html">Adidas</a></li>
                                <li><a href="products.html">Nike</a></li>
                                <li><a href="products.html">Dunlop</a></li>
                                <li><a href="products.html">Yamaha</a></li>
                            </ul>
                        </div>
                        <div class="block">
                            <h4 class="title">
                                <span class="pull-left"><span class="text">Randomize</span></span>
                                <span class="pull-right">
                                    <a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
                                </span>
                            </h4>
                            <div id="myCarousel" class="carousel slide">
                                <div class="carousel-inner">
                                    <div class="active item">
                                        <ul class="thumbnails listing-products">
                                            <li class="span3">
                                                <div class="product-box">
                                                    <span class="sale_tag"></span>												
                                                    <a href="product_detail.html"><img alt="" src="themes/images/ladies/2.jpg"></a><br/>
                                                    <a href="product_detail.html" class="title">Fusce id molestie massa</a><br/>
                                                    <a href="#" class="category">Suspendisse aliquet</a>
                                                    <p class="price">$261</p>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="item">
                                        <ul class="thumbnails listing-products">
                                            <li class="span3">
                                                <div class="product-box">												
                                                    <a href="product_detail.html"><img alt="" src="themes/images/ladies/4.jpg"></a><br/>
                                                    <a href="product_detail.html" class="title">Tempor sem sodales</a><br/>
                                                    <a href="#" class="category">Urna nec lectus mollis</a>
                                                    <p class="price">$134</p>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>						
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