package com.oop.purchaseItemModule.service;

//IT19120058
//Geethika L.W.S

import java.util.List;

import com.oop.purchaseItemModule.dao.ItemDao;
import com.oop.purchaseItemModule.dao.ItemDaoImpl;
import com.oop.purchaseItemModule.model.Item;
import com.oop.purchaseItemModule.model.RegUserItem;

public class ItemServiceImpl implements ItemService {

	ItemDao itemdao = new ItemDaoImpl();

	@Override
	public List<Item> getAllItems() {
		return itemdao.getAllItems();
	}

	@Override
	public void savePurchasedItems(List<RegUserItem> userItems) {
		for (RegUserItem regUserItem : userItems) {
			itemdao.savePurchasedItems(regUserItem);
		}
	}

}
