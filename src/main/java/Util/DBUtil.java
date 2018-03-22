package Util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	//4个必要参数
	private static String driver;
	private static String url;
	private static String name;
	private static String password;
	//2个策略参数
	private static int initialSize;
	private static int maxActive;
	
	static BasicDataSource ds=null;
	//使用静态块进行一次初始化
	static{
		Properties cfg=new Properties();
		InputStream in=DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			cfg.load(in);
			//四个必要参数
			driver=cfg.getProperty("jdbc.driver");
			url=cfg.getProperty("jdbc.url");
			name=cfg.getProperty("jdbc.name");
			password=cfg.getProperty("jdbc.password");
			//两个策略参数
			initialSize=Integer.parseInt(cfg.getProperty("initialSize"));
			maxActive=Integer.parseInt(cfg.getProperty("maxActive"));
			//连接池
			ds=new BasicDataSource();
			//设置必要参数
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(name);
			ds.setPassword(password);
			//设置策略参数
			ds.setInitialSize(initialSize);
			ds.setMaxActive(maxActive);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取Connection对象
	public static Connection toGetConnection(){
		try {
			Connection conn=ds.getConnection();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static void closeConnection(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
