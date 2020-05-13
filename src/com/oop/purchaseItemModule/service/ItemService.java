package com.oop.purchaseItemModule.service;

//IT19120058
//Geethika L.W.S

import java.util.List;

import com.oop.purchaseItemModule.model.Item;
import com.oop.purchaseItemModule.model.RegUserItem;

public interface ItemService {
	public List<Item> getAllItems();//Retrieve all items Service Function definition

	public void savePurchasedItems(List<RegUserItem> userItems);//Save purchased items Service Function definition
}
