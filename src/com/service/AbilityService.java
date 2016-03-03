package com.service;

import java.util.List;

import com.dao.AbilityDAO;
import com.model.Ability;

public interface AbilityService {
	
	public abstract void setAbilitydao(AbilityDAO abilitydao);
	
	public abstract void addAbility(Ability ability);

	public abstract void updateAbility(Ability ability);
	
	public abstract void deleteAbility(Ability ability);

	public abstract List findByAbilityName(String abilityname);

	public abstract Ability findById(int abilityid);
}
