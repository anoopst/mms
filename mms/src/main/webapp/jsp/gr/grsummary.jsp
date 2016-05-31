<%@ include file="/jsp/includes.jsp"%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<spring:url value="/gr/save" var="submitVal" />
<link type="text/css" rel="stylesheet" href="/mms/js/style.css" />
<script type="text/javascript">
jQuery(document).ready(function() {	
	jQuery("#sub1").button();
});
</script>
<div id="div1" align="center">
<form:form id="grHead" modelAttribute="grHead" method="post" action="${fn:escapeXml(submitVal)}">
	<form:errors path="*"/>
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
		<td><fmt:formatDate value="${grHead.grDate}"/></td>
	</tr>
	<tr>
		<td>PO No.</td>
		<td><form:hidden path="poHeader.poNo"/>${grHead.poHeader.poNo}</td>
	</tr>	
	<tr>
		<td>Vendor</td>
		<td>${grHead.poHeader.vendor.name}<br>${grHead.poHeader.vendor.add1}<br>${grHead.poHeader.vendor.add2}<br>${grHead.poHeader.vendor.add3}<br>${grHead.poHeader.vendor.add4}</td>
	</tr>
	</tbody>		
</table>

<div id="div2" align="center">	
	<table id="gradient-style">		
		<thead>
			<tr>
			<th scope="col">Item Name</th>			
			<th scope="col">Quantity</th>			
			</tr>
		</thead>
		<tbody>
		<c:forEach var="grItem" items="${grHead.grDetails}" varStatus="status">
			<tr>
				<td><form:hidden path="grDetails[${status.index}].grdNo"/><form:hidden path="grDetails[${status.index}].item.id"/>${grItem.item.name}</td>				
				<td><form:hidden path="grDetails[${status.index}].grdQty"/>${grItem.grdQty }</td>			
			</tr>
		</c:forEach>
		</tbody>		
	</table>
</div>
<c:if test="${saved eq 'unsaved'}">
<table>
		<tr><td align="center" colspan="2"><button id="sub1" name="sub1" type="button" onclick="submitForm('${fn:escapeXml(submitVal)}','grHead')">Submit</button></td></tr>		
</table>
</c:if>
</form:form>
</div>