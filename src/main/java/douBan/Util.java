package douBan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.Book;

public class Util {
	//用于存放所有的书本信息的集合
	private 	List<Book> bookList=new ArrayList<Book>();
	
	private boolean flag=true;
	
	
	public boolean isFlag() {
		return flag;
	}



	public List<Book> getBookList() {
		return bookList;
	}
	
	
	
	//用于存放所有的书本信息的集合https://book.douban.com/tag/%E7%BC%96%E7%A8%8B?start=20&type=T
	 //url="https://book.douban.com/tag/%E7%BC%96%E7%A8%8B";
/**
 * 获取一页的书本信息
 * @throws IOException 
 */
	public  void getPage(String url) throws IOException {
		
		
		

		//获取 编程 页面 
		//伪装成浏览器
			Document doc=Jsoup.connect(url).
					userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
			
				
			
			//打桩输出        
			String title=doc.title();
		
			
			//获取所有出版社的标签
			Elements infoEle=doc.getElementsByClass("info");
			if(infoEle==null){
				System.out.println("标签不存在");
				flag=false;
			}
			
			//获取所有的pub标签中的信息
			for(Element e:infoEle){
				Book book=new Book();
				//获取评价
				String[] pl=e.child(2).text().split(" ");
				if(pl.length<=1){
				Integer commNum=10;
				Double score=0.0;
				book.setCommNum(commNum);
				book.setScore(score);
				}
				else{
					Double score=Double.parseDouble(pl[0]);
//					System.out.println(score);
					book.setScore(score);
					
					//获取人数
					
					Integer commNum=Integer.parseInt(pl[1].substring(pl[1].indexOf("(")+1,pl[1].indexOf("人")));
//					System.out.println(commNum+1);
					book.setCommNum(commNum);	
				}
				
				
				if(book.getCommNum()>1000){					
				String bookName=e.child(0).text();
				//获取书名
				System.out.println("获取书名");
//				System.out.println(bookName);
				book.setBookName(bookName);
				
				String[] pubTexts=e.child(1).text().split("/");
				if(pubTexts.length<4){
				book.setAuthor(pubTexts[0].trim());
				}
				//获取 作者 出版社 出版日期 价格
				else{
				book.setAuthor(pubTexts[0].trim());
				book.setPrice(pubTexts[pubTexts.length-1].trim());
				book.setDate(pubTexts[pubTexts.length-2].trim());
				book.setPub(pubTexts[pubTexts.length-3].trim());
				//System.out.println(pubText);
				}
				//存放到bookList中
				bookList.add(book);
				}
//				System.out.println(book.getAuthor()+","+book.getPub()+","+book.getDate()+","+book.getPrice());
				//System.out.println(book);
			}
			
			
			
		
		} 
		
		
		
}




	

