<%@ include file="/jsp/includes.jsp"%>
<spring:url value="/vehicle/save" var="saveVehicle" />
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#save").button();
	jQuery("#vehicle").validate({
		rules: {
			name: {
			required: true,
			minlength: 4
			}
		},
		messages: {
			name: {
			required: "Please enter vehicle name",
			minlength: "vehicle must consist of at least 4 characters"
			}			
		},
		submitHandler: function(){jQuery("#name").val(jQuery("#name").val().toLowerCase()); submitForm('${fn:escapeXml(saveVehicle)}','vehicle');} 
	});
});
</script>
<div id="div" align="center">
<form:form id="vehicle" modelAttribute="vehicle" method="post" action="${fn:escapeXml(saveVehicle)}">
<c:if test="${!empty message}">
		<div id="message">${message}</div>
		<script>
			showmessage('#message','Vehicle saved successfully');
		</script>
	</c:if>
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
	<thead>
	<tr>
		<th scope="col" colspan="2" align="center" id="zebra-adventure">Vehicle Maintenance</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>Name </td>
		<td nowrap="nowrap"><form:hidden path="id" /><form:input path="name" /><form:errors path="name" /></td>
	</tr>
	</tbody>
	<tfoot>
	<tr>
		<td align="center" colspan="100">
			<button id="save" name="save" type="submit">Save</button>
		</td>
	</tr>
	</tfoot>
</table>
</form:form>
</div>

