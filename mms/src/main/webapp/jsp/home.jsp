<!doctype html>
<%@ include file="/jsp/includes.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=8">
 <!-- <meta http-equiv="content-type" content="text/html; charset=UTF-8"> -->


<link type="text/css" rel="stylesheet" href="/mms/js/menu.css" />
<link type="text/css" rel="stylesheet" href="/mms/css/ajaxtags.css" ></link>
<link type="text/css" rel="stylesheet" href="/mms/css/displaytag.css" ></link>
<link type="text/css" href="/mms/js/jquery-ui-1.8.5.custom.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="/mms/js/style.css" />		
<script type="text/javascript" src="/mms/ajaxtags/js/prototype.js"></script>
<script type="text/javascript" src="/mms/ajaxtags/js/scriptaculous/scriptaculous.js"></script>
<script type="text/javascript" src="/mms/ajaxtags/js/overlibmws/overlibmws.js"></script>
<script type="text/javascript" src="/mms/ajaxtags/js/ajaxtags.js"></script>
<script type="text/javascript" src="/mms/js/jquery.js"></script>

<script type="text/javascript">
$.noConflict();
</script>
<script type="text/javascript" src="/mms/js/mms.js"></script>
<script type="text/javascript" src="/mms/js/jquery-ui-1.8.5.custom.min.js"></script>
<script type="text/javascript" src="/mms/js/menu.js"></script>
<script type="text/javascript" src="/mms/js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="/mms/js/jquery.validate.js"></script>

<title>Maintenance Management System</title>
</head>
<body>
<div id="Heading">
<h1 align="center"><span>Maintenance Management System</span></h1>
</div>

