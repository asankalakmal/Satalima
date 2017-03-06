<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../head.jsp"%>
	</head>
    <body>		
		<%@ include file="../header.jsp"%>
		<div id="wrapper" class="container">
			<%@ include file="../menu.jsp"%>		
			<section class="header_text sub">
			<img class="pageBanner" src="themes/images/pageBanner.png" alt="New products" >
				<h4><span>Add New Product</span></h4>
			</section>			
			<section class="main-content">				
				<div class="row">
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
			</section>			
			<%@ include file="../footer.jsp"%>
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