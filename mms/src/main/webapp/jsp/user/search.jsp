<%@ include file="/jsp/includes.jsp"%>
<link type="text/css" rel="stylesheet" href="/mms/js/style.css" />
<script type="text/javascript">
jQuery(function() {
	jQuery("#search").button();
});
</script>
<div id="div1" align="center"><form:form id="user" modelAttribute="user"
	method="post">
	<table id="ver-zebra" width="100%">
		<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    	</colgroup>
    	<thead>
		<tr>
			<th scope="col" colspan="2" align="center" id="zebra-adventure">Search User</th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td>User name<form:errors path="name" /></td>
			<td><form:input path="name" /></td>
		</tr>
		</tbody>
		<tfoot>
		<tr>
			<td align="center" colspan="100">
			<button id="search" name="search" type="button" onclick="submitForm('<spring:url value="/user/getuser"/>','user')">Search</button>
			</td>
		</tr>
		</tfoot>
	</table>
</form:form></div>

<c:if test="${!empty users}">
	<div id="div2" align="center">
	<table id="gradient-style">
		<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Name</th>
			<th scope="col">Role</th>
		</tr>
		</thead>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><spring:url value="/user/modify/{UserId}" var="modifyUrl">
					<spring:param name="UserId" value="${user.id}" />
				</spring:url> <a href="javascript:submitURL('${fn:escapeXml(modifyUrl)}')">${user.id}</a></td>
				<td>${user.name}</td>
				<td>${user.role}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</c:if>