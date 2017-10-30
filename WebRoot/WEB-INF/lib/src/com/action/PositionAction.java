package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.spec.PSource;



import com.bean.Position;
import com.bean.SimplePosition;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PositionService;

public class PositionAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PositionService positionservice;
    private Map<String,List<SimplePosition>> posMap = new HashMap<String, List<SimplePosition>>();
	public Map<String, List<SimplePosition>> getPosMap() {
		return posMap;
	}

	public void setPosMap(Map<String, List<SimplePosition>> posMap) {
		this.posMap = posMap;
	}

	public PositionService getPositionservice() {
		return positionservice;
	}

	public void setPositionservice(PositionService positionservice) {
		this.positionservice = positionservice;
	}
	
	// 获取所有职位信息
	
	public String getPositions () {
		List<Object[]> positions = positionservice.getPositions();   // service 获取所有职位信息
		List<SimplePosition> rePositions = new ArrayList<SimplePosition>();
		if ( positions != null && positions.size() > 0 ) {
			//Iterator<Object[]> itPosition = positions.iterator(); // 遍历职位信息，过滤掉不用的字段的信息
			for ( Object[] obj : positions ) {
				Position position = (Position) obj[0];
				SimplePosition simPos = new SimplePosition();  //SimplePosition： pos实体的缩减实体
				simPos.setEmpId(position.getEmpId());
				simPos.setId(position.getPosId());
				simPos.setPosName(position.getPosName());
				simPos.setDepId(position.getOrganization().getOrgId());  
				simPos.setDepName(position.getOrganization().getOrgName());
				simPos.setRoleId(position.getRole().getRoleId());
				simPos.setRoleName(position.getRole().getRoleName());
				rePositions.add(simPos);
			}
			posMap.put("positions", rePositions);
		}
		return SUCCESS;
	}

}
