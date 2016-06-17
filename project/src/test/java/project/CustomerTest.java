package project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import com.jsobral.project.dao.BaseDAO;
import com.jsobral.project.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class CustomerTest {
	
	@Autowired
	BaseDAO dao;

	@Test
	public void saveCustomerTest(){
		Customer customer = new Customer();
		customer.setCountry("ie");
		customer.setName("john");
		customer.setSurname("doe");
		customer.setCity("dublin");
		customer.setEmail("john@doe.ie");
		customer.setPhone("+351956356565");

		dao.save(customer);
	}
}
