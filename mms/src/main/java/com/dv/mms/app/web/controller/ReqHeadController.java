package com.dv.mms.app.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dv.mms.app.service.RequestService;
import com.dv.mms.app.utils.Constants;
import com.dv.mms.app.web.form.RequestHeader;

@Controller
@RequestMapping("/request")
@SessionAttributes("reqHead")
public class ReqHeadController {

	public ReqHeadController() {
	}

	@Autowired
	public ReqHeadController(RequestService requestService) {
		this.requestService = requestService;
	}

	private RequestService requestService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String setupForm(Model model) {
		RequestHeader reqHead = new RequestHeader();
		reqHead.setStatus(Constants.REQUEST_DRAFTED);
		model.addAttribute("reqHead",reqHead);
		return "request/reqheader";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createRequest(@ModelAttribute RequestHeader reqHead,
			Model model) {		
		Integer reqId = requestService.addRequest(reqHead);
		return "redirect:/request/" + reqId;
	}

	@RequestMapping("/{reqId}")
	public String manageRequest(@PathVariable("reqId") Integer reqId,
			Model model) {
		RequestHeader reqHead = requestService.getRequest(reqId);
		model.addAttribute("reqHead", reqHead);
		return "request/summary";
	}
	
	@RequestMapping("/{reqId}/id")
	public String manageRequest1(@PathVariable("reqId") Integer reqId,
			Model model) {
		RequestHeader reqHead = requestService.getRequest(reqId);
		model.addAttribute("reqHead", reqHead);
		return "request/summary";
	}
	
	@RequestMapping("/{reqId}/forapproval")
	public String requestforApproval(@PathVariable("reqId") Integer reqId,
			Model model) {
		RequestHeader reqHead = requestService.getRequest(reqId);
		model.addAttribute("reqHead", reqHead);
		return "request/summary";
	}

	@RequestMapping("/{reqId}/save")
	public String completeRequest(@PathVariable("reqId") Integer reqId,
			Model model) {
		RequestHeader reqHead = requestService.getRequest(reqId);
		reqHead.setStatus(Constants.REQUEST_REQUESTED);
		requestService.modifyRequest(reqHead);	
		/*reqHead = requestService.getRequest(reqId);
		model.addAttribute("reqHead", reqHead);
		model.addAttribute("submitted", "submitted");
		return "request/summary";*/
		return "redirect:/request/" + reqId;
	}

	@RequestMapping(value = "/{reqId}/cancel", method = RequestMethod.POST)
	public String cancelRequest(@PathVariable("reqId") Integer reqId,
			Model model) {
		RequestHeader reqHead = requestService.getRequest(reqId);
		reqHead.setStatus(Constants.REQUEST_CANCEL);
		requestService.modifyRequest(reqHead);
		return "redirect:/request/" + reqId;
	}
	
	//@RequestMapping(value = "/{reqId}/approve", method = RequestMethod.POST)
	@RequestMapping("/{reqId}/approve")
	public String approveRequest(@PathVariable("reqId") Integer reqId,
			Model model) {
		RequestHeader reqHead = requestService.getRequest(reqId);
		reqHead.setStatus(Constants.REQUEST_APPROVED);
		requestService.modifyRequest(reqHead);
		return "redirect:/request/" + reqId+"/id";
	}
	
	@RequestMapping("/list")
	public String getRequestList(Model model) {		
		List list = requestService.getRequestList(Constants.REQUEST_REQUESTED);
		model.addAttribute("reqList", list);
		return "request/reqlist";
	}
	
	@RequestMapping("/alist")
	public String getApprovedList(Model model) {
		List status = new ArrayList();
		status.add(Constants.REQUEST_APPROVED);
		status.add(Constants.REQUEST_PENDING_PO);
		List list = requestService.getRequestList(status);		
		model.addAttribute("reqList", list);
		return "request/approvedlist";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String searchRequest(Model model){
		RequestHeader reqHead = new RequestHeader();		
		model.addAttribute("reqHead",reqHead);		
		return "request/search";
	}
	
	@RequestMapping(value="/getrequest",method=RequestMethod.POST)
	public String getRequest(@ModelAttribute RequestHeader reqHead,Model model) {
		RequestHeader req = requestService.getRequest(reqHead.getRequestId());
		//System.out.println("/getrequest"+ req.getRequestId()+" "+req.getStatus());
		model.addAttribute("req", req);
		return "request/search";
	}

	public RequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}
}
