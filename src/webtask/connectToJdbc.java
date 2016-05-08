package webtask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class connectToJdbc {

	private static final String URL = "jdbc:mysql://localhost/testUIT?useSSL=false&serverTimezone=UTC";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "increase";
	
	private static final int COUNT_USER = 10;
	private static final int COUNT_TEST = 4;
	private static final int COUNT_QUESTION_PER_TEST = 3;
	
	public static void main(String[] args) throws SQLException {
		
		Random r = new Random();
		
		try(Connection dbConnection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
			
			Statement st = dbConnection.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT id, name FROM test");
			
			List<Integer> listID = new ArrayList<>();
			List<String> listName = new ArrayList<>();
			
			while (rs.next()) {
				listID.add(rs.getInt(1));
				listName.add(rs.getString(2));
			}
			
			rs.close();
			st.close();
			
			st = dbConnection.createStatement();
			rs = st.executeQuery("SELECT id_account FROM account_role WHERE id_role = 1");
			
			List<Integer> listIdAccount = new ArrayList<>();
			
			while (rs.next()) {
				listIdAccount.add(rs.getInt(1));
			}
			
			rs.close();
			st.close();
			
			dbConnection.setAutoCommit(false);
			PreparedStatement ps = dbConnection.prepareStatement(
					"INSERT INTO result (id, id_test, id_account, percent, test_name)"
					+ " VALUES (?, ?, ?, ?, ?)");
			
			for(int j = 0; j < listID.size(); j++) {
				ps.setInt(1, j+1);
				ps.setInt(2, listID.get(j));
				ps.setInt(3, listIdAccount.get(r.nextInt(listIdAccount.size())));
				ps.setDouble(4, r.nextInt(100)+1);
				ps.setString(5, listName.get(j));
				ps.addBatch();
			}
			
			ps.executeBatch();
			dbConnection.commit();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
