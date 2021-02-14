package cn.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
//    //链接地址，设置编码可用且为utf-8
//    public  String URL="jdbc:mysql://192.168.80.131:3306/db1?useUnicode=true&characterEncoding=utf8";
//    //数据库用户名
//    public  String USER="root";
//    //数据库密码
//    public String PWD="123456";

	/*
	 * 进行数据库的链接
	 */
	public static Connection getConnection(String driver, String url, String user, String pwd) {
		url = url + "?characterEncoding=utf-8&serverTimezone=GMT%2b8&useSSL=false";
		Connection con = null;
		try {
			// 加载驱动
			Class.forName(driver);
			// 创建链接
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 返回连接
		return con;
	}

	/*
	 * 数据库关闭
	 */
	public static void Close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			// 判断是否被操作
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}