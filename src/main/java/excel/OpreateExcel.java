package excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import entity.Book;

public class OpreateExcel {

	
	public void writeBooksIntoExcel(List<Book> books) {
		//创建HSSFWorkbook对象 excel的文档对象
		HSSFWorkbook wb = new HSSFWorkbook();
//建立新的sheet对象 excel的表单
        HSSFSheet sheet=wb.createSheet("books");
//在sheet里创建第一行索引 excel的行
        HSSFRow row1=sheet.createRow(0);
//创建单元格 第一行字段行
        HSSFCell inicell0=row1.createCell(0);
        inicell0.setCellValue("序号");
        HSSFCell inicell1=row1.createCell(1);
        inicell1.setCellValue("书名");
        HSSFCell inicell2=row1.createCell(2);
        inicell2.setCellValue("评分");
        HSSFCell inicell3=row1.createCell(3);
        inicell3.setCellValue("评价人数");
        HSSFCell inicell4=row1.createCell(4);
        inicell4.setCellValue("作者");
        HSSFCell inicell5=row1.createCell(5);
        inicell5.setCellValue("出版社");
        HSSFCell inicell6=row1.createCell(6);
        inicell6.setCellValue("出版日期");
        HSSFCell inicell7=row1.createCell(7);
        inicell7.setCellValue("价格");
    
        
        try {
            for(int i=0;i<books.size();i++){
            	
            	//创建一行
            	HSSFRow row=sheet.createRow(i+1);
            	//创建一个格子
            	
            	
            		HSSFCell cell=row.createCell(0);
            		//序号
                	cell.setCellValue(i+1);
                	//书名
                	cell=row.createCell(1);
                	cell.setCellValue(books.get(i).getBookName());
                	//评分
                	cell=row.createCell(2);
                	cell.setCellValue(books.get(i).getScore());
                	//评价人数
                	cell=row.createCell(3);
                	cell.setCellValue(books.get(i).getCommNum());
                	//作者
                	cell=row.createCell(4);
                	cell.setCellValue(books.get(i).getAuthor());
                	//出版社
                	cell=row.createCell(5);
                	cell.setCellValue(books.get(i).getPub());
                	//出版日期
                	cell=row.createCell(6);
                	cell.setCellValue(books.get(i).getDate());
                	//价格
                	cell=row.createCell(7);
                	cell.setCellValue(books.get(i).getPrice());
            	
            }
			OutputStream output= new FileOutputStream("D:/test/bookList.xls");
			wb.write(output);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
        
	}
}
