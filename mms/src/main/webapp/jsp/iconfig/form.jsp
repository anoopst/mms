<%@ include file="/jsp/includes.jsp"%>

<spring:url value="${submitVal}" var="submitVal" />

<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#save").button();
	jQuery("#iconfig").validate({
		rules: {
			name: {
			required: true,
			minlength: 2
			}
		},
		messages: {
			name: {
			required: "Please enter name",
			minlength: "name must consist of at least 2 characters"
			}			
		},
		submitHandler: function(){
								//jQuery("#name").val(jQuery("#name").val().toLowerCase());
								submitForm('${fn:escapeXml(submitVal)}','iconfig');
								} 
	});
});
</script>
<div id="div" align="center">
<form:form id="iconfig" modelAttribute="conobject" method="post"
			 action="${submitVal}">
<c:if test="${!empty message}">
		<div id="message">${message}</div>
		<script>
			showmessage('#message','<fmt:message key="${config}"/> saved successfully');
		</script>
</c:if>			 
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
	<thead>
	<tr>
		<th scope="col" colspan="2" align="center" id="zebra-adventure">Add/Edit <fmt:message key="${config}"/></th>
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
		<td align="center" colspan="2"><button id="save" name="save" type="submit">Save</button></td>
	</tr>
	</tfoot>
</table>
</form:form>
</div>

