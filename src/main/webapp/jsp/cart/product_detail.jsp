<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>
        <section class="header_text sub">
            <img class="pageBanner" src="${pageContext.request.contextPath}/themes/images/pageBanner.png" alt="New products" >
        <h4><span>Product Detail</span></h4>
    </section>
    <section class="main-content">				
        <div class="row">						
            <div class="span9">
                <div class="row">
                    <div class="span4">
                        <a href="${pageContext.request.contextPath}/themes/images/ladies/1.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 1"><img alt="" src="themes/images/ladies/1.jpg"></a>												
                        <ul class="thumbnails small">								
                            <li class="span1">
                                <a href="${pageContext.request.contextPath}/themes/images/ladies/2.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 2"><img src="themes/images/ladies/2.jpg" alt=""></a>
                            </li>								
                            <li class="span1">
                                <a href="${pageContext.request.contextPath}/themes/images/ladies/3.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 3"><img src="themes/images/ladies/3.jpg" alt=""></a>
                            </li>													
                            <li class="span1">
                                <a href="${pageContext.request.contextPath}/themes/images/ladies/4.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 4"><img src="themes/images/ladies/4.jpg" alt=""></a>
                            </li>
                            <li class="span1">
                                <a href="${pageContext.request.contextPath}/themes/images/ladies/5.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 5"><img src="themes/images/ladies/5.jpg" alt=""></a>
                            </li>
                        </ul>
                    </div>
                    <div class="span5">
                        <address>
                            <strong>Seller:</strong> <span>${detailProduct.seller.sellerName}</span><br>
                            <strong>Product Name:</strong> <span>${detailProduct.name}</span><br>
                            <strong>Availability:</strong> 
                            <c:if test="${detailProduct.quantity == 0}">
                           <span class="red_font">Out Of Stock</span><br>
                            </c:if>
                            <c:if test="${detailProduct.quantity != 0}">
                           <span>${detailProduct.quantity} units available</span><br>
                            </c:if>
                        </address>									
                        <h4><strong>Price: $${detailProduct.unitPrice}</strong></h4>
                    </div>
                    <div class="span5">
                        <form class="form-inline" action="${pageContext.request.contextPath}/AddItem" method="post">    
                            <input type="hidden" name="productIndex" value="${productIndex}"/>
                            <p>&nbsp;</p>
                            <label>Qty:</label>
                            <input type="text" class="span1" name="quantity" id="quantity">
                            <button class="btn btn-inverse" type="submit">Add to cart</button>
                        </form>
                    </div>							
                </div>
                <div class="row">
                    <div class="span9">
                        <ul class="nav nav-tabs" id="myTab">
                            <li class="active"><a href="#home">Description</a></li>
                            <li class=""><a href="#profile">Seller Details</a></li>
                        </ul>							 
                        <div class="tab-content">
                            <div class="tab-pane active" id="home">${detailProduct.description}</div>
                            <div class="tab-pane" id="profile">
              ${detailProduct.seller.sellerDescription}
                            </div>
                        </div>							
                    </div>						
                    
                </div>
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
                                            <a href="product_detail.html"><img alt="" src="themes/images/ladies/7.jpg"></a><br/>
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
                                            <a href="product_detail.html"><img alt="" src="themes/images/ladies/8.jpg"></a><br/>
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
                <div class="block">								
                    <h4 class="title"><strong>Best</strong> Seller</h4>								
                    <ul class="small-product">
                        <li>
                            <a href="#" title="Praesent tempor sem sodales">
                                <img src="themes/images/ladies/1.jpg" alt="Praesent tempor sem sodales">
                            </a>
                            <a href="#">Praesent tempor sem</a>
                        </li>
                        <li>
                            <a href="#" title="Luctus quam ultrices rutrum">
                                <img src="themes/images/ladies/2.jpg" alt="Luctus quam ultrices rutrum">
                            </a>
                            <a href="#">Luctus quam ultrices rutrum</a>
                        </li>
                        <li>
                            <a href="#" title="Fusce id molestie massa">
                                <img src="themes/images/ladies/3.jpg" alt="Fusce id molestie massa">
                            </a>
                            <a href="#">Fusce id molestie massa</a>
                        </li>   
                    </ul>
                </div>
            </div>
        </div>
    </section>			
    <jsp:include page="/jsp/common/footer.jsp"></jsp:include>
</div>
<script src="${pageContext.request.contextPath}/themes/js/common.js"></script>
<script>
    $(function () {
        $('#myTab a:first').tab('show');
        $('#myTab a').click(function (e) {
            e.preventDefault();
            $(this).tab('show');
        })
    })
    $(document).ready(function () {
        $('.thumbnail').fancybox({
            openEffect: 'none',
            closeEffect: 'none'
        });

        $('#myCarousel-2').carousel({
            interval: 2500
        });
    });
</script>
</body>
</html>