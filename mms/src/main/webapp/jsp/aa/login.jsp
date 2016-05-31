<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<link type="text/css" href="/mms/js/jquery-ui-1.8.5.custom.css" rel="stylesheet" />
<link type="text/css" href="/mms/js/style.css" rel="stylesheet"/>
<script type="text/javascript" src="/mms/js/jquery.js"></script>
<script type="text/javascript" src="/mms/js/jquery-ui-1.8.5.custom.min.js"></script>
<script type="text/javascript" src="/mms/js/jquery.validate.js"></script>
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#login").button();
	jQuery("#loginform").validate({
		rules: {
		j_username: {
			required: true
			},
		j_password: {
			required: true
		}
		
		},
		messages: {
			j_username: {
			required: "Please enter name"		
			},
			j_username: {
				required: "Please enter password"			
			}			
		},
		submitHandler: function(){$("#loginform").submit();} 
	});
});
</script>
<h1 align="center"></h1>
<div align="center">

<form id="loginform" name="loginform" action="/mms/j_spring_security_check" method="post">
<table id="ver-zebra" width="100%">
	<colgroup>
    	<col class="vzebra-odd" />
    	<col class="vzebra-even" />    	
    </colgroup>
	<thead>
		<tr>
		<th scope="col" colspan="2" align="center" id="zebra-adventure">Please Log In to Your Account</th>
		</tr>
	</thead>
	<tbody>
	<tr>
		<td>Login</td>
		<td><input id="j_username" name="j_username" size="20" maxlength="50" type="text"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input id="j_password" name="j_password" size="20" maxlength="50" type="password"/></td>
	</tr>
	</tbody>
	<tfoot>
		<tr><td align="center" colspan="2"><input id="login" name="login" type="submit" value="Login"/></td></tr>
	</tfoot>
</table>
</form>
</div>