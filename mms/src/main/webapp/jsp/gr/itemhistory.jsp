<%@ include file="/jsp/includes.jsp"%>
<link type="text/css" rel="stylesheet" href="/mms/js/style.css" />
	<div id="div2" align="center">	
	<table id="gradient-style">		
		<thead>
			<tr>
			<th scope="col">Item Name</th>
			<th scope="col">Quantity</th>
			<th scope="col">Rate</th>
			<th scope="col">Amount</th>
			<th scope="col">Date</th>
			<th scope="col">Vendor</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="grHeader" items="${grheaders}">
			<tr>
				<td>${grHeader.grDetails[0].item.name}</td>
				<td>${grHeader.grDetails[0].grdQty}</td>
				<td>${grHeader.poHeader.poDetails[0].poRate}</td>
				<td>${grHeader.poHeader.poDetails[0].poRate * grHeader.grDetails[0].grdQty}</td>
				<td>${grHeader.grDate}</td>
				<td>${grHeader.poHeader.vendor.name}</td>				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
