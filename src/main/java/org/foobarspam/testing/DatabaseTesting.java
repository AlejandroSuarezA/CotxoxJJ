package org.foobarspam.testing;

import static org.junit.Assert.*;

import org.foobarspam.model.CotxoxService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTesting {
	
	@Autowired
	private CotxoxService cotDB;
	
	@Test
	public void test1(){
		Long valuer = cotDB.getFlotila();
		assertTrue(valuer == 3L);
	}
	

}
