<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>
        <section  class="homepage-slider" id="home-slider">
            <div class="flexslider">
                <ul class="slides">
                    <li>
                        <img src="${pageContext.request.contextPath}/themes/images/carousel/banner-1.jpg" alt="" />
                </li>
                <li>
                    <img src="${pageContext.request.contextPath}/themes/images/carousel/banner-2.jpg" alt="" />
                    <div class="intro">
                        <h1>Mid season sale</h1>
                        <p><span>Up to 50% Off</span></p>
                        <p><span>On selected items online and in stores</span></p>
                    </div>
                </li>
            </ul>
        </div>			
    </section>
    <section class="header_text">
    </section>
    <section class="main-content">
        <div class="row">
            <div class="span12">													
                <div class="row">
                    <div class="span12">
                        <h4 class="title">
                            <span class="pull-left"><span class="text"><span class="line">On-going <strong>Bids</strong></span></span></span>
                            <span class="pull-right">
                                <a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
                            </span>
                        </h4>
                        <div id="myCarousel" class="myCarousel carousel slide">
                            <div class="carousel-inner">
                                <div class="active item">
                                    <ul class="thumbnails">												
                                        <li class="span3">
                                            <div class="product-box">
                                                <span class="sale_tag"></span>
                                                <p><a href="product_detail.html"><img src="${pageContext.request.contextPath}/themes/images/ladies/1.jpg" alt="" /></a></p>
                                                <a href="product_detail.html" class="title">Ut wisi enim ad</a><br/>
                                                <a href="products.html" class="category">Commodo consequat</a>
                                                <p class="price">$17.25</p>
                                            </div>
                                        </li>
                                       
                                    </ul>
                                </div>
                                <div class="item">
                                    <c:forEach var="product" items="${availableProductList}">
                                        <ul class="thumbnails">
                                        <li class="span3">
                                            <div class="product-box">
                                                <p><a href="product_detail.html"><img src="${pageContext.request.contextPath}/themes/images/ladies/5.jpg" alt="" /></a></p>
                                                <a href="product_detail.html" class="title">Know exactly</a><br/>
                                                <a href="products.html" class="category">Quis nostrud</a>
                                                <p class="price">$22.30</p>
                                            </div>
                                        </li>                                        
                         																																
                                    </ul>
                                    </c:forEach>
                                    
                                </div>
                            </div>							
                        </div>
                    </div>						
                </div>
                <br/>
                <div class="row">
                    <div class="span12">
                        <h4 class="title">
                            <span class="pull-left"><span class="text"><span class="line">Latest <strong>Products</strong></span></span></span>
                            <span class="pull-right">
                                <a class="left button" href="#myCarousel-2" data-slide="prev"></a><a class="right button" href="#myCarousel-2" data-slide="next"></a>
                            </span>
                        </h4>
                        <div id="myCarousel-2" class="myCarousel carousel slide">
                            <div class="carousel-inner">
                                <div class="active item">
                                    <ul class="thumbnails">	
                                        <c:forEach var="product" items="${availableProductList}" varStatus="index">
                                        <li class="span3">
                                            <div class="product-box">
                                                <span class="sale_tag"></span>
                                                <p><a href="${pageContext.request.contextPath}/ViewProduct?productIndex=${index.index}"><img src="${pageContext.request.contextPath}/themes/images/cloth/bootstrap-women-ware2.jpg" alt="" /></a></p>
                                                <a href="${pageContext.request.contextPath}/ViewProduct?productIndex=${index.index}" class="title">Ut wisi enim ad</a><br/>
                                                <a href="products.html" class="category">Commodo consequat</a>
                                                <p class="price">$25.50</p>
                                            </div>
                                        </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div class="item">
                                    <ul class="thumbnails">
                                        <li class="span3">
                                            <div class="product-box">
                                                <p><a href="product_detail.html"><img src="${pageContext.request.contextPath}/themes/images/cloth/bootstrap-women-ware4.jpg" alt="" /></a></p>
                                                <a href="product_detail.html" class="title">Know exactly</a><br/>
                                                <a href="products.html" class="category">Quis nostrud</a>
                                                <p class="price">$45.50</p>
                                            </div>
                                        </li>                                       																																
                                    </ul>
                                </div>
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
<script src="${pageContext.request.contextPath}/themes/js/jquery.flexslider-min.js"></script>
<script type="text/javascript">
    $(function () {
        $(document).ready(function () {
            $('.flexslider').flexslider({
                animation: "fade",
                slideshowSpeed: 4000,
                animationSpeed: 600,
                controlNav: false,
                directionNav: true,
                controlsContainer: ".flex-container" // the container that holds the flexslider
            });
        });
    });
</script>
</body>
</html>