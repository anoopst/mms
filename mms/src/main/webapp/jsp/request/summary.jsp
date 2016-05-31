<%@ include file="/jsp/includes.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="div1" align="center">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
    	<tr><th scope="col" colspan="2" align="center" id="zebra-adventure">Request Summary</th></tr>
    </thead>
	<tbody>
	<tr>
		<td>Request No.</td>
		<td>${reqHead.requestId}</td>
	</tr>	
	<tr>
		<td>Date</td>
		<td>${reqHead.requestDate}</td>
	</tr>
	<tr>
		<td>Requested By</td>
		<td>${reqHead.requestor.name}</td>
	</tr>
	<tr>
		<td>Request Status</td>
		<td><b>${reqHead.status}</b></td>
	</tr>
	</tbody>	
</table>
<table>
<tfoot>
	<tr>
		<!-- <td><spring:url value="/request/{reqId}/cancel" var="cancel"><spring:param name="reqId" value="${reqHead.requestId}" /></spring:url><a
			href="${fn:escapeXml(cancel)}">Cancel</a></td> -->
		<c:if test="${!empty message}">
		<div id="message">${message}</div>
		<script>
			showmessage('#message','Request status');
		</script>
		</c:if>
		
		<sec:authorize access="hasAnyRole('Admin','Requestor')">
		<c:if test="${reqHead.status != 'Requested'}">
		<td><spring:url value="/request/{reqId}/item/search1" var="addItem">
			<spring:param name="reqId" value="${reqHead.requestId}" />
		</spring:url> <a href="javascript:submitURL('${fn:escapeXml(addItem)}')">Add Item to Request	</a></td>		
		<c:if test="${!empty reqHead.requestDetail}"><td><spring:url value="/request/{reqId}/save" var="save"><spring:param name="reqId" value="${reqHead.requestId}" /></spring:url><a
			href="javascript:submitURL('${fn:escapeXml(save)}')">Submit	</a></td></c:if>			
		</c:if>
		</sec:authorize>
		
		<sec:authorize access="hasAnyRole('Admin','Approver')">
		<c:if test="${reqHead.status != 'Approved'}">		
		<c:if test="${!empty reqHead.requestDetail}"><td><spring:url value="/request/{reqId}/approve" var="approve"><spring:param name="reqId" value="${reqHead.requestId}" /></spring:url><a
			href="javascript:submitURL('${fn:escapeXml(approve)}')">Approve	</a></td></c:if>
		</c:if>
		</sec:authorize>
		
		<td></td>
	</tr>
	</tfoot>
</table>
</div>

<c:if test="${!empty reqHead.requestDetail}">
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
		<c:forEach var="reqItem" items="${reqHead.requestDetail}">
			<tr>
				<td nowrap="nowrap">${reqItem.item.name}</td>
				<td>${reqItem.qty}</td>
				<td><sec:authorize access="hasAnyRole('Admin','Requestor')"><spring:url value="/request/{reqId}/item/{itemId}/edit"
					var="editItem">
					<spring:param name="reqId" value="${reqHead.requestId}" />
					<spring:param name="itemId" value="${reqItem.item.id}" />
				</spring:url> <a href="javascript:submitURL('${fn:escapeXml(editItem)}')">Modify</a> <!--/ <spring:url
					value="/request/{reqId}/item/{itemId}/del" var="delItem">
					<spring:param name="reqId" value="${reqHead.requestId}" />
					<spring:param name="itemId" value="${reqItem.item.id}" />
				</spring:url> <a href="${fn:escapeXml(delItem)}">Delete</a>--> / </sec:authorize> <a href="javascript:showHistory(${reqItem.item.id})">History</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</c:if>