<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.user.userType} == 3">
    <%@ include file="seller/menu.jsp"%>  
</c:if>
<c:if test="${sessionScope.user.userType} == 2">
    <%@ include file="seller/menu.jsp"%>   
</c:if>
<c:if test="${sessionScope.user.userType} == 1">
    <%@ include file="buyer/menu.jsp"%>   
</c:if>