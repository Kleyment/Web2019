package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDAO {

private Connection co;
	
	public CartDAO() {
		co = ConnexionDB.getInstance().getCnx();
	}
	
	public ResultSet getUserFromHash(String hash) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("SELECT * FROM users WHERE hashcart = ?");
		stmt.setString(1, hash);
		return stmt.executeQuery();
	}
}
