package com.service;

import java.util.List;

import com.dao.PositionDAO;
import com.model.Position;

public interface PositionService {

public abstract void setPositiondao(PositionDAO positiondao);
	
	public abstract void addPosition(Position position);

	public abstract void updatePosition(Position position);
	
	public abstract void deletePosition(Position position);

	public abstract List findByPositionName(String positionname);
	
	public abstract List findByPrivilege(int privilege);
	
	public abstract List findByEmpId();
	
	public abstract List findByRoleId(int roleid);

	public abstract Position findById(int positionid);
}