<div id="menu">
<ul class="menu">
	<li><a href="javascript:load('jsp/blank.html')" class="parent"><span>Home</span></a></li>
	<li><a href="#" class="parent"><span>Admin</span></a>
	<ul>
		<li><a href="#" class="parent"><span>User Maintenance</span></a>
		<ul>
			<li><a href="javascript:load('<spring:url value="/user/new"/>')"><span>Create User</span></a></li>
			<li><a href="javascript:load('<spring:url value="/user/getuser"/>')"><span>Modify User</span></a></li>
			<li><a href="javascript:load('/mms/aa/resetpassword')"><span>Reset Password</span></a></li>
		</ul>
		</li>
		<li><a href="#" class="parent"><span>Item Maintenance</span></a>
		<ul>
			<li><a href="#" class="parent"><span>New</span></a>
			<ul>
			<li><a href="javascript:load('<spring:url value="/item/new"/>')"><span>Item</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/new/1"/>')"><span>Brand Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/new/2"/>')"><span>Category Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/new/3"/>')"><span>Dimension Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/new/4"/>')"><span>Heading Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/new/5"/>')"><span>Sub-Head Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/new/7"/>')"><span>Model Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/new/6"/>')"><span>UOM Maintenance</span></a></li>
			</ul>
			</li>
			<li><a href="#" class="parent"><span>Modify</span></a>
			<ul>
			<li><a href="javascript:load('<spring:url value="/item/getitem"/>')"><span>Item</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/geticonfig/1"/>')"><span>Brand Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/geticonfig/2"/>')"><span>Category Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/geticonfig/3"/>')"><span>Dimension Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/geticonfig/4"/>')"><span>Heading Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/geticonfig/5"/>')"><span>Sub-Head Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/geticonfig/7"/>')"><span>Model Maintenance</span></a></li>
			<li><a href="javascript:load('<spring:url value="/iconfig/geticonfig/6"/>')"><span>UOM Maintenance</span></a></li>
			</ul>
			</li>
		</ul>
		</li>
		<li><a href="#" class="parent"><span>Vendor Maintenance</span></a>
		<ul>
			<li><a href="javascript:load('<spring:url value="/vendor/new"/>')"><span>Add Vendor</span></a></li>
			<li><a href="javascript:load('<spring:url value="/vendor/getvendor"/>')"><span>Modify Vendor</span></a></li>
		</ul>
		</li>
		<li><a href="#" class="parent"><span>Vehicle Maintenance</span></a>
		<ul>
			<li><a href="javascript:load('<spring:url value="/vehicle/new"/>')"><span>Add Vehicle</span></a></li>
			<li><a href="javascript:load('<spring:url value="/vehicle/getvehicle"/>')"><span>Modify Vehicle</span></a></li>
		</ul>
		</li>
	</ul>
	</li>
	<li><a href="#" class="parent"><span>Master</span></a>
	<ul>
		<li><a href="#" class="parent"><span>Requests</span></a>
		<ul>
			<li><a href="javascript:load('<spring:url value="/request/new"/>')"><span>New Request</span></a></li>
			<li><a href="javascript:load('<spring:url value="/request/search"/>')"><span>Search Request</span></a></li>
		</ul>
		</li>
		<li><a href="javascript:load('<spring:url value="/request/list"/>')"><span>Approval</span></a></li>
		<li><a href="javascript:load('<spring:url value="/request/alist"/>')"><span>Purchase Order</span></a></li>		
		<li><a href="javascript:load('<spring:url value="/po/search"/>')"><span>Goods Receipt</span></a></li>
		<li><a href="javascript:load('<spring:url value="/gi/new"/>')"><span>Goods Issue</span></a></li>
	</ul>
	</li>
	<li><a href="#" class="parent"><span>Reports</span></a>	
	<ul>
		<li><a href="#" class="parent"><span>PDF</span></a>
	<ul>
		<li><a href="javascript:openReport('/mms/report/Brand/pdf','Brand')"><span>Brand</span></a></li>
		<li><a href="javascript:openReport('/mms/report/Category/pdf','Category')"><span>Category</span></a></li>
		<li><a href="javascript:openReport('/mms/report/Dimension/pdf','Dimension')"><span>Dimension</span></a></li>
		<li><a href="javascript:openReport('/mms/report/Heading/pdf','Heading')"><span>Heading</span></a></li>
		<li><a href="javascript:openReport('/mms/report/SubHeading/pdf','SubHeading')"><span>Sub Heading</span></a></li>
		<li><a href="javascript:openReport('/mms/report/UOM/pdf','UOM')"><span>UOM</span></a></li>
		<li><a href="javascript:openReport('/mms/report/Vehicle/pdf','Vehicle')"><span>Vehicle</span></a></li>
		<li><a href="javascript:openReport('/mms/report/Vendor/pdf','Vendor')"><span>Vendor</span></a></li>
		<li><a href="javascript:openReport('/mms/report/ItemMaster/pdf','Item Master')"><span>Item Master</span></a></li>
		<li><a href="javascript:openReport('/mms/report/currstock/pdf','Current Stock')"><span>Current Stock</span></a></li>
		<li><a href="javascript:openReport('/mms/report/currstockd/pdf','Current Stock Detail')"><span>Current Stock Detail</span></a></li>		
	</ul>
	</li>
	<li><a href="#" class="parent"><span>Excel</span></a>
	<ul>
		<li><a href="javascript:openReport('/mms/report/Brand/xls','Brand')"><span>Brand</span></a></li>
		<li><a href="javascript:openReport('/mms/report/Category/xls','Category')"><span>Category</span></a></li>
		<li><a href="javascript:openReport('/mms/report/Dimension/xls','Dimension')"><span>Dimension</span></a></li>
		<li><a href="javascript:openReport('/mms/report/Heading/xls','Heading')"><span>Heading</span></a></li>
		<li><a href="javascript:openReport('/mms/report/SubHeading/xls','SubHeading')"><span>Sub Heading</span></a></li>
		<li><a href="javascript:openReport('/mms/report/UOM/xls','UOM')"><span>UOM</span></a></li>
		<li><a href="javascript:openReport('/mms/report/Vehicle/xls','Vehicle')"><span>Vehicle</span></a></li>
		<li><a href="javascript:openReport('/mms/report/Vendor/xls','Vendor')"><span>Vendor</span></a></li>
		<li><a href="javascript:openReport('/mms/report/ItemMaster/xls','Item Master')"><span>Item Master</span></a></li>		
		<li><a href="javascript:openReport('/mms/report/currstock/xls','Current Stock')"><span>Current Stock</span></a></li>
		<li><a href="javascript:openReport('/mms/report/currstockd/xls','Current Stock Detail')"><span>Current Stock Detail</span></a></li>
	</ul>
	</li>
	<li><a href="javascript:load('<spring:url value="/report/GRDate/jsp"/>')"><span>Goods Rec By Date</span></a></li>
	<li><a href="javascript:load('<spring:url value="/report/GRVEN/jsp"/>')"><span>Goods Rec By Vendor</span></a></li>
	<li><a href="javascript:load('<spring:url value="/report/GIDate/jsp"/>')"><span>Goods Issue By Date</span></a></li>
	<li><a href="javascript:load('<spring:url value="/report/PODate/jsp"/>')"><span>PO By Date</span></a></li>
	<li><a href="javascript:load('<spring:url value="/report/POVEN/jsp"/>')"><span>PO By Vendor</span></a></li>
	<li><a href="javascript:load('<spring:url value="/report/STKDate/jsp"/>')"><span>Stock By Date</span></a></li>
	<li><a href="javascript:load('<spring:url value="/report/STKITM/jsp"/>')"><span>Stock By Item</span></a></li>
	<li><a href="javascript:load('<spring:url value="/report/STKSUM/jsp"/>')"><span>Stock Summary</span></a></li>
	<li><a href="javascript:load('<spring:url value="/report/STKCHART/jsp"/>')"><span>Stock Chart</span></a></li>	
	</ul>
	</li>
	<li><a href="javascript:load('/mms/aa/changepassword')"><span>Change password</span></a></li>
	<li><a href="/mms/logout"><span>Log out</span></a></li>
</ul>
</div>
<div id="main_body"><p></p></div>
</body>
</html>