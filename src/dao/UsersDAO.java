package dao;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Random;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class UsersDAO {

private Connection co;
	
	public UsersDAO() {
		co = ConnexionDB.getInstance().getCnx();
	}
	
	public void insertUser(String pseudo, String password, String role) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
		PreparedStatement stmt = co.prepareStatement("INSERT INTO users (pseudo,password,role,hashcart,salt) values (?,?,?,?,?);");
		stmt.setString(1, pseudo);
		stmt.setString(2, password);
		stmt.setString(3, role);
		
		pseudo += pseudo;
		pseudo += pseudo;

		password += password;
		password += password;

		Random r = new SecureRandom();
		byte[] salt = new byte[20];
		r.nextBytes(salt);
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		
		String saltString=(new HexBinaryAdapter().marshal(salt)).toString();
		//String saltString = Base64.getEncoder().encodeToString(salt);
		//byte[] bytes = Base64.getDecoder().decode(pseudo + password + saltString);

		byte[] hash = digest.digest(new String(pseudo + password + saltString).getBytes("UTF-8"));
		for (int i = 0; i < 6; i++) {
			hash = digest.digest(hash);
		}
		
		String hashString=(new HexBinaryAdapter().marshal(hash)).toString();
		//String hashString = Base64.getEncoder().encodeToString(hash);
		
		stmt.setString(4, hashString);
		stmt.setString(5, saltString);
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
	
	public void modifyUser(int id, String pseudo, String password, String role) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
		PreparedStatement stmt = co.prepareStatement("UPDATE users SET pseudo = ?, password = ?, role = ?, hashcart = ? WHERE id = ?");
		stmt.setString(1, pseudo);
		stmt.setString(2, password);
		stmt.setString(3, role);
				
		pseudo += pseudo;
		pseudo += pseudo;

		password += password;
		password += password;

		
		ResultSet rsUser = getUser(id);	
		rsUser.next();
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		String saltString = rsUser.getString(6);
		byte[] hash = digest.digest(new String(pseudo + password + saltString).getBytes("UTF-8"));
		//byte[] bytes = Base64.getDecoder().decode(pseudo + password + saltString);
		//byte[] hash = digest.digest(bytes);
		for (int i = 0; i < 6; i++) {
			hash = digest.digest(hash);
		}
		
		//String hashString=digest.toString();
		String hashString=(new HexBinaryAdapter().marshal(hash)).toString();
		//String hashString = Base64.getEncoder().encodeToString(hash);
		
		stmt.setString(4, hashString);
		stmt.setInt(5, id);
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
