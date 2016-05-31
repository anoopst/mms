<%@ include file="/jsp/includes.jsp"%>
<link type="text/css" rel="stylesheet" href="/mms/js/style.css" />
<script type="text/javascript">
jQuery(function() {
	jQuery("#search").button();
});
</script>
<div id="div1" align="center">
<form:form id="vehicle" modelAttribute="vehicle" method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
	<tr>
		<th scope="col" colspan="2" align="center" id="zebra-adventure">Search Vehicle</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>Vehicle name<form:errors path="name" /></td>
		<td><form:input path="name" /></td>
	</tr>
	</tbody>
	<tfoot>
	<tr>	
		<td align="center" colspan="100">
			<button id="search" name="search" type="button" onclick="submitForm('<spring:url value="/vehicle/getvehicle"/>','vehicle')">Search</button>
		</td>
	</tr>
	</tfoot>
</table>
</form:form>
</div>
<c:if test="${!empty vehicles}">
	<div id="div2" align="center">
	<table id="gradient-style">
		<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Name</th>
		</tr>
		</thead>
		<c:forEach var="vehicle" items="${vehicles}">
			<tr>
				<td><spring:url value="/vehicle/modify/{vehicleId}" var="modifyUrl">
					<spring:param name="vehicleId" value="${vehicle.id}" />
				</spring:url><a href="javascript:submitURL('${fn:escapeXml(modifyUrl)}')">${vehicle.id}</a></td>
				<td>${vehicle.name}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</c:if>