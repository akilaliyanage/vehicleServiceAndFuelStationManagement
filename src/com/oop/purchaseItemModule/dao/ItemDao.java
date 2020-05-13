package com.oop.purchaseItemModule.dao;

//IT19120058
//Geethika L.W.S

import java.util.List;

import com.oop.purchaseItemModule.model.Item;
import com.oop.purchaseItemModule.model.RegUserItem;
//DAO Interface to define methods regarding Purchase Items
public interface ItemDao {
	public List<Item> getAllItems();//Retrive all Items DAO function method definition

	public void savePurchasedItems(RegUserItem userItems);//Save Purchased Items DAO function method definition
}
