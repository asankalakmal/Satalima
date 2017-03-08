<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>		
        <section class="header_text sub">
            <img class="pageBanner" src="themes/images/pageBanner.png" alt="New products" >
            <h4><span>Add New Product</span></h4>
        </section>			
        <section class="main-content">				
            <div class="row">
                <div class="span11">
                <form action="AddProduct" method="post">
                    <input type="hidden" name="next" value="/">
                    <fieldset>

                        <div class="control-group">
                            <label class="control-label">Name</label>
                            <div class="controls">
                                <input type="text" placeholder="Product Name" name="name" id="name" class="input-xlarge">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Description</label>
                            <div class="controls">
                                <input type="text" placeholder="Product Description" id="description" name="description" class="input-xlarge">
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