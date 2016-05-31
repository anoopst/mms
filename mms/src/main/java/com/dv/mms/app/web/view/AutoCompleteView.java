package com.dv.mms.app.web.view;

import java.util.List;

import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.ajaxtags.xml.AjaxXmlBuilder;

import org.springframework.web.servlet.view.AbstractView;





public class AutoCompleteView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List list = (List)model.get("list");
		AjaxXmlBuilder ajaxXml = new AjaxXmlBuilder();
		ajaxXml.addItems(list);
		String xml = ajaxXml.toString();
		//System.out.println(xml);
		ServletOutputStream out = response.getOutputStream();
		out.print(xml);
		out.close();

	}
	
	

}
