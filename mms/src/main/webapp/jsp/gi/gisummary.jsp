<%@ include file="/jsp/includes.jsp"%>
<%@ page import="com.dv.mms.app.utils.Constants"  %>

<div id="div1" align="center">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
    	<tr><th scope="col" colspan="2" align="center" id="zebra-adventure">Goods Issue Summary</th></tr>
    </thead>
	<tbody>
	<tr>
		<td>Issue No.</td>
		<td>${giHead.gihNo}</td>
	</tr>	
	<tr>
		<td>Date</td>
		<td>${giHead.gihDate}</td>
	</tr>
	<tr>
		<td>Requested By</td>
		<td>${giHead.user.name}</td>
	</tr>
	<tr>
		<td>Vehice</td>
		<td>${giHead.vehicle.name}</td>
	</tr>
	</tbody>	
</table>
<c:if test="${giHead.status != 'Issued'}">
<table>
<tfoot>
	<tr>
		<!--  <td><spring:url value="/gi/{gihNo}/cancel" var="cancel"><spring:param name="gihNo" value="${giHead.gihNo}" /></spring:url><a
			href="${fn:escapeXml(cancel)}">Cancel</a></td> -->		
		<td><spring:url value="/gi/{gihNo}/item/search" var="addItem">
			<spring:param name="gihNo" value="${giHead.gihNo}" />
		</spring:url> <a href="javascript:submitURL('${fn:escapeXml(addItem)}')">Add Item</a></td>
		<td><spring:url value="/gi/{gihNo}/save" var="save"><spring:param name="gihNo" value="${giHead.gihNo}" /></spring:url><a
			href="javascript:submitURL('${fn:escapeXml(save)}')">Submit</a></td>		
		<td></td>
	</tr>
	</tfoot>
</table>
</c:if>
</div>

<c:if test="${!empty giHead.giDetails}">
	<div id="div2" align="center">
	<h2 align="center">Request Details</h2>
	<table id="gradient-style">		
		<thead>
			<tr>
			<th scope="col">Item Name</th>
			<th scope="col">Quantity</th>
			<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="giDetail" items="${giHead.giDetails}">
			<tr>
				<td>${giDetail.item.name}</td>
				<td>${giDetail.gidQty}</td>
				<td><c:if test="${giHead.status != 'Issued'}"><spring:url value="/gi/{gihNo}/item/{itemId}/edit"
					var="editItem">
					<spring:param name="reqId" value="${giHead.gihNo}" />
					<spring:param name="itemId" value="${giDetail.item.id}" />
				</spring:url> <a href="${fn:escapeXml(editItem)}">Modify</a></c:if><!--  / <spring:url
					value="/gi/{gihNo}/item/{itemId}/del" var="delItem">
					<spring:param name="gihNo" value="${giHead.gihNo}" />
					<spring:param name="itemId" value="${reqItem.item.id}" />
				</spring:url> <a href="${fn:escapeXml(delItem)}">Delete</a> --></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</c:if>