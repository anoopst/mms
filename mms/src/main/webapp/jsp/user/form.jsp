<%@ include file="/jsp/includes.jsp"%>
<spring:url value="/user/save" var="saveUser" />
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#save").button();
	jQuery("#user").validate({
		rules: {
			name: {
			required: true,
			minlength: 2
			}
		},
		messages: {
			name: {
			required: "Please enter name",
			minlength: "username must consist of at least 2 characters"
			}			
		},
		submitHandler: function(){
								//jQuery("#name").val(jQuery("#name").val().toLowerCase()); 
								submitForm('${fn:escapeXml(saveUser)}','user');
								} 
	});
});
</script>
<div id="div" align="center">	
	<form:form id="user" modelAttribute="user" method="post">		
	<c:if test="${!empty message}">
		<div id="message">${message}</div>
		<script>
			showmessage('#message','User Created/Modified Successfully');
		</script>
	</c:if>
	<table id="ver-zebra" width="100%">
		<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    	</colgroup>
		<thead>
			<tr>
				<th scope="col" colspan="2" align="center" id="zebra-adventure">User Maintenance</th>								
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Name </td>
				<td nowrap="nowrap"><form:hidden path="id" /><form:input path="name" cssClass="required" disabled="${disable}"/><form:errors path="name"/></td>
			</tr>
			<tr>
				<td>Role </td>
				<td nowrap="nowrap"><form:select path="role" items="${roles}" /><form:errors path="role" /></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td align="center" colspan="2">
				<button id="save" name="save" type="submit">Save</button>
				</td>
			</tr>
		</tfoot>
	</table>
</form:form></div>

