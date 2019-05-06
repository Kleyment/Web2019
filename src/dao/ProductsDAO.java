package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsDAO {

private Connection co;
	
	public ProductsDAO() {
		co = ConnexionDB.getInstance().getCnx();
	}
	
	public void insertProduct(String name, Double price) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("INSERT INTO products (name,price) values (?,?);");
		stmt.setString(1, name);
		stmt.setDouble(2, price);
		stmt.executeUpdate();
	}
	
	public void insertProductImage(String name, Double price, String image) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("INSERT INTO products (name,price,image) values (?,?,?);");
		stmt.setString(1, name);
		stmt.setDouble(2, price);
		stmt.setString(3, image);
		stmt.executeUpdate();
	}
	
	public void insertProductDescription(String name, Double price, String description) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("INSERT INTO products (name,price,description) values (?,?,?);");
		stmt.setString(1, name);
		stmt.setDouble(2, price);
		stmt.setString(3, description);
		stmt.executeUpdate();
	}
	
	public void insertProductFull(String name, Double price, String image, String description) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("INSERT INTO products (name,price,image,description) values (?,?,?,?);");
		stmt.setString(1, name);
		stmt.setDouble(2, price);
		stmt.setString(3, image);
		stmt.setString(4, description);
		stmt.executeUpdate();
	}
	
	public ResultSet getProducts() throws SQLException {
		PreparedStatement stmt = co.prepareStatement("SELECT * FROM products");
		return stmt.executeQuery(); 		
	}
	
	public void deleteProduct(int id) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("DELETE FROM products WHERE id = ?;");
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
	
	public void modifyProduct(int id, String name, Double price) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("UPDATE products SET name = ?, price = ? WHERE id = ?");
		stmt.setString(1, name);
		stmt.setDouble(2, price);
		stmt.setInt(3, id);
		stmt.executeUpdate();
	}
	
	public void modifyProductImage(int id, String name, Double price, String image) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("UPDATE products SET name = ?, price = ?, image = ? WHERE id = ?");
		stmt.setString(1, name);
		stmt.setDouble(2, price);
		stmt.setString(3,  image);
		stmt.setInt(4, id);
		stmt.executeUpdate();
	}
	
	public void modifyProductDescription(int id, String name, Double price, String description) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("UPDATE products SET name = ?, price = ?, description = ? WHERE id = ?");
		stmt.setString(1, name);
		stmt.setDouble(2, price);
		stmt.setString(3,  description);
		stmt.setInt(4, id);
		stmt.executeUpdate();
	}
	
	public void modifyProductFull(int id, String name, Double price, String image, String description) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("UPDATE products SET name = ?, price = ?, image = ?, description = ? WHERE id = ?");
		stmt.setString(1, name);
		stmt.setDouble(2, price);
		stmt.setString(3,  image);
		stmt.setString(4,  description);
		stmt.setInt(5, id);
		stmt.executeUpdate();
	}
	
	public ResultSet getProduct(int id) throws SQLException {
		PreparedStatement stmt = co.prepareStatement("SELECT * FROM products WHERE id = ?");
		stmt.setInt(1, id);
		return stmt.executeQuery();
	}
	
}
