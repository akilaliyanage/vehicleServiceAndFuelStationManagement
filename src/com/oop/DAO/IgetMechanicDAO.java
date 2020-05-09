//Created by D.H.M.M.P.Thammita
//IT No : IT19120362
//this Interface id implemented by getMechanicDAOImpl Class


package com.oop.DAO;

import java.util.List;

import com.oop.model.NewMechModel;

public interface IgetMechanicDAO {
	
	/*
	 * This method will accept No arguments and returns the List of all mechanics That are available
	 * in the system 
	 * */

	List<NewMechModel> getAllMechanics();

}
