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
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

public class GenerateDateDB {

	private static final String URL = "jdbc:mysql://localhost/testUIT?useSSL=false&serverTimezone=UTC";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "increase";
	
	private static String[] lastName = {"SCOTT","YOUNG","JAMES","LEE","PARKER","TURNER","RUSSELL","BENNETT","FISHER","PRICE","COX","SHAW"};
	private static String[] firstName = {"Brenton","Bret","Grey","Clinton","Clive","Clovis","Clyde","Ernie","ErrolCoby","Brevin","Omar","Nash"};
	private static String[] secondName = {"Cadence","Jessie","Cheyanne","Ilse","Margo","Imelda","Ondina","Chiara","Chloe","Kaidence","Elvina","Lilith"};
	private static String[] email = {"rambler.ru", "mail.ru", "gmail.com", "raskladushka.gov", "xvatit.by"};
	
	private static final int COUNT_USER = 10;
	private static final int COUNT_TEST = 4;
	
public static void main(String[] args) {
		
		try(Connection dbConnection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
//			insertDateAccount(dbConnection);
//			insertDateRole(dbConnection);
//			insertDateAccountRole(dbConnection);
//			insertDateTest(dbConnection);
//			insertDateQuestion(dbConnection);
//			insertDateAnswer(dbConnection);
//			insertDateResult(dbConnection);
//			System.out.println("таблицы заполнены :)");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void insertDateAccount(Connection con) {
		
		Random r = new Random();
		
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO account (id, login, password, first_name, last_name, second_name, email) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, 1);
			ps.setString(2, "admin");
			ps.setString(3, "admin");
			ps.setString(4, "victor");
			ps.setString(5, "draban");
			ps.setString(6, "anatolievi4");
			ps.setString(7, "drabanvictor@gmail.com");
			ps.addBatch();
			
			for (int i = 0; i < COUNT_USER; i++) {
				int l = r.nextInt(lastName.length);
				int f = r.nextInt(firstName.length);
				int s = r.nextInt(secondName.length);
				ps.setInt(1, i+2);
				ps.setString(2, lastName[l] + firstName[f] + i);
				ps.setString(3, "qwerty");
				ps.setString(4, lastName[l]);
				ps.setString(5, firstName[f]);
				ps.setString(6, secondName[s]);
				ps.setString(7, lastName[l] + firstName[f] + i + "@" + email[r.nextInt(email.length)]);
				ps.addBatch();
			}
			
			ps.executeBatch();
			con.commit();
			ps.close();
		} catch (SQLException e) {
			System.out.println("не удалось заполнить таблицу account");
			e.printStackTrace();
		}
	}
	
	private static void insertDateRole(Connection con) {
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO role (id, name) VALUES (?, ?)");
			
			ps.setInt(1, 1);
			ps.setString(2, "student");
			ps.addBatch();
			ps.setInt(1, 2);
			ps.setString(2, "tutor");
			ps.addBatch();
			ps.setInt(1, 3);
			ps.setString(2, "advance tutor");
			ps.addBatch();
			ps.setInt(1, 4);
			ps.setString(2, "admin");
			ps.addBatch();
			
			ps.executeBatch();
			con.commit();
			ps.close();
		} catch (SQLException e) {
			System.out.println("не удалось заполнить таблицу role");
			e.printStackTrace();
		}
	}
	
	public void insertDateAccountRegestration() {
		
	}

	private static void insertDateAccountRole(Connection con) {
	
		Random r = new Random();
		
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO account_role (id, id_account, id_role) VALUES (?, ?, ?)");
			
			ps.setInt(1, 1);
			ps.setInt(2, 1);
			ps.setInt(3, 4);
			ps.executeUpdate();
			
			Set<Integer> set = new HashSet();
			Map<Integer, Set<Integer>> map = new HashMap<>();
			
			int id_account = 0;
			int id_role = 0;
			
			for(int i = 2; i < COUNT_USER; i++) {
				id_account = r.nextInt(10)+1;
				id_role = r.nextInt(3)+1;
				
				if(map.get(id_account)!=null) {
					set = map.get(id_account);
				}
				
				set.add(id_role);
				map.put(id_account, new HashSet(set));
				
				set.clear();
			}
			
			int counter = 2;
			for(Entry<Integer, Set<Integer>> entry : map.entrySet()) {
				set = entry.getValue();
				for(Integer iter : set) {
					ps.setInt(1, counter++);
					ps.setInt(2, entry.getKey());
					ps.setInt(3, iter);
					ps.addBatch();
				}
			}
			
			ps.executeBatch();
			con.commit();
		}	catch (SQLException e) {
			System.out.println("не удалось заполнить таблицу account_role");
			e.printStackTrace();
		}
	}

	private static void insertDateAnswer(Connection con) {
		
		Random r = new Random();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT id FROM question");
			
			List<Integer> listID = new ArrayList<>();
			
			while (rs.next()) {
				listID.add(rs.getInt(1));
			}
			
			rs.close();
			st.close();
			
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO answer (id, id_question, name, correct)"
					+ " VALUES (?, ?, ?, ?)");
			
			int count=1;
			for(int j = 0; j < listID.size(); j++) {
				ps.setInt(2, listID.get(j));
				for(int k = 0; k < r.nextInt(3)+3; k++) {
					ps.setInt(1, count++);
					ps.setString(3, "answer " + (k+1));
					ps.setBoolean(4, r.nextBoolean());
					ps.addBatch();
				}
				
			}
			
			ps.executeBatch();
			con.commit();
		} catch (SQLException e) {
			System.out.println("не удалось заполнить таблицу answer");
			e.printStackTrace();
		}
		
	}

	private static void insertDateQuestion(Connection con) {
	
		Random r = new Random();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT id FROM test");
			
			List<Integer> listID = new ArrayList<>();
			
			while (rs.next()) {
				listID.add(rs.getInt(1));
			}
			
			rs.close();
			st.close();
			
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO question (id, id_test, name)"
					+ " VALUES (?, ?, ?)");
			
			int count=1;
			for(int j = 0; j < listID.size(); j++) {
				ps.setInt(2, listID.get(j));
				for(int k = 0; k < r.nextInt(10)+5; k++) {
					ps.setInt(1, count++);
					ps.setString(3, "question " + (k+1));
					ps.addBatch();
				}
				
			}
			
			ps.executeBatch();
			con.commit();
		} catch (SQLException e) {
			System.out.println("не удалось заполнить таблицу question");
			e.printStackTrace();
		}
		
	}
	
	private static void insertDateResult(Connection con) {
		
		Random r = new Random();
		
		try {
			Statement st = con.createStatement();
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
			
			st = con.createStatement();
			rs = st.executeQuery("SELECT id_account FROM account_role WHERE id_role = 1");
			
			List<Integer> listIdAccount = new ArrayList<>();
			
			while (rs.next()) {
				listIdAccount.add(rs.getInt(1));
			}
			
			rs.close();
			st.close();
			
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
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
			con.commit();
		} catch (SQLException e) {
			System.out.println("не удалось заполнить таблицу question");
			e.printStackTrace();
		}
		
	}
	
	private static void insertDateTest(Connection con) {
		
		Random r = new Random();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT ac.id, ac.last_name, ac.first_name FROM account ac JOIN account_role ar ON ac.id = ar.id_account"
					+ " WHERE ar.id_role = 2 OR ar.id_role = 3");
			
			List<Integer> listID = new ArrayList<>();
			List<String> listLastName = new ArrayList<>();
			List<String> listFirstName = new ArrayList<>();
			
			while (rs.next()) {
				listID.add(rs.getInt(1));
				listLastName.add(rs.getString(2));
				listFirstName.add(rs.getString(3));
			}
			
			rs.close();
			st.close();
			
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO test (id, id_account, name, description, duration_per_question)"
					+ " VALUES (?, ?, ?, ?, ?)");
			
			for(int j = 1; j <= COUNT_TEST; j++) {
				int num = r.nextInt(listID.size());
				ps.setInt(1, j);
				ps.setInt(2, listID.get(num));
				ps.setString(3, "test" + j);
				ps.setString(4, "Very important test FROM " + listLastName.get(num) + " " + listFirstName.get(num));
				ps.setInt(5, r.nextInt(60)+31);
				ps.addBatch();
			}
			
			ps.executeBatch();
			con.commit();
		} catch (SQLException e) {
			System.out.println("не удалось заполнить таблицу test");
			e.printStackTrace();
		}
		
	}
	
}
