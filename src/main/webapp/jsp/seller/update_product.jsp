<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>
    <jsp:include page="/jsp/common/messages.jsp"></jsp:include>
        <section class="header_text sub">
            <h2><span>Update Product</span></h2>
        </section>			
        <section class="main-content">				
            <div class="row">
                <div class="span11">
                    <form action="${pageContext.request.contextPath}/UpdateProduct" method="post">
                        <input type="hidden" name="next" value="/">
                        <input type="hidden" name="id" value="${product.id}"/>
                        <fieldset>
                            <div class="control-group">
                                <label class="control-label">Name</label>
                                <div class="controls">
                                    <input type="text" value="${product.name}" name="name" id="name" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Description</label>
                                <div class="controls">
                                    <input type="text" value="${product.description}" id="description" name="description" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Unit Price</label>
                                <div class="controls">
                                    <input type="text" value="${product.unitPrice}" id="unitPrice" name="unitPrice" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Quantity</label>
                                <div class="controls">
                                    <input type="text" value="${product.quantity}" id="quantity" name="quantity" class="input-xlarge">
                                </div>
                            </div>
                  
                            <div class="control-group">
                                <input tabindex="3" class="btn btn-inverse large" type="submit" value="Update Product">
                            </div>
                        </fieldset>
                    </form>
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
