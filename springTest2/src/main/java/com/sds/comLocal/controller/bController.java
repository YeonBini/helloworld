package com.sds.comLocal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sds.comLocal.command.BCommand;
import com.sds.comLocal.command.BContentCommand;
import com.sds.comLocal.command.BDeleteCommand;
import com.sds.comLocal.command.BListCommand;
import com.sds.comLocal.command.BModifyCommand;
import com.sds.comLocal.command.BReplyCommand;
import com.sds.comLocal.command.BReplyViewCommand;
import com.sds.comLocal.command.BWriteCommand;

@Controller
public class bController {
	BCommand command;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list() start");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view() start");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request ,Model model) {
		System.out.println("write() start");
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String contentView(HttpServletRequest request, Model model) {
		System.out.println("contentView() start");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify() start");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view() start");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "/reply_view";
	}

	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply() start");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete() start");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}
