package com.oop.service;

import java.util.ArrayList;
import java.util.List;

import com.oop.DAO.IgetMechanicDAO;
import com.oop.DAO.getMechanicDAOImpl;
import com.oop.model.NewMechModel;

public class mechanicServicesImpl implements ImechanicServices {
IgetMechanicDAO mech = new getMechanicDAOImpl();
	@Override
	public List<NewMechModel> getAllMechanics() {
		List<NewMechModel> allMech = new ArrayList<NewMechModel>();
		allMech = mech.getAllMechanics();
		return allMech;
	}

}
