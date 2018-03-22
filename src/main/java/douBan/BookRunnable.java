package douBan;

import java.util.List;

import DAO.BookDao;
import entity.Book;
import excel.OpreateExcel;
/**
 * 执行线程
 * @author guyu
 *
 */
public class BookRunnable implements Runnable {

	public void run() {
		long start=System.currentTimeMillis();
		BookHandler handler=new BookHandler();
		//获取页面
		List<Book> downBooks=handler.getPages();
		BookDao dao=new BookDao();
		for(Book b:downBooks){
			dao.writeBook(b);
		}
		dao=new BookDao();
		List<Book> books=dao.getBooks();
		OpreateExcel ex=new OpreateExcel();
		ex.writeBooksIntoExcel(books);
		long end=System.currentTimeMillis();
		long time=(end-start)/1000;
 		System.out.println("runtime："+time);
	}

}
