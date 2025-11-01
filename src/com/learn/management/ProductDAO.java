package com.learn.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	private static final String insertData= "INSERT INTO `PRODUCT` (`name`, `quantity`,`price`) VALUES (?,?,?)";
	private static final String  getData = "SELECT * FROM PRODUCT";
	private static final String updateData = "UPDATE PRODUCT SET `quantity`=? where `id` = ?";
	private static final String deleteData = "DELETE FROM PRODUCT WHERE `id` = ? ";
	
	public void addProduct(Product product) throws SQLException{
		
		Connection connection=null;
		PreparedStatement statment=null;
		
		try {
			connection=DBUtil.connentionEstablish();
			statment=connection.prepareStatement(insertData);
			statment.setString(1, product.getProductName());
			statment.setInt(2,product.getQuantity());
			statment.setDouble(3, product.getPrice());
			int rowAffected=statment.executeUpdate();
			
			if(rowAffected>0) {
				System.out.println("Successfully inserted product detail.");
			}
		} finally {
			DBUtil.closeResourses(statment,connection);
		}
		
	}
	
	public List<Product> getAllData() throws SQLException{
		List<Product> products = new ArrayList<Product>();
		
		Connection connection=null;
		PreparedStatement statment=null;
		ResultSet result = null;
		
		try {
			
			connection=DBUtil.connentionEstablish();
			statment=connection.prepareStatement(getData);
			result=statment.executeQuery();
			
			while(result.next()) {
				int id=result.getInt("id");
				String productName=result.getString("name");
				int quantity= result.getInt("quantity");
				double price = result.getDouble("price");
				
				Product p=new Product(id,productName,quantity,price);
				products.add(p);
			}
			return products;
			
		} finally {
			DBUtil.closeResourses(result,statment,connection);
		}
		
		
	}
	
	public void updateProductQuantity(int id, int quantity) throws SQLException{
		
		Connection connection=null;
		PreparedStatement statment=null;
		
		try {
			
			connection=DBUtil.connentionEstablish();
			statment=connection.prepareStatement(updateData);
			statment.setInt(1, quantity);
			statment.setInt(2, id);
			
			int rowAffected = statment.executeUpdate();
			
			if(rowAffected>0) {
				System.out.println("Record Updated.");
			}
			
			
		} finally {
			DBUtil.closeResourses(statment,connection);
		}
		
		
	}
	
	public void deleteProduct(int id) throws SQLException{
		
		Connection connection=null;
		PreparedStatement statment=null;
		
		try {
			
			connection=DBUtil.connentionEstablish();
			statment=connection.prepareStatement(deleteData);
			statment.setInt(1, id);
			
			
			int rowAffected = statment.executeUpdate();
			
			if(rowAffected>0) {
				System.out.println("Record Deleted.");
			}
			
			
		} finally {
			DBUtil.closeResourses(statment,connection);
		}
		
	}
	
	
}
