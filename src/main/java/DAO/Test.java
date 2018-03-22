package DAO;

import entity.Book;

public class Test {
public static void main(String[] args) {
	
	BookDao dao=new BookDao();
	Book book=new Book();
	book.setBookName("111");
	book.setAuthor("1111");
	dao.writeBook(book);
	System.out.println("end");
}
}
