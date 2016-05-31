<%@ include file="/jsp/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<spring:url value="/item/getitem" var="submitVal"/>
	
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#search").button();
});
</script>	
<div id="div1" align="center"><form:form id="searchItem" name="searchItem" modelAttribute="itemForm"
	method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
		<tr>
			<th scope="col" colspan="2" align="center" id="zebra-adventure">Item Search</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Name</td>
			<td><form:input path="name" /><form:errors path="name" /></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td align="center" colspan="2">	<button id="search" name="search" type="button" onclick="submitForm('${fn:escapeXml(submitVal)}','searchItem')">Search</button></td>
		</tr>
	</tfoot>
	</table>
</form:form></div>

<c:if test="${!empty itemsList}">
	<div id="div2" align="center">
<table id="gradient-style">		
<thead>
<tr>
	<th scope="col">Item No</th>
	<th scope="col">Item Name</th>
	<th scope="col">Category</th>
	<th scope="col">Heading</th>
	<th scope="col">Sub Heading</th>
	<th scope="col">Model</th>
	<th scope="col">Brand</th>
	<th scope="col">Dimension</th>
	<th></th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${itemsList}">
<tr>
	<td>${item.id}</td>
	<td>${item.name}</td>
	<td>${item.mmCategory.name}</td>
	<td>${item.mmHeading.name}</td>
	<td>${item.mmSubheading.name}</td>
	<td>${item.mmModel.name}</td>
	<td>${item.mmBrand.name}</td>
	<td>${item.mmDimension.name}</td>
	<td><spring:url value="/item/modify/{id}"
					var="editItem">					
					<spring:param name="id" value="${item.id}" />
				</spring:url> <a href="javascript:submitURL('${fn:escapeXml(editItem)}')">Modify</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</c:if>