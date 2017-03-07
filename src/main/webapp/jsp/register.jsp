<jsp:include page="/jsp/common/header.jsp"></jsp:include>
    <div id="wrapper" class="container">
    <jsp:include page="/jsp/common/menu.jsp"></jsp:include>		
        <section class="header_text sub">
            <img class="pageBanner" src="themes/images/pageBanner.png" alt="New products" >
            <h4><span>Login or Regsiter</span></h4>
        </section>			
        <section class="main-content">				
            <div class="row">
                <div class="span5">					
                    <h4 class="title"><span class="text"><strong>Login</strong> Form</span></h4>
                    <form action="LoginServlet" method="post">
                        <input type="hidden" name="next" value="/">
                        <fieldset>

                            <div class="control-group">
                                <label class="control-label">Username</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your username" name="username" id="userCode" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Username</label>
                                <div class="controls">
                                    <input type="password" placeholder="Enter your password" id="password" name="password" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <input tabindex="3" class="btn btn-inverse large" type="submit" value="Sign into your account">
                                <hr>
                                <p class="reset">Recover your <a tabindex="4" href="#" title="Recover your username or password">username or password</a></p>
                            </div>
                        </fieldset>
                    </form>				
                </div>
                <div class="span7">					
                    <h4 class="title"><span class="text"><strong>Register</strong> Form</span></h4>
                    <form action="SignupServlet" method="post" class="form-stacked">
                        <fieldset>
                            <div class="control-group">

                                <div class="controls">
                                    <input type="radio" name="userType" class="input-xlarge" value="2">
                                </div>
                                <label class="control-label">I am a Seller</label>

                                <div class="controls">
                                    <input type="radio" name="userType" class="input-xlarge" value="1">
                                </div>
                                <label class="control-label">I am a Buyer</label>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Username</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your username" name="userCode" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">First Name:</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your First name" name="firstName" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Last Name:</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your last name" name="lastName" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Email address:</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your email" name="email" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Phone:</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your phone" name="phone" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Country</label>
                                <div class="controls">
                                    <input type="text" placeholder="Enter your country" name="country" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Password:</label>
                                <div class="controls">
                                    <input type="password" placeholder="Enter your password" name="password" class="input-xlarge">
                                </div>
                            </div>	
                            <div class="control-group">
                                <label class="control-label">Confirm Password:</label>
                                <div class="controls">
                                    <input type="password" placeholder="Enter your password" name="confirmPassword" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <p>Now that we know who you are. I'm not a mistake! In a comic, you know how you can tell who the arch-villain's going to be?</p>
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
    });
</script>		
</body>
</html>