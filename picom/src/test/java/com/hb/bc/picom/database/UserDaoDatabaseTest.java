package com.hb.bc.picom.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class UserDaoDatabaseTest {

	
	
	@Test
	void test() {
		User user = mock(User.class);
		when(user.getFirstName()).thenReturn("Jonathan");
		System.out.println(user.getFirstName());
		UserDaoDatabase userDaoDatabase 
		assert
	}

}
