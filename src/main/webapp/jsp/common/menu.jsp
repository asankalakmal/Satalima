<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.user.userType == 2}">
    <jsp:include page="/jsp/seller/menu.jsp"></jsp:include>
</c:if>
<c:if test="${sessionScope.user.userType != 2}">
    <jsp:include page="/jsp/buyer/menu.jsp"></jsp:include>
</c:if>