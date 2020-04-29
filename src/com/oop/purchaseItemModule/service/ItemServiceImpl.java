package com.oop.purchaseItemModule.service;

import java.util.List;

import com.oop.purchaseItemModule.dao.ItemDao;
import com.oop.purchaseItemModule.dao.ItemDaoImpl;
import com.oop.purchaseItemModule.model.Item;

public class ItemServiceImpl implements ItemService {

	ItemDao itemdao = new ItemDaoImpl();

	@Override
	public List<Item> getAllItems() {
		return itemdao.getAllItems();
	}

}
