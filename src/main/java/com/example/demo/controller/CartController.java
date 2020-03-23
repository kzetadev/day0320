package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DBManager;
import com.example.demo.vo.CartVo;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class CartController {
	@RequestMapping(value="/insertCart", method=RequestMethod.POST)
//	public String insertCart(@RequestParam String cart) {
//	public String insertCart(@RequestParam(value="cart") List<CartVo> cart) {	//Required List parameter 'cart' is not present
//	public String insertCart(List<CartVo> cart) {	//No primary or default constructor found for interface java.util.List
	public String insertCart(String cart) {
		String str = "ok";
		System.out.println(cart);
		ObjectMapper mapper = new ObjectMapper();
//		JSONArray array = new JSONArray();
		List<CartVo> list = null;
//		CartVo[] cartlist = null;
		try {
			list = Arrays.asList(mapper.readValue(cart, CartVo[].class));
			
			for(CartVo c : list) {
				DBManager.insertCart(c);
			}
//			cartlist = mapper.readValue(cart, CartVo[].class);
		} catch (Exception e) {
			System.out.println(e);
		}
//		System.out.println(list.size());
//		System.out.println(cartlist.length);
//		System.out.println("list");
//		for(CartVo c : list) {
//			System.out.println(c.getId() + "/" + c.getNo() + "/" + c.getGno() + "/" + c.getQty());
//		}
//		System.out.println("array");
//		for(CartVo c : cartlist) {
//			System.out.println(c.getId() + "/" + c.getNo() + "/" + c.getGno() + "/" + c.getQty());
//		}
//		DBManager.insertCart(c);
		return str;
	}
}
