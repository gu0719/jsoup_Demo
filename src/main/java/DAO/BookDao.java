package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Util.DBUtil;
import entity.Book;

public class BookDao {
public void writeBook(Book book){
	
	Connection conn=null;
	try {
		conn=DBUtil.toGetConnection();
		String sql="insert into book(book_name,score,comm_num,author,pub,pub_time,price) values(?,?,?,?,?,?,?)";
	
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, book.getBookName());
			ps.setDouble(2, book.getScore());
			ps.setInt(3, book.getCommNum());
			ps.setString(4, book.getAuthor());
			ps.setString(5,book.getPub());
			ps.setString(6, book.getDate());
			ps.setString(7, book.getPrice());
			ps.executeUpdate();
			
	
		
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtil.closeConnection(conn);
	}
	
	
}

public List<Book> getBooks(){
	 List<Book> books=new ArrayList<Book>();
	Connection conn=null;
	try {
		conn=DBUtil.toGetConnection();
		String sql="select book_name,score,comm_num,author,pub,pub_time,price from book order by score desc";
		PreparedStatement ps=conn.prepareStatement(sql);
	
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Book book =new Book();
//			Integer id=rs.getInt("id");
			String bookName=rs.getString("book_name");
			Double score=rs.getDouble("score");
			Integer commNum=rs.getInt("comm_num");
			String author=rs.getString("author");
			String pub=rs.getString("pub");
			String pubTime=rs.getString("pub_time");
			String price=rs.getString("price");
//			book.setId(id);
			book.setAuthor(author);
			book.setBookName(bookName);
			book.setCommNum(commNum);
			book.setDate(pubTime);
			book.setPrice(price);
			book.setPub(pubTime);
			book.setScore(score);
			books.add(book);
			
		}
		return books;
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtil.closeConnection(conn);
	}
	return null;
	
	
	
}
}
