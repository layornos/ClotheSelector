package de.layornos.clotheselector.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseConnection {
	public void setCredentials(Credentials c);
	public void connect();
	public ResultSet executeQuery(String query) throws SQLException;
	public void executeUpdate(String query) throws SQLException;
}
