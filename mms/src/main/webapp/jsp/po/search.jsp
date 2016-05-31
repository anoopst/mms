<%@ include file="/jsp/includes.jsp"%>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax"%>
<spring:url value="/po/search" var="submitVal"/>
	
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#search").button();
	jQuery("#searchPO").validate({
	rules: {
		poNo: {
		number: true
		}
	},
	messages: {
		poNo: {
		number: "please enter valid po no"
		}	
	},
	submitHandler: function(){
		if(jQuery("poNo").val()!="" || jQuery("vendor.id")!="") {
			submitForm('${fn:escapeXml(submitVal)}','searchPO');
		}
	}
	});
});
</script>	
<div id="div" align="center">
<div id="div1" align="center"><form:form id="searchPO" name="searchPO" modelAttribute="poHead"
	method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
		<tr>
			<th scope="col" colspan="2" align="center" id="zebra-adventure">Search PO</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>PO No</td>
			<td><form:input path="poNo" /><form:errors path="poNo" /></td>
		</tr>
		<tr>
			<td>Vendor</td>
			<td><form:hidden path="vendor.id"/><form:input path="vendor.name" /><form:errors path="vendor.name" /></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td align="center" colspan="2">	<button id="search" name="search" type="submit">Search</button></td>
		</tr>
	</tfoot>
	</table>
</form:form></div>


<c:if test="${!empty poList}">
<div id="div2" align="center">
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
</div>
</c:if>

<ajax:autocomplete 
	source="vendor.name" 
	target="vendor.id"
	parameters="name={vendor.name}"
	baseUrl="/mms/vendor/autocomplt/" 
	className="autocomplete1"
	minimumCharacters="1" />
</div>	