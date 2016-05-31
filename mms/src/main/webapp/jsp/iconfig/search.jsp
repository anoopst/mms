<%@ include file="/jsp/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<spring:url value="/iconfig/geticonfig/{id}" var="submitVal">
	<spring:param name="id" value="${ConfigId}" />
</spring:url>	
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#search").button();
});
</script>
<div id="div1" align="center"><form:form id="ConfigForm" name="ConfigForm" modelAttribute="conobject"
	method="post">
	<table id="ver-zebra" width="100%">
		<colgroup>
    		<col class="vzebra-odd" />
    		<col class="vzebra-even" />    	
    	</colgroup>
    	<thead>
		<tr>
			<th colspan="2" align="center" id="zebra-adventure">Search <fmt:message key="${config}"/></th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td><fmt:message key="${config}"/> Name</td>
			<td nowrap="nowrap"><form:input path="name" /><form:errors path="name" /></td>
		</tr>
		</tbody>
		<tfoot>
		<tr>
			<td align="center" colspan="2">
			<button id="search" name="search" type="button" onclick="submitForm('${fn:escapeXml(submitVal)}','ConfigForm')">Search</button>
			</td>
		</tr>
		</tfoot>
	</table>
</form:form></div>

<c:if test="${!empty configlist}">
	<div id="div2" align="center">
	<table id="gradient-style">
		<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Name</th>
		</tr>			
		</thead>
		<tbody>
		<c:forEach var="configItem" items="${configlist}">
			<tr>
				<td><spring:url value="/iconfig/modify/{configId}/{itemId}" var="modifyUrl">
					<spring:param name="configId" value="${ConfigId}" />
					<spring:param name="itemId" value="${configItem.id}" />
				</spring:url> <a href="javascript:submitURL('${fn:escapeXml(modifyUrl)}')">${configItem.id}</a></td>
				<td>${configItem.name}</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</c:if>