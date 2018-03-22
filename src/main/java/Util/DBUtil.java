package Util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	//4����Ҫ����
	private static String driver;
	private static String url;
	private static String name;
	private static String password;
	//2�����Բ���
	private static int initialSize;
	private static int maxActive;
	
	static BasicDataSource ds=null;
	//ʹ�þ�̬�����һ�γ�ʼ��
	static{
		Properties cfg=new Properties();
		InputStream in=DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			cfg.load(in);
			//�ĸ���Ҫ����
			driver=cfg.getProperty("jdbc.driver");
			url=cfg.getProperty("jdbc.url");
			name=cfg.getProperty("jdbc.name");
			password=cfg.getProperty("jdbc.password");
			//�������Բ���
			initialSize=Integer.parseInt(cfg.getProperty("initialSize"));
			maxActive=Integer.parseInt(cfg.getProperty("maxActive"));
			//���ӳ�
			ds=new BasicDataSource();
			//���ñ�Ҫ����
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(name);
			ds.setPassword(password);
			//���ò��Բ���
			ds.setInitialSize(initialSize);
			ds.setMaxActive(maxActive);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��ȡConnection����
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
