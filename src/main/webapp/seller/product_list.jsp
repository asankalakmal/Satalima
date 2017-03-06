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
				<h4><span>Product List</span></h4>
			</section>			
			<section class="main-content">				
				<div class="row">
								
				</div>
			</section>			
			<%@ include file="footer.jsp"%>
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