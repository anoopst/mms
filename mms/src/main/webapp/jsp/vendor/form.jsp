<%@ include file="/jsp/includes.jsp"%>
<spring:url value="/vendor/save" var="saveVendor" />
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#save").button();
	jQuery("#vendor").validate({
		rules: {
			name: {
			required: true,
			minlength: 2
			},
			add1: {
			required: true,
			minlength: 2
			}
		},
		messages: {
			name: {
			required: "Please enter vendor name",
			minlength: "vendor must consist of at least 2 characters"
			},			
			add1: {
				required: "Please enter vendor address",
				minlength: "address must consist of at least 2 characters"
			}
		},
		submitHandler: function(){			
			//jQuery("#name").val(jQuery("#name").val().toLowerCase()); 
			submitForm('${fn:escapeXml(saveVendor)}','vendor');
		} 
	});
});
</script>	

<div id="div1" align="center">
<form:form id="vendor" modelAttribute="vendor" method="post">
<c:if test="${!empty message}">
		<div id="message">${message}</div>
		<script>
			showmessage('#message','Vendor saved successfully');
		</script>
	</c:if>
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
	<thead>
	<tr>
		<th scope="col" colspan="2" align="center" id="zebra-adventure">Vendor Maintenance</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td nowrap="nowrap">Name </td>
		<td nowrap="nowrap"><form:hidden path="id" /><form:input path="name" disabled="${disable}" /><form:errors path="name" /></td>
	</tr>
	<tr>
		<td nowrap="nowrap">Type </td>
		<td nowrap="nowrap"><form:select path="venType" items="${type}" /><form:errors path="venType" /></td>
	</tr>
		<tr>
		<td nowrap="nowrap">Address 1 </td>
		<td nowrap="nowrap"><form:input path="add1" /><form:errors path="add1" /></td>
	</tr>
	<tr>
		<td nowrap="nowrap">Address 2 </td>
		<td nowrap="nowrap"><form:input path="add2" /><form:errors path="add2" /></td>
	</tr>
	<tr>
		<td nowrap="nowrap">Address 3 </td>
		<td nowrap="nowrap"><form:input path="add3" /><form:errors path="add3" /></td>
	</tr>
	<tr>
		<td nowrap="nowrap">Address 4 </td>
		<td nowrap="nowrap"><form:input path="add4" /><form:errors path="add4" /></td>
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