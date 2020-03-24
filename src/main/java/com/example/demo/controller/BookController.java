package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BookVo;

@RestController
public class BookController {
	@RequestMapping("/updateBook")
//	public ModelAndView updateBook(String oper, BookVo b, HttpServletRequest request, HttpServletResponse response) {
	public String updateBook(String oper, BookVo b, HttpServletRequest request, HttpServletResponse response) {
		String str = "";
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName(request.getHeader("referer"));
//		System.out.println(request.getParameter("bookid"));
//		System.out.println(request.getParameter("bookname"));
//		System.out.println(request.getParameter("publisher"));
//		System.out.println(request.getParameter("price"));
//		System.out.println(request.getHeader("referer"));
		System.out.println(b.getBookid());
		System.out.println(b.getBookname());
		System.out.println(b.getPublisher());
		System.out.println(b.getPrice());
		System.out.println(request.getHeader("referer"));
		System.out.println(request.getRequestURL());
		
//		BookVo b = new BookVo(Integer.parseInt(request.getParameter("bookid"))
//				, request.getParameter("bookname")
//				, request.getParameter("publisher")
//				, Integer.parseInt(request.getParameter("price")));
		switch(oper) {
			case "add":
				DBManager.insertBook(b);
				break;
			case "edit":
				DBManager.updateBook(b);
				break;
			case "del":
				DBManager.deleteBook(b);
				break;
		}
//		System.out.println(oper);
//		try {
//			response.sendRedirect(request.getHeader("referer"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
//		return mav;
		return str;
	}
	@RequestMapping(value="/getBook", produces="application/xml; charset=utf-8")
	public String getBook() {
		String str = "";
		//sqlMapConfig.xml 상단에 utf-8로 설정했으므로 charset utf-8로 추가하지 않아도 됨.
		
		str += "<rows>";
		str += "<page>1</page>";
		str += "<total>10</total>";
		str += "<records>15</records>";
		for(BookVo b : DBManager.listBook()) {
			str += "<row>";
			str += "<cell>" + b.getBookid() + "</cell>";
			str += "<cell>" + b.getBookname() + "</cell>";
			str += "<cell>" + b.getPublisher() + "</cell>";
			str += "<cell>" + b.getPrice() + "</cell>";
			str += "</row>";
		}
		str += "</rows>";
//		XStream xstream = new XStream();
//		xstream.alias("book", BookVo.class);
//		str = xstream.toXML(DBManager.listBook());
//		System.out.println(str);
		return str;
	}
}
