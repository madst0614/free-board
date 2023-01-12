package org.freeBoard.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class MenuServiceTests {
	
	@Autowired
	private MenuServiceImpl service;
	
//	@Test
//	public void testInit() {
//		Map<String, CategoryVO> temp = service.init();
//
//		temp.forEach((k, v) -> log.info("result!!!!!!!!" + k + "   " + v));
//	}
	
//	@Test
//	public void testCreateCategory() {
//		Map<String, CategoryVO> menu = service.init();
//		CategoryVO root = service.createCategoryTree(menu);
//		
//		log.info("result!!!!!!!!" +root);
//
//	}
	
	@Test
	public void testGetMenu() {
		log.info("result!!!!!!!!"+service.getMenu());
	}
}
