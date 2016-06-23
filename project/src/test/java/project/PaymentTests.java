package project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import com.jsobral.project.dao.BaseDAO;
import com.jsobral.project.model.Payment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback=false,transactionManager="transactionManager")
public class PaymentTests {

	@Autowired
	BaseDAO dao;
	
	@Test
	public void testInsert(){
		Payment payment = new Payment();
		payment.setType(Payment.VISA);
		payment.setCard(4444555566667777L);
		payment.setExpiry(416);
		payment.setCode(345);
		payment.setTotal(45.5);
		dao.save(payment);
	}
	
}
