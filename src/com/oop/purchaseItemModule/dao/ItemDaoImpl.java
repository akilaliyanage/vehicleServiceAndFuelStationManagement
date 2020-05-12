package com.oop.purchaseItemModule.dao;

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
import com.oop.purchaseItemModule.model.Item;
import com.oop.purchaseItemModule.model.RegUserItem;

public class ItemDaoImpl implements ItemDao {

	@Override
	public List<Item> getAllItems() {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM `item`";
		List<Item> items = new ArrayList<>();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			items = getItems(result);
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
		return items;
	}

	private List<Item> getItems(ResultSet result) {
		List<Item> items = new ArrayList<>();
		try {
			while (result.next()) {
				Item item = new Item();
				item.setItemId(result.getString("itemId"));
				item.setItemImage(result.getString("itemImage"));
				item.setItemname(result.getString("itemname"));
				item.setItemType(result.getString("itemType"));
				item.setPrice(result.getFloat("price"));
				item.setQuantity(result.getFloat("quantity"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public void savePurchasedItems(RegUserItem userItem) {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "INSERT INTO `reguser_item`(`itemId`, `custId`, `cartNo`, `qty`) VALUES (?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, userItem.getItemId());
			statement.setString(2, userItem.getCustId());
			statement.setString(3, userItem.getCartNo());
			statement.setInt(4, userItem.getQuantity());
			statement.executeUpdate();

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
	}

}
