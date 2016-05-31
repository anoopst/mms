<%@ include file="/jsp/includes.jsp"%>

<div id="div1" align="center">
<h2 style="background: #b9c9fe url('/mms/js/table-images/gradhead.png') repeat-x;width: 480px;">PO List</h2>
<c:if test="${!empty poList}">
<table id="gradient-style">
	<thead>
	<tr>
		<th scope="col">PO No</th>
		<th scope="col">Date</th>
		<th scope="col">Request No</th>
		<th scope="col">Requested By</th>
		<th scope="col">PO Status</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="po" items="${poList}">
	<tr>
		<td><spring:url value="/gr/draft?poNo={poId}" var="poID">
			<spring:param name="poId" value="${po.poNo}" />
			</spring:url> <a href="javascript:submitURL('${fn:escapeXml(poID)}')">${po.poNo}</a></td>
		<td>${po.poDate}</td>
		<td>${po.reqHeader.requestId}</td>
		<td>${po.reqHeader.requestor.name}</td>
		<td>${po.status}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>
</div>