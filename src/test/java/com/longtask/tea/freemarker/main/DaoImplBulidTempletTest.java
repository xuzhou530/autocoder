package com.longtask.tea.freemarker.main;

import org.junit.Before;
import org.junit.Test;

import com.longtask.tea.freemarker.BulidTemplet;


public class DaoImplBulidTempletTest{
	private BulidTemplet bulidTemplet;
	@Before
	public void setUp(){
		bulidTemplet = new DaoImplFileBulidTemplet();
	}
	
	@Test
	public void testBuildSourceFile(){
		bulidTemplet.buildSourceFile("app");
	}
}
