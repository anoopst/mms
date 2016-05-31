<%@ include file="/jsp/includes.jsp"%>
<script type="text/javascript">
jQuery(function() {
	jQuery("#search").button();
});
</script>
<div id="div1" align="center">
<form:form modelAttribute="vendor" method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
    <tr>
		<th scope="col" colspan="2" align="center" id="zebra-adventure">Search Vendor</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>Vendor Name</td>
		<td><form:input path="name" /><form:errors path="name" /></td>
	</tr>
	</tbody>
	<tfoot>
	<tr>
		<td align="center" colspan="100">
			<button id="search" name="search" type="button" onclick="submitForm('<spring:url value="/vendor/getvendor"/>','vendor')">Search</button>
		</td>
	</tr>
	</tfoot>
</table>
</form:form>
</div>

<c:if test="${!empty vendorList}">
	<div id="div2" align="center">
	<table id="gradient-style">
		<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Name</th>
			<th scope="col">Role</th>
		</tr>
		</thead>
		<c:forEach var="vendor" items="${vendorList}">
			<tr>
				<td><spring:url value="/vendor/modify/{vendorId}" var="modifyUrl">
					<spring:param name="vendorId" value="${vendor.id}" />
				</spring:url><a href="javascript:submitURL('${fn:escapeXml(modifyUrl)}')">${vendor.id}</a></td>
				<td>${vendor.name}</td>
				<td>${vendor.venType}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</c:if>