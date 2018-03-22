package entity;
/**
 * 实体类Book
 * @author guyu
 *
 */
public class Book implements Comparable<Book>{

private Integer id;
private String bookName;
private Double score;
private Integer commNum;
private String author;
private String pub;
private String date;
private String price;

public Integer getId()  {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public double getScore() {
	return score;
}
public void setScore(double score) {
	this.score = score;
}
public Integer getCommNum() {
	return commNum;
}
public void setCommNum(Integer commNum) {
	this.commNum = commNum;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPub() {
	return pub;
}
public void setPub(String pub) {
	this.pub = pub;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
@Override
public String toString() {
	return "Book [id=" + id + ", bookName=" + bookName + ", score=" + score + ", commNum=" + commNum + ", author="
			+ author + ", pub=" + pub + ", date=" + date + ", price=" + price + "]";
}

public int compareTo(Book b) {

	//排序从大到小
	return (int)(this.score-b.getScore())*10;
}


}
