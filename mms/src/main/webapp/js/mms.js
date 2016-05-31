function load(url) {
	jQuery('#main_body p').load(url);
}

function submitForm(subUrl,formId){		
	jQuery.ajax({
		url: subUrl,
		cache: false,
		type: "POST",
		data: jQuery("#"+formId).serialize(),
		success: function(msg){jQuery('#main_body p').html(msg);}
	});
}
function submitURL(subUrl){	
	jQuery.ajax({
		url: subUrl,
		cache: false,
		type: "POST",		
		success: function(msg){jQuery('#main_body p').html(msg);}
	});
}
function showHistory(id) 
{
	var url = "/mms/gr/item/search/"+id;
	jQuery('<div>').dialog({
		open: function(){ jQuery(this).load(url); },
		title: 'Item History',
		resizable:true,
		height:'auto',
		width:800,
		closeOnEscape:true,
		draggable:true		
	});
}

function openReport(url,title) {	
	window.open(url,title,width=800,height=600);
}

function showmessage(id,msgtitle) {
	jQuery(function() {
		jQuery( id ).dialog({title:msgtitle,height:'auto',
			width:400,
			closeOnEscape:true});
	});
}