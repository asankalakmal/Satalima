<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>		
        <section class="header_text sub">
            <img class="pageBanner" src="${pageContext.request.contextPath}/themes/images/pageBanner.png" alt="New products" >
        <h4><span>Product List</span></h4>
    </section>			
    <section class="main-content">				
        <div class="row">
<div class="span9">					
                        <h4 class="title"><span class="text">Product <strong>List</strong></span></h4>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Remove</th>
                                    <th>Product Name</th>
                                    <th>Image</th>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>Unit Price</th>
                                    <th>Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="product" items="${productList}" varStatus="index">
                                <tr class='clickable-row' data-href='${pageContext.request.contextPath}/UpdateProduct?productId=${product.id}'>
                                    <td>
                                        <button type="button" class="btn btn-danger btn-lg" id="removeItem_${index.index}" onclick="removeCartItem(${index.index})"><span class="glyphicon glyphicon-remove"></span></button>
                                    </td>
                                    <td>${product.name}</td>
                                    <td></td>
                                    <td>${product.description}</td>
                                    <td><fmt:formatNumber value="${product.unitPrice}" type="currency"/></td>
                                    <td>${product.quantity}</td>
                            
                                </tr>
                                </c:forEach>
                   	  
                            </tbody>
                        </table>
           
                       					
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