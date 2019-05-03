package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {

private Connection co;
	
	public UsersDAO() {
		co = ConnexionDB.getInstance().getCnx();
	}
	
	public void insertUser(String pseudo, String password) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("INSERT INTO users (pseudo,password,role) values (?,?,?);");
		stmt.setString(1, pseudo);
		stmt.setString(2, password);
		stmt.setString(3, "user");
		stmt.executeUpdate();
	}
	
	public ResultSet getUsers() throws SQLException {
		PreparedStatement stmt = co.prepareStatement("SELECT * FROM users");
		return stmt.executeQuery(); 		
	}
	
	public void deleteUser(int id) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("DELETE FROM users WHERE id = ?;");
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
	
	public void modifyUser(int id, String pseudo, String password) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("UPDATE users SET pseudo = ?, password = ? WHERE id = ?");
		stmt.setString(1, pseudo);
		stmt.setString(2, password);
		stmt.setInt(3, id);
		stmt.executeUpdate();
	}
	
	public void modifyUser(int id, String pseudo, String password, String role) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("UPDATE users SET pseudo = ?, password = ?, role = ? WHERE id = ?");
		stmt.setString(1, pseudo);
		stmt.setString(2, password);
		stmt.setString(3, role);
		stmt.setInt(4, id);
		stmt.executeUpdate();
	}
	
	public ResultSet getUser(String pseudo, String password) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("SELECT * FROM users WHERE pseudo = ? AND password = ?");
		stmt.setString(1, pseudo);
		stmt.setString(2, password);
		return stmt.executeQuery();
	}
	
	public ResultSet getUser(int id) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("SELECT * FROM users WHERE id = ?");
		stmt.setInt(1, id);
		return stmt.executeQuery();
	}
	
	
}
