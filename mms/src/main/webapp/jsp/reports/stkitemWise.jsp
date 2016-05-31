<%@ include file="/jsp/includes.jsp"%>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax"%>
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#sub1").button();
	jQuery("#fromDate").datepicker();
	jQuery("#toDate").datepicker();
	jQuery("#stkitemWise").validate({
		rules: {
			fromDate: {
			required: true,
			minlength: 10
			},
			toDate: {
				required: true,
				minlength: 10
			},
			itemNo: {
				required: true				
			},
			itemName: {
				required: true
			}
		},
		messages: {
			fromDate: {
			required: "Please enter valid date",
			minlength: "Please enter valid date"
			},
			toDate: {
				required: "Please enter valid date",
				minlength: "Please enter valid date"
			}			
		},
		submitHandler: function(){var fmt = jQuery("select#format").val();
								  var url="/mms/report/STKITM/"+fmt+"?"+jQuery("#stkitemWise").serialize();
					   			  openReport(url,'Stock by Item');
					   			 } 
	});
});
</script>
<div id="div" align="center">	
	<form id="stkitemWise" method="post">
	<table id="ver-zebra" width="100%">
		<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    	</colgroup>
		<thead>
			<tr>
				<th scope="col" colspan="2" align="center" id="zebra-adventure">Stock by Item</th>								
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>From </td>
				<td nowrap="nowrap"><input type="text" id="fromDate" name="fromDate"/></td>
			</tr>
			<tr>
				<td>TO </td>
				<td nowrap="nowrap"><input type="text" id="toDate" name="toDate"/></td>
			</tr>
			<tr>
				<td>Item </td>
				<td nowrap="nowrap"><input type="hidden" name="itemNo" id="itemNo"/><input type="text" id="itemName" name="itemName"/></td>
			</tr>
			<tr>
				<td>Report Format</td>
				<td nowrap="nowrap"><select id="format" name="format"><option value="pdf">PDF</option><option value="xls">Excel</option></select></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td align="center" colspan="2">				
				<button id="sub1" type="submit">Submit</button>
				</td>
			</tr>
		</tfoot>
	</table>
</form>
<ajax:autocomplete 
	source="itemName" 
	target="itemNo"
	parameters="name={itemName}"
	baseUrl="/mms/item/autocomplt/" 
	className="autocomplete1"
	minimumCharacters="1" />
</div>