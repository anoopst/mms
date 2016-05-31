<link type="text/css" href="/mms/js/style.css" rel="stylesheet"/>
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#sub1").button();
});
</script>
<div align="center">

<form id="changepassword" name="changepassword" action="/mms/aa/submitchangepassword" method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
	<thead>
		<tr>
		<th scope="col" colspan="2" align="center" id="zebra-adventure">Change Password</th>
		</tr>
	</thead>
	<tbody>
	<tr>
		<td>Password</td>
		<td><input id="newpassword1" name="newpassword1" size="20" maxlength="50" type="password"/></td>
	</tr>
	</tbody>
	<tfoot>
		<tr><td align="center" colspan="2"><button id="sub1" name="sub1" type="submit">Change password</button></td></tr>
	</tfoot>
</table>
</form>
</div>