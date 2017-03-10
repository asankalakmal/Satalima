<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>
    <jsp:include page="/jsp/common/messages.jsp"></jsp:include>
        <section class="header_text sub">
            <h2><span>Add New Product</span></h2>
        </section>			
        <section class="main-content">				
            <div class="row">
                <div class="span11">
                    <form accept-charset="utf-8" enctype="multipart/form-data" action="${pageContext.request.contextPath}/AddProduct" method="post">
                        <input type="hidden" name="next" value="/">
                        <fieldset>

                            <div class="control-group">
                                <label class="control-label">Name</label>
                                <div class="controls">
                                    <input type="text" placeholder="Product Name" name="name" id="name" class="input-xlarge" value="${name}">
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label">Unit Price</label>
                                <div class="controls">
                                    <input type="text" placeholder="Unit Price" id="unitPrice" name="unitPrice" class="input-xlarge" value="${unitPrice}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Quantity</label>
                                <div class="controls">
                                    <input type="text" placeholder="Quantity" id="quantity" name="quantity" class="input-xlarge" value="${quantity}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Description</label>
                                <div class="controls">
                                    <textarea placeholder="Product Description" id="description" name="description" class="input-xlarge">${description}</textarea>
                                </div>
                            </div>
                            <div class="control-group file-upload">
                                <label class="control-label">Product Image</label>
                                <div class="controls">
                                    <input type="file" placeholder="Quantity" id="quantity" name="productImage" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <input tabindex="3" class="btn btn-inverse large" type="submit" value="Add Product">
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
