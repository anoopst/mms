<%@ include file="/jsp/includes.jsp"%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<spring:url value="/po/save" var="submitVal" />

<script type="text/javascript">
jQuery(document).ready(function() {	
	jQuery("#sub1").button();
	jQuery("#prnt1").button();
});
</script>
<div id="div1" align="center">
<form:form id="poHead" modelAttribute="poHead"
			method="post" action="${fn:escapeXml(submitVal)}">
	<form:errors path="*"/>
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
    	<tr><th scope="col" colspan="2" align="center" id="zebra-adventure">Purchase Order</th></tr>
    </thead>
	<tbody>
	<c:if test="${saved eq 'saved'}">
	<tr>
		<td>PO No.</td>
		<td>${poHead.poNo}</td>
	</tr>
	</c:if>
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
		<td><form:hidden path="vendor.id" />${poHead.vendor.name}<br>${poHead.vendor.add1}<br>${poHead.vendor.add2}<br>${poHead.vendor.add3}<br>${poHead.vendor.add4}</td>
	</tr>
	<tr>
		<td>PO Type</td>
		<td><form:hidden path="type" />${poHead.type}</td>
	</tr>
	</tbody>		
</table>

<div id="div2" align="center">	
	<table id="gradient-style">		
		<thead>
			<tr>
			<th scope="col">Item Name</th>			
			<th scope="col">Quantity</th>
			<th scope="col">Rate</th>
			<th scope="col">Amount</th>
			<th scope="col">Description</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="poItem" items="${poHead.poDetails}" varStatus="status">
			<tr>
				<td nowrap="nowrap"><form:hidden path="poDetails[${status.index}].pdNo"/><form:hidden path="poDetails[${status.index}].item.id"/>${poItem.item.name}</td>				
				<td><form:hidden path="poDetails[${status.index}].poQty"/>${poItem.poQty }</td>			
				<td><form:hidden path="poDetails[${status.index}].poRate"/>${poItem.poRate }</td>
				<td>${poItem.poQty * poItem.poRate }</td>
				<td><form:hidden path="poDetails[${status.index}].poDesc"/>${poItem.poDesc}</td>
			</tr>
		</c:forEach>
		</tbody>		
	</table>
</div>
<c:if test="${saved eq 'unsaved'}">
<table>
		<tr><td align="center"><button id="sub1" name="sub1" type="button" onclick="javascript:submitForm('${fn:escapeXml(submitVal)}','poHead')">Submit</button></td></tr>		
</table>
</c:if>
<c:if test="${saved eq 'saved'}">
<table>
		<tr><td align="center"><spring:url value="/report/PO/pdf?poNo={poId}" var="printVal">
			<spring:param name="poId" value="${poHead.poNo}" />
			</spring:url><button id="prnt1" name="prnt1" type="button" onclick="javascript:openReport('${fn:escapeXml(printVal)}','PO')">Print</button></td></tr>		
</table>
</c:if>
</form:form>
</div>