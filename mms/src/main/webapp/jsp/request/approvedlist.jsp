<%@ include file="/jsp/includes.jsp"%>
<style type="text/css">
<!--
@import url("/mms/js/style.css");
-->
</style>
<div id="div1" align="center">
<h2>Approved List</h2>
<c:if test="${!empty reqList}">
<table id="gradient-style">		
<thead>
<tr>
<th scope="col">Request No</th>
<th scope="col">Date</th>
<th scope="col">Requested By</th>
<th scope="col">Status</th>
</tr>
</thead>
<tbody>
<c:forEach var="req" items="${reqList}">
<tr>
<td><spring:url value="/po/draft?reqId={reqId}" var="draft">
		<spring:param name="reqId" value="${req.requestId}" />
	</spring:url> <a href="javascript:submitURL('${fn:escapeXml(draft)}')">${req.requestId}</a></td>
<td>${req.requestDate}</td>
<td>${req.requestor.name}</td>
<td>${req.status}</td>
</tr>
</c:forEach>
</tbody>
</table>
</c:if>
</div>