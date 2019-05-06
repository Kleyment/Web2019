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
	
	public void insertProduct(String hashcart, int idItem) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("INSERT INTO cart (hashcart,iditem) values (?,?);");
		stmt.setString(1, hashcart);
		stmt.setInt(2, idItem);
		stmt.executeUpdate();
	} 
	
	public ResultSet getCart(String hashcart) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("SELECT * FROM cart WHERE hashcart = ?;");
		stmt.setString(1, hashcart);
		return stmt.executeQuery(); 
	}
	
	public void deleteProduct(int idItem, String hashcart) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("DELETE FROM cart WHERE iditem = ? AND hashcart = ?;");
		stmt.setInt(1, idItem);
		stmt.setString(2, hashcart);
		stmt.executeUpdate();
	}
	
	public void deleteCart(String hashcart) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("DELETE FROM cart WHERE hashcart = ?;");
		stmt.setString(1, hashcart);
		stmt.executeUpdate();
	}
}
