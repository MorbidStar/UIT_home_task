package webtask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectToJdbc {

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("драйвер не найден");
		}
//		Connection conn = DriverManager.getConnection("jdbc:mysql//localhost:3306/testUIT", "root", "increase");
//		Statement st = null;
//		st = conn.createStatement();
//		ResultSet result;
//		result = st.executeQuery("SELECT * FROM LESSON");
//		while (result.next()) {
//			String name = result.getString("NAME");
//			System.out.println(result.getString("ID")+" "+name);
//		}
	}

}
