package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BookVo;
import com.example.demo.vo.CartVo;
import com.example.demo.vo.ChatVo;
import com.example.demo.vo.GoodsVo;
import com.example.demo.vo.MemberVo;
import com.example.demo.vo.ScheduleVo;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static List<GoodsVo> listAll(){
		SqlSession session = factory.openSession();
		List<GoodsVo> list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	public static List<ChatVo> listChat(){
		SqlSession session = factory.openSession();
		List<ChatVo> list = session.selectList("chat.selectAll");
		session.close();
		return list;
	}
	public static int insertChat(ChatVo c) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("chat.insert", c);
		session.close();
		return re;
	}
	public static List<ScheduleVo> listSchedule(){
		SqlSession session = factory.openSession();
		List<ScheduleVo> list = session.selectList("schedule.selectAll");
		session.close();
		return list;
	}
	public static int insertSchedule(ScheduleVo s) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("schedule.insert", s);
		session.close();
		return re;
	}
	public static int insertCart(CartVo c) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("cart.insert", c);
		session.close();
		return re;
	}
	public static MemberVo isMember(MemberVo m) {
		MemberVo r = null;
		SqlSession session = factory.openSession();
		r = session.selectOne("member.isMember", m);
		return r;
	}
	public static List<BookVo> listBook(){
		SqlSession session = factory.openSession();
		List<BookVo> list = session.selectList("book.selectAll");
		session.close();
		return list;
	}
	public static int insertBook(BookVo b) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("book.insert", b);
		session.close();
		return re;
	}
	public static int updateBook(BookVo b) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("book.update", b);
		session.close();
		return re;
	}
	public static int deleteBook(BookVo b) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.delete("book.delete", b);
		session.close();
		return re;
	}
}
