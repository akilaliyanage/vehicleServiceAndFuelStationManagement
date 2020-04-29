package com.oop.purchaseItemModule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oop.database.DatabaseConnection;
import com.oop.purchaseItemModule.model.Item;

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

}
