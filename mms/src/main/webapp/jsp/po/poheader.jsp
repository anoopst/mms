<%@ include file="/jsp/includes.jsp"%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax"%>
<spring:url value="/po/new" var="submitVal" />
<style type="text/css">
<!--
@import url("/mms/js/style.css");
-->
</style>
<script type="text/javascript">
jQuery(document).ready(function() {	
	jQuery("#sub1").button();
});
</script>
<div id="div1" align="center">
<form:form id="poHead" modelAttribute="poHead"
			method="post" action="${fn:escapeXml(submitVal)}">
	<form:hidden path="poNo"/><form:errors path="poNo"/>
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
    	<tr><th scope="col" colspan="2" align="center" id="zebra-adventure">PO Summary</th></tr>
    </thead>
	<tbody>
	<tr>
		<td>PO Date</td>
		<td><fmt:formatDate value="${poHead.poDate}"/></td>
	</tr>
	<tr>
		<td>Request No.</td>
		<td><form:hidden path="reqHeader.requestId"/>${poHead.reqHeader.requestId}</td>
	</tr>	
	<tr>
		<td>Requested By</td>
		<td><form:hidden path="reqHeader.requestor.name"/>${poHead.reqHeader.requestor.name}</td>
	</tr>
	<tr>
		<td>Vendor</td>
		<td><form:hidden path="vendor.id"/><form:input path="vendor.name" /><form:errors path="vendor.name"/></td>
	</tr>
	<tr>
		<td>PO Type</td>
		<td><form:select path="type" items="${types}"/><form:errors path="type"/></td>
	</tr>
	</tbody>
	<tfoot>
		<tr><td align="center" colspan="2"><button id="sub1" name="sub1" type="button" onclick="javascript:submitForm('${fn:escapeXml(submitVal)}','poHead')">Submit</button></td></tr>
	</tfoot>	
</table>

<div id="div2" align="center">
	<h2 align="center">Request Details</h2>
	<table id="gradient-style">		
    <thead>
    <tr>		
		<th scope="col">Item Name</th>
		<th scope="col">Requested Quantity</th>
		<th scope="col">PO Quantity</th>
		<th scope="col">Rate</th>
		<th scope="col">Description</th>
		<th></th>			
	</tr>
	</thead>
	<tbody>
		<c:forEach var="poItem" items="${poHead.poDetails}" varStatus="status">
			<tr>
				<td nowrap="nowrap"><form:hidden path="poDetails[${status.index}].pdNo"/><a href="javascript:showHistory(${poItem.item.id})">${poItem.item.name}</a></td>
				<td nowrap="nowrap"><form:input path="poDetails[${status.index}].reqQty" disabled="true"/></td>
				<td nowrap="nowrap"><form:input path="poDetails[${status.index}].poQty"/></td>
				<td nowrap="nowrap"><form:input path="poDetails[${status.index}].poRate"/></td>
				<td nowrap="nowrap"><form:input path="poDetails[${status.index}].poDesc"/></td>
				<td nowrap="nowrap"><form:errors path="poDetails[${status.index}].poRate"/><form:errors path="poDetails[${status.index}].poQty"/><form:errors path="poDetails[${status.index}].poDesc"/></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	</div>
</form:form>
<ajax:autocomplete 
	source="vendor.name" 
	target="vendor.id"
	parameters="name={vendor.name}"
	baseUrl="/mms/vendor/autocomplt/" 
	className="autocomplete1"
	minimumCharacters="1" />
</div>