package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DBManager;
import com.thoughtworks.xstream.XStream;

@RestController
public class BookController {
	@RequestMapping(value="/getBook", produces="application/xml; charset=utf-8")
	public String getBook() {
		String str = "";
		XStream xstream = new XStream();
		str = xstream.toXML(DBManager.listBook());
		return str;
	}
}
