package com.oop.purchaseItemModule.service;

import java.util.List;

import com.oop.purchaseItemModule.model.Item;
import com.oop.purchaseItemModule.model.RegUserItem;

public interface ItemService {
	public List<Item> getAllItems();

	public void savePurchasedItems(List<RegUserItem> userItems);
}
