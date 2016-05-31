<%@ include file="/jsp/includes.jsp"%>
<spring:url value="/gi/{gihNo}/item/save" var="addItemReq">
<spring:param name="gihNo" value="${giItem.giHeader.gihNo}" />
</spring:url>
<link type="text/css" rel="stylesheet" href="/mms/js/style.css" />
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#save").button();
	jQuery("#giItem").validate({
		rules: {
		gidQty : {
				required: true,
				number: true,
				min: 0.1,
				max: ${giItem.item.stock}
			}		
		},
		messages: {
			gidQty : {
				required: "please enter qty"				
			}
		},
		submitHandler: function(){
			submitForm('${fn:escapeXml(addItemReq)}','giItem');
		}
	});
});
</script>
<div id="div" align="center">
<form:form id="giItem" modelAttribute="giItem" method="post" action="${fn:escapeXml(addItemReq)}">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
    <tr>
		<th align="center" colspan="2">Add Item</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>Item Name<form:hidden path="gidNo" /><form:hidden path="giHeader.gihNo"/><form:hidden path="item.id"/></td><td><form:hidden path="item.name"/>${giItem.item.name}</td></tr>	
		<tr><td>Category Name<form:hidden path="item.mmCategory.id" /><form:hidden path="item.mmCategory.name" /></td><td>${giItem.item.mmCategory.name}</td></tr>
		<tr><td>Heading Name<form:hidden path="item.mmHeading.id" /><form:hidden path="item.mmHeading.name" /></td><td>${giItem.item.mmHeading.name}</td></tr>
		<tr><td>Sub Headgin Name<form:hidden path="item.mmSubheading.id" /><form:hidden path="item.mmSubheading.name" /></td><td>${giItem.item.mmSubheading.name}</td></tr>
		<tr><td>Model Name<form:hidden path="item.mmModel.id" /><form:hidden path="item.mmModel.name" /></td><td>${giItem.item.mmModel.name}</td></tr>
		<tr><td>Brand Name<form:hidden path="item.mmBrand.id" /><form:hidden path="item.mmBrand.name" /></td><td>${giItem.item.mmBrand.name}</td></tr>
		<tr><td>Dimension<form:hidden path="item.mmDimension.id" /><form:hidden path="item.mmDimension.name" /></td><td> ${giItem.item.mmDimension.name}</td></tr>
		<tr><td>Available Quantity</td><td><form:input path="item.stock" disabled="true"/> ${giItem.item.mmUom.name}</td></tr>
		<tr><td nowrap="nowrap">Quantity</td><td><form:input path="gidQty" /></td></tr>
	<tr>
	</tbody>
	<tfoot>
		<%--<tr><td align="center" colspan="2"><button id="save" name="save" type="button" onclick="javascript:submitForm('${fn:escapeXml(addItemReq)}','giItem')">save</button></td></tr>--%>
		<tr><td align="center" colspan="2"><button id="save" name="save" type="submit">save</button></td></tr>
	</tfoot>
</table>
</form:form>
</div>