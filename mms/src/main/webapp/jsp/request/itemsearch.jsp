<%@ include file="/jsp/includes.jsp"%>	
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags"
	prefix="ajax"%>
<spring:url value="/request/{reqId}/item/search" var="submitVal">
	<spring:param name="reqId" value="${reqId}" />
</spring:url>

<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#search").button();
});
</script>
<div id="div" align="center">
<form:form id="itemForm" modelAttribute="itemForm" method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
		<tr><th scope="col" colspan="2" align="center" id="zebra-adventure">Add/Edit Item</th></tr>
	</thead>
	<tbody>
	<tr>					
		<td>Item Name</td>
		<td><form:hidden path="id" /><form:input path="name" /><form:errors path="name" /></td>
	</tr>
	<tr>
		<td>Heading Name</td>
		<td><form:hidden path="mmHeading.id" /><form:input path="mmHeading.name" /><form:errors path="mmHeading.name" /></td>
	</tr>
	<tr>
		<td>Sub Heading Name</td>
		<td><form:hidden path="mmSubheading.id" /><form:input path="mmSubheading.name" /><form:errors path="mmSubheading.name" /></td>
	</tr>
	<tr>
		<td>Category</td>
		<td><form:hidden path="mmCategory.id" /><form:input	path="mmCategory.name" /><form:errors path="mmCategory.name" /></td>
	</tr>
	<tr>
		<td>Brand Name</td>
		<td><form:hidden path="mmBrand.id" /><form:input path="mmBrand.name" /><form:errors path="mmBrand.name" /></td>
	</tr>
	<tr>
		<td>Dimension Name</td>
		<td><form:hidden path="mmDimension.id" /><form:input path="mmDimension.name" /><form:errors path="mmDimension.name" /></td>
	</tr>
	<tr>
		<td>Model Name</td>
		<td><form:hidden path="mmModel.id" /><form:input path="mmModel.name" /><form:errors path="mmModel.name" /></td>
	</tr>
	<tr>
		<td>UOM</td>
		<td><form:hidden path="mmUom.id"/><form:input path="mmUom.name"/></td>
	</tr>
	</tbody>
	<tfoot>
	<tr><td align="center" colspan="2">	<button id="search" name="search" type="button" onclick="submitForm('${fn:escapeXml(submitVal)}','itemForm')">Search</button></td></tr>
	</tfoot>
</table>
</form:form>
<c:if test="${!empty itemFormList}">
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
<c:forEach var="item" items="${itemFormList}">
<tr>
	<td>${item.id}</td>
	<td>${item.name}</td>
	<td>${item.mmCategory.name}</td>
	<td>${item.mmHeading.name}</td>
	<td>${item.mmSubheading.name}</td>
	<td>${item.mmModel.name}</td>
	<td>${item.mmBrand.name}</td>
	<td>${item.mmDimension.name}</td>
	<td><spring:url value="/request/{reqId}/item/{itemId}/new"
					var="editItem">
					<spring:param name="reqId" value="${reqId}" />
					<spring:param name="itemId" value="${item.id}" />
				</spring:url> <a href="javascript:submitURL('${fn:escapeXml(editItem)}')">select</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</c:if>
<ajax:autocomplete 
	source="name" 
	target="id"	
	baseUrl="/mms/item/autocomplt/" 
	className="autocomplete1"
	minimumCharacters="1" />
	
<ajax:autocomplete 
	source="mmBrand.name" 
	target="mmBrand.id"
	parameters="name={mmBrand.name}"
	baseUrl="/mms/iconfig/autocomplt/1" 
	className="autocomplete1"
	minimumCharacters="1" />
	
<ajax:autocomplete 
	source="mmCategory.name" 
	target="mmCategory.id"
	parameters="name={mmCategory.name}"
	baseUrl="/mms/iconfig/autocomplt/2"
    className="autocomplete1"
	minimumCharacters="1" />

<ajax:autocomplete 
	source="mmDimension.name" 
	target="mmDimension.id"
	parameters="name={mmDimension.name}"
	baseUrl="/mms/iconfig/autocomplt/3" 
	className="autocomplete1"
	minimumCharacters="1" />

<ajax:autocomplete 
	source="mmHeading.name" 
	target="mmHeading.id"
	parameters="name={mmHeading.name}"
	baseUrl="/mms/iconfig/autocomplt/4" 
	className="autocomplete1"	
	minimumCharacters="1" />

<ajax:autocomplete 
	source="mmSubheading.name" 
	target="mmSubheading.id"
	parameters="name={mmSubheading.name}"
	baseUrl="/mms/iconfig/autocomplt/5" 
	className="autocomplete1"
	minimumCharacters="1" />

<ajax:autocomplete 
	source="mmUom.name" 
	target="mmUom.id"
	parameters="name={mmUom.name}"
	baseUrl="/mms/iconfig/autocomplt/6" 
	className="autocomplete1"
	minimumCharacters="1" />
	
<ajax:autocomplete 
	source="mmModel.name" 
	target="mmModel.id"
	parameters="name={mmModel.name}"
	baseUrl="/mms/iconfig/autocomplt/7" 
	className="autocomplete1"
	minimumCharacters="1" />				
</div>	