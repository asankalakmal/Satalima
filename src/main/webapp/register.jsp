<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="head.jsp"%>
	</head>
    <body>		
		<%@ include file="header.jsp"%>
		<div id="wrapper" class="container">
			<%@ include file="menu.jsp"%>		
			<section class="header_text sub">
			<img class="pageBanner" src="themes/images/pageBanner.png" alt="New products" >
				<h4><span>Login or Regsiter</span></h4>
			</section>			
			<section class="main-content">				
				<div class="row">
					<div class="span5">					
						<h4 class="title"><span class="text"><strong>Login</strong> Form</span></h4>
						<form action="#" method="post">
							<input type="hidden" name="next" value="/">
							<fieldset>
                                                            
								<div class="control-group">
									<label class="control-label">Username</label>
									<div class="controls">
										<input type="text" placeholder="Enter your username" name="userCode" id="userCode" class="input-xlarge">
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
										<input type="radio" name="userType" class="input-xlarge" value="1">
									</div>
                                                                <label class="control-label">I am a Seller</label>
                                                                
                                                                <div class="controls">
										<input type="radio" name="userType" class="input-xlarge" value="0">
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
			<section id="footer-bar">
				<div class="row">
					<div class="span3">
						<h4>Navigation</h4>
						<ul class="nav">
							<li><a href="./index.html">Homepage</a></li>  
							<li><a href="./about.html">About Us</a></li>
							<li><a href="./contact.html">Contac Us</a></li>
							<li><a href="./cart.html">Your Cart</a></li>
							<li><a href="./register.html">Login</a></li>							
						</ul>					
					</div>
					<div class="span4">
						<h4>My Account</h4>
						<ul class="nav">
							<li><a href="#">My Account</a></li>
							<li><a href="#">Order History</a></li>
							<li><a href="#">Wish List</a></li>
							<li><a href="#">Newsletter</a></li>
						</ul>
					</div>
					<div class="span5">
						<p class="logo"><img src="themes/images/logo.png" class="site_logo" alt=""></p>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. the  Lorem Ipsum has been the industry's standard dummy text ever since the you.</p>
						<br/>
						<span class="social_icons">
							<a class="facebook" href="#">Facebook</a>
							<a class="twitter" href="#">Twitter</a>
							<a class="skype" href="#">Skype</a>
							<a class="vimeo" href="#">Vimeo</a>
						</span>
					</div>					
				</div>	
			</section>
			<section id="copyright">
				<span>Copyright 2013 bootstrappage template  All right reserved.</span>
			</section>
		</div>
		<script src="themes/js/common.js"></script>
		<script>
			$(document).ready(function() {
				$('#checkout').click(function (e) {
					document.location.href = "checkout.html";
				})
			});
		</script>		
    </body>
</html>