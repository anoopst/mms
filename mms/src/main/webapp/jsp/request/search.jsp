<%@ include file="/jsp/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<spring:url value="/request/getrequest" var="submitVal"/>
	
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#search").button();
	jQuery("#searchRequest").validate({
	rules: {
		requestId: {
		required: true
		}
	},
	messages: {
		requestId: {
		required: "please enter request id"
		}	
	},
	submitHandler: function(){
		submitForm('${fn:escapeXml(submitVal)}','searchRequest');
	}
	});
});
</script>	
<div id="div1" align="center"><form:form id="searchRequest" name="searchRequest" modelAttribute="reqHead"
	method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
		<tr>
			<th scope="col" colspan="2" align="center" id="zebra-adventure">Request Search</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Request No</td>
			<td><form:input path="requestId" /><form:errors path="requestId" /></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td align="center" colspan="2">	<button id="search" name="search" type="submit">Search</button></td>
		</tr>
	</tfoot>
	</table>
</form:form></div>

<c:if test="${req != null}">
	<div id="div2" align="center">
<table id="gradient-style">		
<thead>
<tr>
	<th scope="col">Request No</th>
	<th scope="col">Date</th>
	<th scope="col">Requestor</th>
	<th scope="col">Status</th>	
	<th></th>
</tr>
</thead>
<tbody>

<tr>
	<td>${req.requestId}</td>
	<td>${req.requestDate}</td>
	<td>${req.requestor.name}</td>
	<td>${req.status}</td>
	<td><c:if test="${(req.status eq 'Drafted') or (req.status eq 'Requested')}"><spring:url value="/request/{reqId}/id"
					var="editReq">					
					<spring:param name="reqId" value="${req.requestId}" />
				</spring:url> <a href="javascript:submitURL('${fn:escapeXml(editReq)}')">Modify</a></c:if></td>
</tr>

</tbody>
</table>
</div>
</c:if>