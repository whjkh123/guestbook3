package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
@RequestMapping(value = "/gbc")
public class GuestBookController {

	// parameter

	// fields

	// get/set method

	// general method
	// addList
	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("addList");

		// list
		GuestBookDao gDao = new GuestBookDao();
		List<GuestBookVo> gList = gDao.dbList();

		System.out.println(gList);

		// model → data 전송
		model.addAttribute("GuestList", gList);

		return "/addlist";
	}

	// http://localhost:8088/guestbook3/gbc/add?name=[]&password=[]&content=[]
	// add
	/*
	 * @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	 * public String add(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("content") String content) {
	 * 		System.out.println("add");
	 * 
	 * 		GuestBookVo gVo = new GuestBookVo(name, password, content);
	 * 		System.out.println(gVo);
	 * 
	 * 		GuestBookDao gDao = new GuestBookDao();
	 * 		gDao.dbIsrt(gVo);
	 * 
	 * 		return "redirect:/gbc/addList";
	 * }
	 */

	// http://localhost:8088/guestbook3/gbc/add?name=[]&password=[]&content=[]
	// add
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestBookVo gVo) {
		System.out.println("add");

		GuestBookDao gDao = new GuestBookDao();
		gDao.dbIsrt(gVo);

		System.out.println(gVo);

		return "redirect:/gbc/addList";
	}

	// dForm
	@RequestMapping(value = "/dForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String dForm() {
		System.out.println("dForm");

		return "/deleteForm";
	}

	// http://localhost:8088/guestbook3/gbc/delete?no=[]&password=[]
	// delete
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no, @RequestParam("password") String password) {
		System.out.println("delete");

		GuestBookDao gDao = new GuestBookDao();
		GuestBookVo gVo = new GuestBookVo(no, password);

		int cnt = gDao.dbDle(gVo);

		if (cnt == 1) {
			return "redirect:/gbc/addList";
		} else {
			System.out.println("pswError");
			return "/pswError";
		}
	}

	// http://localhost:8088/guestbook3/gbc/delete?no=[]&password=[]
	// delete → 작동 안 됨
	/*
	 * @RequestMapping(value = "/delete/{no}/{password}", method = { RequestMethod.GET, RequestMethod.POST })
	 * public String delete(@PathVariable("no") int no, @PathVariable("password") String password) {
	 * 		System.out.println("delete");
	 * 
	 * 		GuestBookDao gDao = new GuestBookDao();
	 * 		GuestBookVo gVo = new GuestBookVo(no, password);
	 * 
	 * 		int cnt = gDao.dbDle(gVo);
	 * 
	 * 		if (cnt == 1) {
	 * 		return "redirect:/gbc/addList";
	 * 		} else {
	 * 		System.out.println("pswError");
	 * 		return "/pswError";
	 * 		}
	 * }
	 */

}
