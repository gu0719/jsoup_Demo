import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import DAO.BookDao;
import douBan.BookHandler;
import douBan.Util;
import entity.Book;
import excel.OpreateExcel;





public class Test {
	
	@org.junit.Test
	public void testJsoup(){
		String url="http://blog.csdn.net/u014798883/article/details/54909951";
		try {
			Document doc=Jsoup.connect(url).get();
			String title=doc.title();
			System.out.println(title);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Ê§°Ü");
		}
		
	}
	@org.junit.Test
	public void testGetPage(){
		Util douban=new Util();
		try {
			douban.getPage("https://book.douban.com/tag/%E7%BC%96%E7%A8%8B?start=20&type=T");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(douban.getBookList().size());
	}
	
	
	@org.junit.Test
	public void testGetPages(){
		BookDao dao=new BookDao();
		Book book=new Book();
		book.setBookName("111");
		dao.writeBook(book);
		
	}
	@org.junit.Test
	public void testDao(){
		BookDao dao=new BookDao();
		List<Book> books=dao.getBooks();
		System.out.println(books.size());
	}
	@org.junit.Test
	public void testExcel(){
		OpreateExcel ex=new OpreateExcel();
		BookDao dao=new BookDao();
		List<Book> books=dao.getBooks();
		ex.writeBooksIntoExcel(books);
	}

}
