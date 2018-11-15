package persistance.domain;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qa.util.JSONUtil;

import persistance.domain.Account;



public class AccountServiceDBImpl {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	
	public String createAccount(Account account) {
		Account anAccount= JSONUtil.getObjectForJSON(account,Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account successfully added\"}";
	}
	
	
}
