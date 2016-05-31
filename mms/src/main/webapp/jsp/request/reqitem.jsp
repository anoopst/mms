<%@ include file="/jsp/includes.jsp"%>
<spring:url value="/request/{reqId}/item/save" var="addItemReq">
<spring:param name="reqId" value="${reqItem.reqHeader.requestId}" />
</spring:url>
<style type="text/css">
<!--
@import url("/mms/js/style.css");
-->
</style>
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#save").button();
	jQuery("#reqItem").validate({
		rules: {
			qty : {
				required: true,
				number: true,
				min: 0.1
			}		
		},
		messages: {
			qty : {
				required: "please enter qty"				
			}
		},
		submitHandler: function(){
			submitForm('${fn:escapeXml(addItemReq)}','reqItem');
		}
	});	
});
</script>
<div id="div" align="center">
<form:form id="reqItem" modelAttribute="reqItem" method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
		<tr><th scope="col" colspan="2" align="center" id="zebra-adventure">Add Item to Request</th></tr>
	</thead>
	<tbody>
		<tr><td>Item Name<form:hidden path="rdNo" /><form:hidden path="reqHeader.requestId"/><form:hidden path="item.id"/></td><td><form:hidden path="item.name"/>${reqItem.item.name}</td></tr>	
		<tr><td>Category Name<form:hidden path="item.mmCategory.id" /><form:hidden path="item.mmCategory.name" /></td><td>${reqItem.item.mmCategory.name}</td></tr>
		<tr><td>Heading Name<form:hidden path="item.mmHeading.id" /><form:hidden path="item.mmHeading.name" /></td><td>${reqItem.item.mmHeading.name}</td></tr>
		<tr><td>Sub Headgin Name<form:hidden path="item.mmSubheading.id" /><form:hidden path="item.mmSubheading.name" /></td><td>${reqItem.item.mmSubheading.name}</td></tr>
		<tr><td>Model Name<form:hidden path="item.mmModel.id" /><form:hidden path="item.mmModel.name" /></td><td>${reqItem.item.mmModel.name}</td></tr>
		<tr><td>Brand Name<form:hidden path="item.mmBrand.id" /><form:hidden path="item.mmBrand.name" /></td><td>${reqItem.item.mmBrand.name}</td></tr>
		<tr><td>Dimension Name<form:hidden path="item.mmDimension.id" /><form:hidden path="item.mmDimension.name" /></td><td>${reqItem.item.mmDimension.name}</td></tr>
		<tr><td nowrap="nowrap">Quantity</td><td><form:input path="qty" /> ${reqItem.item.mmUom.name}</td></tr>
	</tbody>
	<tfoot>
		<tr>
		<td align="center" colspan="2">						
		<button id="save" name="save" type="submit">save</button>
		</td>
		</tr>
	</tfoot>		
</table>
</form:form>
</div>