<%@ include file="/jsp/includes.jsp"%>	
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax"%>
<spring:url value="/item/save" var="submitVal" />
<script type="text/javascript">
jQuery(document).ready(function() {	
	jQuery("#save").button();
	jQuery("#itemForm").validate({
		rules: {
			name: {
				required: true,
				minlength: 2
			},
			rate: {
				required: true,
				number: true,
				min: 0
			},
			rol: {
				required: true,
				number: true,
				min: 0
			},
			stock: {
				required: true,
				number: true,
				min: 0
			},
			"mmHeading.id": "required",						
			"mmSubheading.id": "required",			
			"mmCategory.id": "required",			
			"mmBrand.id": "required",			
			"mmDimension.id": "required",			
			"mmModel.id": "required",			
			"mmUom.id": "required"			
		},
		messages: {
			name: {
			required: "Please enter item name",
			minlength: "item must consist of at least 2 characters"
			},
			rate: {
				required: "Please enter rate",
				number: "please enter rate"
			},			
			rol: {
				required: "Please enter rate",
				number: "please enter rate"
			},
			stock: {
				required: "Please enter rate",
				number: "please enter rate"
			},
			"mmHeading.id": {
				required: "Please enter valid heading"
			},						
			"mmSubheading.id": {
				required: "Please enter valid sub heading"
			},			
			"mmCategory.id": {
				required: "Please enter valid category"
			},			
			"mmBrand.id": {
				required: "Please enter valid brand"
			},			
			"mmDimension.id": {
				required: "Please enter valid dimension"
			},			
			"mmModel.id": {
				required: "Please enter valid model"
			},			
			"mmUom.id": {
				required: "Please enter valid uom"
			}			
		},
		submitHandler: function(){			
			//jQuery("#name").val(jQuery("#name").val().toLowerCase());			 
			submitForm('${fn:escapeXml(submitVal)}','itemForm');
		} 
	});	
});
</script>

<div id="div" align="center">
<form:form id="itemForm" modelAttribute="itemForm" method="post">
<c:if test="${!empty message}">
		<div id="message">${message}</div>
		<script>
			showmessage('#message','Item saved successfully');
		</script>
	</c:if>
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
    <thead>
	<tr><th scope="col" colspan="2" align="center" id="zebra-adventure">Add/Edit Item</th></tr>
	</thead>
	<tbody>
	<tr>
		<td>Item Name </td>
		<td nowrap="nowrap"><form:hidden path="id" /><form:input path="name" /><form:errors path="name" /></td>
	</tr>
	<tr>
		<td>Heading Name</td>
		<td nowrap="nowrap"><form:input	path="mmHeading.name" /><form:errors path="mmHeading.name" /><form:hidden path="mmHeading.id" /></td>
	</tr>
	<tr>
		<td>Sub Heading Name</td>
		<td nowrap="nowrap"><form:input path="mmSubheading.name" /><form:errors path="mmSubheading.name" /><form:hidden path="mmSubheading.id" /></td>
	</tr>
	<tr>
		<td>Category</td>
		<td nowrap="nowrap"><form:input path="mmCategory.name" /><form:errors path="mmCategory.name" /><form:hidden path="mmCategory.id" /></td>
	</tr>
	<tr>
		<td>Brand Name</td>
		<td nowrap="nowrap"><form:input path="mmBrand.name" /><form:errors path="mmBrand.name" /><form:hidden path="mmBrand.id" /></td>
	</tr>
	<tr>
		<td>Dimension Name</td>
		<td nowrap="nowrap"><form:input path="mmDimension.name" /><form:errors path="mmDimension.name" /><form:hidden path="mmDimension.id" /></td>
	</tr>
	<tr>
		<td>Model Name</td>
		<td nowrap="nowrap"><form:input path="mmModel.name" /><form:errors path="mmModel.name" /><form:hidden path="mmModel.id" /></td>
	</tr>
	<tr>
		<td>Price</td>
		<td nowrap="nowrap"><form:input path="rate" /><form:errors path="rate" /></td>
	</tr>
	<tr>
		<td>Unit of Measurement</td>
		<td nowrap="nowrap"><form:input path="mmUom.name" /><form:errors path="mmUom.name" /><form:hidden path="mmUom.id" /></td>
	</tr>
	<tr>
		<td>Reorder Level</td>
		<td nowrap="nowrap"><form:input path="rol" /><form:errors path="rol" /></td>
	</tr>
	<tr>
		<td>Balance Stock</td>
		<td nowrap="nowrap"><form:input path="stock" /><form:errors path="stock" /></td>
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
<div class="suggestionsBox" id="suggestions" style="display: none;"><div class="suggestionList" id="autoSuggestionsList"></div></div>
</form:form>
<ajax:autocomplete 
	source="mmBrand.name" 
	target="mmBrand.id"
	parameters="name={mmBrand.name}"
	baseUrl="/mms/iconfig/autocomplt/1" 
	className="autocomplete1"
	minimumCharacters="1" />
	
<ajax:autocomplete 
	source="mmCategory.name" 
	target="mmCategory.id"
	parameters="name={mmCategory.name}"
	baseUrl="/mms/iconfig/autocomplt/2"
    className="autocomplete1"
	minimumCharacters="1" />

<ajax:autocomplete 
	source="mmDimension.name" 
	target="mmDimension.id"
	parameters="name={mmDimension.name}"
	baseUrl="/mms/iconfig/autocomplt/3" 
	className="autocomplete1"
	minimumCharacters="1" />

<ajax:autocomplete 
	source="mmHeading.name" 
	target="mmHeading.id"
	parameters="name={mmHeading.name}"
	baseUrl="/mms/iconfig/autocomplt/4" 
	className="autocomplete1"	
	minimumCharacters="1" />

<ajax:autocomplete 
	source="mmSubheading.name" 
	target="mmSubheading.id"
	parameters="name={mmSubheading.name}"
	baseUrl="/mms/iconfig/autocomplt/5" 
	className="autocomplete1"
	minimumCharacters="1" />

<ajax:autocomplete 
	source="mmUom.name" 
	target="mmUom.id"
	parameters="name={mmUom.name}"
	baseUrl="/mms/iconfig/autocomplt/6" 
	className="autocomplete1"
	minimumCharacters="1" />
	
<ajax:autocomplete 
	source="mmModel.name" 
	target="mmModel.id"
	parameters="name={mmModel.name}"
	baseUrl="/mms/iconfig/autocomplt/7" 
	className="autocomplete1"
	minimumCharacters="1" />				
</div>	