<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"  session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>Insert title here</title>


<script type="text/javascript">
$(document).ready(function() {
    /* $('.header').scrollToFixed(); */
    $('[data-toggle="tooltip"]').tooltip();
    $('.toltip').tooltip({placement : 'bottom'});
});
</script>

<style type="text/css">
.header {
    background-color: #000000;
    color: #FFFFFF;
    height: 50px;
    padding: 10px;
    width: 100%;
}
</style>


</head>
<body>


<table style="width: 100%;" class="header">
<tr>
<td>
<a href="javascript:runEffect();" title="Menu" class="toltip"><img src="<c:url value='/resources/img/icons/white/menu-icon.png'/>" width="30px"></a>

<%--    <a href="${pageContext.request.contextPath}/loadJasper">User Report</a> --%>
   

</td><td align="right">

  <c:url value="/j_spring_security_logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
Welcome : ${pageContext.request.userPrincipal.name} | 
	<a href="javascript:document.getElementById('logout').submit()" title="Logout" class="toltip"><img src="<c:url value='/resources/img/icons/white/on-off_icon&16.png' />"> </a>
</c:if>


</td>
</tr>
</table>




</body>
</html>