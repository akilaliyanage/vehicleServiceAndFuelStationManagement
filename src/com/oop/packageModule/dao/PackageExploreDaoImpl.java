package com.oop.packageModule.dao;
//IT19120058
//Geethika L.W.S

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;
import com.oop.database.DatabaseConnection;
import com.oop.packageModule.model.ServicePackage;

public class PackageExploreDaoImpl implements PackageExploreDao {

	@Override
	public int addServicePackage(ServicePackage servicePackage) {
		int rowInserted = 0;
		Connection connection = DatabaseConnection.getConnection();//get database connection from DatabaseConnection class
		//defining the sql query to save a package
		String sql = "INSERT INTO `package`(`packId`, `adminRegNo`, `packType`, `packName`, `price`, `packDescription`, `packImage`) VALUES (?,?,?,?,?,?,?)";
		
		try {//pass the defined sql query to the prepared statement
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, servicePackage.getPackId()); //set the parameters to the prepared statement
			statement.setString(2, servicePackage.getAdminRegNo());
			statement.setString(3, servicePackage.getPackType());
			statement.setString(4, servicePackage.getPackName());
			statement.setFloat(5, servicePackage.getPrice());
			statement.setString(6, servicePackage.getPackDescription());
			statement.setString(7, servicePackage.getPackImage());
			statement.executeUpdate(); //execute the prepared statement
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				rowInserted = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowInserted;
	}

	@Override
	public ServicePackage updateServicePackage(ServicePackage servicePackage) {

		Connection connection = DatabaseConnection.getConnection();//get database connection from DatabaseConnection class
		
		//defining the sql query to update a package
		String sql = "UPDATE `package` SET " + "`adminRegNo`= '" + servicePackage.getAdminRegNo() + "',`packType`= '"
				+ servicePackage.getPackType() + "' ,`packName`= '" + servicePackage.getPackName() + "' ,`price`= '"
				+ servicePackage.getPrice() + "' ,`packDescription`= '" + servicePackage.getPackDescription()
				+ "' ,`packImage`= '" + servicePackage.getPackImage() + "' WHERE `packId`= '"
				+ servicePackage.getPackId() + "' ";
		try {//pass the defined sql query to the prepared statement
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();//execute the prepared statement
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return servicePackage;
	}

	@Override
	public int removeServicePackage(String id) {
		Connection connection = DatabaseConnection.getConnection();//get database connection from DatabaseConnection class
		
		//defining the sql query to delete a package
		String sql = "DELETE FROM `package` WHERE `packId`= '" + id + "' ";
		try {//pass the defined sql query to the prepared statement
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();//execute the prepared statement
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	@Override
	public ServicePackage getServicePackageById(String id) {
		Connection connection = DatabaseConnection.getConnection();//get database connection from DatabaseConnection class
		
		//defining the sql query to select a package by id
		String sql = "SELECT `packId`, `adminRegNo`, `packType`, `packName`, `price`, `packDescription`, `packImage` FROM `package` WHERE `packId`= '"
				+ id + "' ";
		ServicePackage servicePackage = null;
		try {//pass the defined sql query to the prepared statement
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);//execute the prepared statement
			servicePackage = mapRow(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return servicePackage;
	}

	@Override
	public List<ServicePackage> getServicePackageByName(String name) {
		Connection connection = DatabaseConnection.getConnection();//get database connection from DatabaseConnection class
	
		//defining the sql query to select a package by name
		String sql = "SELECT `packId`, `adminRegNo`, `packType`, `packName`, `price`, `packDescription` FROM `package` WHERE packName ="
				+ name + "' ";
		List<ServicePackage> packages = new ArrayList<>();
		try {//pass the defined sql query to the prepared statement
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);//execute the prepared statement
			packages = getServicePackages(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return packages;
	}

	@Override
	public List<ServicePackage> getAllServicePackagesS() {
		Connection connection = DatabaseConnection.getConnection();//get database connection from DatabaseConnection class
		
		//defining the sql query to select all the packages
		String sql = "SELECT * FROM `package`";
		List<ServicePackage> servicePackages = new ArrayList<>();

		try {//pass the defined sql query to the prepared statement
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);//execute the prepared statement
			servicePackages = getServicePackages(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return servicePackages;
	}

	private List<ServicePackage> getServicePackages(ResultSet result) {
		List<ServicePackage> servicePackages = new ArrayList<>();
		try {
			while (result.next()) {
				ServicePackage servicePackage = new ServicePackage();
				servicePackage.setAdminRegNo(result.getString("adminRegNo"));
				servicePackage.setPackDescription(result.getString("packDescription"));
				servicePackage.setPackId(result.getString("packId"));
				servicePackage.setPackName(result.getString("packName"));
				servicePackage.setPackType(result.getString("packType"));
				servicePackage.setPrice(result.getFloat("price"));
				servicePackage.setPackImage(result.getString("packImage"));
				servicePackages.add(servicePackage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return servicePackages;
	}

	private ServicePackage mapRow(ResultSet result) {
		ServicePackage servicePackage = new ServicePackage();
		try {
			if (result.next()) {
				servicePackage.setAdminRegNo(result.getString("adminRegNo"));
				servicePackage.setPackDescription(result.getString("packDescription"));
				servicePackage.setPackId(result.getString("packId"));
				servicePackage.setPackName(result.getString("packName"));
				servicePackage.setPackType(result.getString("packType"));
				servicePackage.setPrice(result.getFloat("price"));
				servicePackage.setPackImage(result.getString("packImage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return servicePackage;
	}

}
