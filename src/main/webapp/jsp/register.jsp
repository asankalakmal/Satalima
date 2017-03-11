<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>
    <jsp:include page="/jsp/common/messages.jsp"></jsp:include>
        <section class="header_text sub_title">
            <h2><span>Login / Regsiter</span></h2>
        </section>			
        <section class="main-content">				
            <div class="row">
                <div class="span5">					
                    <h4 class="title"><span class="text"><strong>Login</strong> Form</span></h4>
                    <form action="${pageContext.request.contextPath}/Login" method="post">
                        <input type="hidden" name="next" value="/">
                        <fieldset>

                            <div class="control-group">
                                <label class="control-label">Username</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your username" name="username" id="userCode" class="input-xlarge" value="${username}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Password</label>
                                <div class="controls">
                                    <input type="password" placeholder="Enter your password" id="password" name="password" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <input tabindex="3" class="btn btn-inverse large" type="submit" value="Sign into your account">
                            </div>
                        </fieldset>
                    </form>				
                </div>
                <div class="span7">					
                    <h4 class="title"><span class="text"><strong>Register</strong> Form</span></h4>
                    <form action="${pageContext.request.contextPath}/Signup" method="post" class="form-stacked">
                        <fieldset>
                            <div class="control-group radiobtn">

                                <div class="controls">
                                    <input type="radio" name="userType" class="input-xlarge" value="2" ${userType=='2'?'checked':''}>
                                </div>
                                <label class="control-label">I am a Seller</label>

                                <div class="controls">
                                    <input type="radio" name="userType" class="input-xlarge" value="1" ${userType=='1'?'checked':''}>
                                </div>
                                <label class="control-label">I am a Buyer</label>
                            </div>
                            <div class="control-group">
                                <label class="control-label"><span class="required">*</span> Username</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your username" name="userCode" class="input-xlarge" value="${userCode}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"><span class="required">*</span> First Name:</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your First name" name="firstName" class="input-xlarge" value="${firstName}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"><span class="required">*</span> Last Name:</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your last name" name="lastName" class="input-xlarge" value="${lastName}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"> <span class="required">*</span> Email address:</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your email" name="email" class="input-xlarge" value="${email}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"><span class="required">*</span> Phone:</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your phone" name="phone" class="input-xlarge" value="${phone}">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"><span class="required">*</span> Country</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your country" name="country" class="input-xlarge" value="${country}">
                                </div>
                            </div>
                            <div class="control-group seller-field ${userType=='1' ? 'hide' : ''}">
                                <label class="control-label"><span class="required">*</span> Shop Name:</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your Shop Name" name="shopName" class="input-xlarge" value="${shopName}">
                                </div>
                            </div>
                            <div class="control-group seller-field ${userType=='1' ? 'hide' : ''}">
                                <label class="control-label"><span class="required">*</span> Description:</label>
                                <div class="controls">
                                    <textArea type="text" placeholder="Enter your Description" name="description" class="input-xlarge" value="${description}"></textarea>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"><span class="required">*</span> Password:</label>
                                <div class="controls">
                                    <input type="password" placeholder="Enter your password" name="password" class="input-xlarge">
                                </div>
                            </div>	
                            <div class="control-group">
                                <label class="control-label"><span class="required">*</span> Confirm Password:</label>
                                <div class="controls">
                                    <input type="password" placeholder="Enter your password" name="confirmPassword" class="input-xlarge">
                                </div>
                            </div>
                            <hr>
                            <div class="actions"><input tabindex="9" class="btn btn-inverse large" type="submit" value="Create your account"></div>
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
        
        $('input[type=radio][name=userType]').change(function() {
            if (this.value == 1) {
                $('.seller-field').hide();
            } else if (this.value == 2) {
                $('.seller-field').show();
            }
        });
    });
</script>		
</body>
</html>
