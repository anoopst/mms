<%@ include file="/jsp/includes.jsp"%>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax"%>
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#sub1").button();
	jQuery("#fromDate").datepicker();
	jQuery("#toDate").datepicker();
	jQuery("#grVenWise").validate({
		rules: {
			fromDate: {
			required: true,
			minlength: 10
			},
			toDate: {
				required: true,
				minlength: 10
			},
			venNo: {
				required: true				
			},
			venName: {
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
								  var url="/mms/report/GRVEN/"+fmt+"?"+jQuery("#grVenWise").serialize();
					   			  openReport(url,'Goods Receipt by Vendor');
					   			 } 
	});
});
</script>
<div id="div" align="center">	
	<form id="grVenWise" method="post">
	<table id="ver-zebra" width="100%">
		<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    	</colgroup>
		<thead>
			<tr>
				<th scope="col" colspan="2" align="center" id="zebra-adventure">Goods Receipt by Vendor</th>								
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
				<td>Vendor </td>
				<td nowrap="nowrap"><input type="hidden" name="venNo" id="venNo"/><input type="text" id="venName" name="venName"/></td>
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
	source="venName" 
	target="venNo"
	parameters="name={venName}"
	baseUrl="/mms/vendor/autocomplt/" 
	className="autocomplete1"
	minimumCharacters="1" />
</div>