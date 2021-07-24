package com.hb.bc.picom.dao;

import com.hb.bc.picom.database.*;

public interface UserDao {
	
	public void create(User aUser);
	public User read(int id);
	public void update(User aUser);
	public void delete(User aUser);
	
}
