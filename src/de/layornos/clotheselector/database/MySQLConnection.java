package de.layornos.clotheselector.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection implements DatabaseConnection {

	private Connection conn;
	private String user;
	private String password;
	private String url;

	public MySQLConnection() {
		user = "root";
		password = "kenshin01";
		url = "jdbc:mysql://localhost:3306/clothes";
	}

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);

			// Do something with the Connection

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setCredentials(Credentials c) {
		user = c.name;
		password = c.pw;
		url = c.url;
	}

	public ResultSet executeQuery(String query) throws SQLException {
		ResultSet rs = null;
		Statement statement = conn.createStatement();
		rs = statement.executeQuery(query);
		return rs;
	}

	public void executeUpdate(String query) throws SQLException {
		Statement statement = conn.createStatement();
		statement.executeUpdate(query);
	}

}
