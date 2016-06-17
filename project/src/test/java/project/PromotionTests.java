package project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.jsobral.project.dao.BaseDAO;
import com.jsobral.project.model.Promotion;
import com.jsobral.project.service.PromotionsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
public class PromotionTests {

	@Autowired
	private PromotionsService service;
	
	@Autowired
	@Qualifier("baseDAO")
	private BaseDAO dao;

	@Test
	@Transactional
	public void testInsertAndFetch() {

	}
	
}
