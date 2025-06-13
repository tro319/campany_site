package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;


public class DBConnect extends HttpServlet {
	
	private DBConnect() {
		
	}
	
	private static final String URL = "jdbc:postgresql://[2406:da18:243:7400:d9f8:18cd:bd5a:4a86]:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASS = "756y7kjirj0522p%40dfdjekn";
	
	/** 
	 * DB接続メソッド
	 * 
	 * @return 接続インスタンス
	 * 
	**/
	
	public static Connection getDB() throws SQLException {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
			
			e.printStackTrace();
			
			throw new SQLException("PostgreSQLドライバが見つかりません。", e);
			
			
		}
		
		return DriverManager.getConnection(URL, USER, PASS);
		
	}
	
	
	/** 
	 * DB接続を閉じるメソッド
	 * 
	 * @param conn 接続インスタンス
	 * 
	**/
	
	public static void closeDB(Connection conn) {
		
		try {
			
			if (conn != null) {
				
				conn.close();
				
			}
			
		} catch (SQLException ignored) {
			
			
		}
		
	}
       

}