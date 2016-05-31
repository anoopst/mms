<%@ include file="/jsp/includes.jsp"%>
<spring:url value="/gr/new" var="submitVal" />
<script type="text/javascript">
jQuery(document).ready(function() {	
	jQuery("#sub1").button();
});
</script>
<div id="div1" align="center">
<form:form id="grHead" modelAttribute="grHead"
			method="post" action="${fn:escapeXml(submitVal)}">
	<form:hidden path="grNo"/><form:errors path="grNo"/>
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
    	<tr><th scope="col" colspan="2" align="center" id="zebra-adventure">Goods Receipt</th></tr>
    </thead>
	<tbody>
	<tr>
		<td>Receipt Date</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${grHead.grDate}"/></td>
	</tr>
	<tr>
		<td>PO No.</td>
		<td><form:hidden path="poHeader.poNo"/>${grHead.poHeader.poNo}</td>
	</tr>	
	<tr>
		<td>Vendor</td>
		<td>${grHead.poHeader.vendor.name}</td>
	</tr>
	</tbody>
	<tfoot>
		<tr><td align="center" colspan="2"><button id="sub1" name="sub1" type="button" onclick="submitForm('${fn:escapeXml(submitVal)}','grHead')">Submit</button></td></tr>		
	</tfoot>	
</table>
<table>

</table>

<div id="div2" align="center">
	<h2 align="center">Receipt Details</h2>
	<table id="gradient-style">		
		<thead>
			<tr>
			<th scope="col">Item Name</th>
			<th scope="col">Pending from PO</th>			
			<th scope="col">Quantity</th>			
			</tr>
		</thead>
		<tbody>
		<c:forEach var="grItem" items="${grHead.grDetails}" varStatus="status">
			<tr>
				<td><form:hidden path="grDetails[${status.index}].grdNo"/><form:hidden path="grDetails[${status.index}].item.id"/><form:hidden path="grDetails[${status.index}].item.name"/>${grItem.item.name}</td>				
				<td><form:input path="grDetails[${status.index}].poQty" disabled="true"/></td>
				<td><form:input path="grDetails[${status.index}].grdQty"/><form:errors path="grDetails[${status.index}].grdQty"/></td>				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</form:form>
</div>