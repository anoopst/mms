<%@ include file="/jsp/includes.jsp"%>
<spring:url value="/aa/resetpassword" var="resetUrl" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags"
	prefix="ajax"%>
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#reset").button();
});
</script>	
<div align="center">

<form id="resetpassword" name="resetpassword" method="post">
<c:if test="${!empty message}">
		<div id="message">${message}</div>
		<script>
			showmessage('#message','Password reset Successfully');
		</script>
</c:if>
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
	<thead>
		<tr>
		<th scope="col" colspan="2" align="center" id="zebra-adventure">Reset Password</th>
		</tr>
	</thead>
	<tbody>
	<tr>
		<td>Name</td>
		<td><input type="hidden" id="id" name="id"/><input id="name" name="name" size="20" maxlength="50" type="text"/><span id="indicator" class="indicator"
	style="display: none;"></span></td>
	</tr>
	</tbody>
	<tfoot>
		<tr><td align="center" colspan="2"><button id="reset" type="button" onclick="submitForm('${fn:escapeXml(resetUrl)}','resetpassword')">Reset Password</button></td></tr>
	</tfoot>
</table>
</form>
<ajax:autocomplete source="name" target="id" baseUrl="/mms/user/autocomplt/" className="autocomplete1" minimumCharacters="1" indicator="indicator"/>
</div>