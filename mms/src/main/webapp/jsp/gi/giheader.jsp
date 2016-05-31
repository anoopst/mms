<%@ include file="/jsp/includes.jsp"%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags"
	prefix="ajax"%>
		
<link type="text/css" rel="stylesheet" href="/mms/js/style.css" />
<script type="text/javascript">
jQuery(function() {
	jQuery("#next").button();		
	jQuery("#gihDate").datepicker();
});


</script>
<div id="div" align="center">
<form:form id="giHead" modelAttribute="giHead"
			method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
	<thead>
	<tr>
		<th scope="col" colspan="2" align="center" id="zebra-adventure">Goods Issue Screen</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>Name <form:errors path="user.name" /></td>
		<td><form:hidden path="gihNo" /><form:hidden path="user.id" /><form:input path="user.name" /></td>
	</tr>
	<tr>
		<td>Vehicle <form:errors path="vehicle.name" /></td>
		<td><form:hidden path="vehicle.id" /><form:input path="vehicle.name" /></td>
	</tr>
	<tr>
		<td>Date <form:errors path="gihDate" /></td>
		<td><form:input path="gihDate" /><form:hidden path="status" /></td>
	</tr>
	</tbody>
	<tfoot>
	<tr>
		<td align="center" colspan="2"><button id="next" name="next" type="button" onclick="submitForm('<spring:url value="/gi/new"/>','giHead')">Next</button></td>
	</tr>
	</tfoot>
</table>
</form:form>
<ajax:autocomplete source="user.name" target="user.id"
	parameters="name={user.name}" baseUrl="/mms/user/autocomplt/"
	className="autocomplete1" minimumCharacters="1" />
<ajax:autocomplete source="vehicle.name" target="vehicle.id"
	parameters="name={vehicle.name}" baseUrl="/mms/vehicle/autocomplt/"
	className="autocomplete1" minimumCharacters="1" /></div>

