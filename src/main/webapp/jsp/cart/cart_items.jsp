<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Remove</th>
                                    <th>Image</th>
                                    <th>Product Name</th>
                                    <th>Quantity</th>
                                    <th>Unit Price</th>
                                    <th>Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${cart.cartItems}" varStatus="index">
                                <tr>
                                    <td>
                                        <button type="button" class="btn btn-danger btn-lg" id="removeItem_${index.index}" onclick="removeCartItem(${index.index})"><span class="glyphicon glyphicon-remove"></span></button>
                                    </td>
                                    <td><a href="${pageContext.request.contextPath}/ViewProduct?productIndex=${item.productIndex}">
                                            <img alt="" src="themes/images/ladies/9.jpg"></a>
                                    </td>
                                    <td>${item.product.name}</td>
                                    <td><input type="text" value="${item.quantity}" class="input-mini" id="item_quantity-${index.index}"></td>
                                    <td>$${item.product.unitPrice}</td>
                                    <td>$${item.amount}</td>
                                </tr>
                                </c:forEach>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td><strong>$${cart.totalPrice}</strong></td>
                                </tr>		  
                            </tbody>
                        </table>
           
                        <hr>
                        <p class="cart-total right">
                            <strong>Sub-Total</strong>:	$${cart.totalPrice}<br>
                            <strong>Admin Fee</strong>: $${cart.adminFee}<br>
                           <strong>Total</strong>: $${cart.cartTotal}<br>
                        </p>