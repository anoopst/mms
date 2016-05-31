<%@ include file="/jsp/includes.jsp"%>
<%-- <spring:url value="/user/save" var="saveUser" />--%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags"
	prefix="ajax"%>
<script type="text/javascript">
jQuery(function() {
	jQuery("#next").button();		
	jQuery("#RequestDate").datepicker();
	jQuery("#reqHead").validate({
		rules: {
		"requestor.id": {
		required: true
		},
		"requestor.name": {
		required: true
		},
		RequestDate: {
		required: true
		}
	},
	messages: {
		"requestor.id": {
		required: "Please enter requestor name"		
		},
		"requestor.name": {
			required: "Please enter requestor name"		
		}
	},
	submitHandler: function(){
		submitForm('<spring:url value="/request/new"/>','reqHead');
	}
	});
});


</script>
<div id="div" align="center">
<form:form id="reqHead" modelAttribute="reqHead"
			method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
	<thead>
	<tr>
		<th scope="col" colspan="2" align="center" id="zebra-adventure">Requestion Screen</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>Requestor Name <form:errors path="requestor.name" /></td>
		<td><form:hidden path="requestId" /><form:hidden path="requestor.id" /><form:input path="requestor.name" /></td>
	</tr>
	<tr>
		<td>Date </td>
		<td><form:input path="RequestDate" /><form:hidden path="status" /><form:errors path="RequestDate" /></td>
	</tr>
	</tbody>
	<tfoot>
	<tr>
		<td align="center" colspan="2"><button id="next" name="next" type="submit">Next</button></td>
	</tr>
	</tfoot>
</table>
</form:form>
<ajax:autocomplete source="requestor.name" target="requestor.id"
	parameters="name={requestor.name}" baseUrl="/mms/user/autocomplt/"
	className="autocomplete1" minimumCharacters="1" /></div>

