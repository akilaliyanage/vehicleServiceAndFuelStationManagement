package com.oop.purchaseItemModule.dao;

import java.util.List;

import com.oop.purchaseItemModule.model.Item;
import com.oop.purchaseItemModule.model.RegUserItem;

public interface ItemDao {
	public List<Item> getAllItems();

	public void savePurchasedItems(RegUserItem userItems);
}
