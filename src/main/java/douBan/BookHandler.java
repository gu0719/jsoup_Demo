package douBan;

import java.io.IOException;
import java.util.List;


import entity.Book;

public class BookHandler {
private Util util=new Util();


/**
 * 获取所有页面
 */
public List<Book> getPages(){
	//第一页
	try {
		util.getPage("https://book.douban.com/tag/%E7%BC%96%E7%A8%8B");
		for(int i=20;i<1900;i+=20){
		util.getPage("https://book.douban.com/tag/%E7%BC%96%E7%A8%8B?start="+i+"&type=T");
		if(util.isFlag()==false){
			System.out.println("没有更多书本了");
			break;
			
		}
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return util.getBookList();
}

}
