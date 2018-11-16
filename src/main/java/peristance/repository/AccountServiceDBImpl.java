package peristance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.util.JSONUtil;

import persistance.domain.Account;



@Default 
@Transactional(SUPPORTS) // for table not changing like find
public class AccountServiceDBImpl implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	
	@Override
	public String getAllAccounts() {
		TypedQuery<Account> accounts = manager.createQuery("Select a FROM Account a",Account.class);
		return JSONUtil.getJSONForObject(accounts);
	}

	
	
	
	

	@Override
	@Transactional(REQUIRED)
	public String addAccount(String account) {
		Account anAccount = JSONUtil.getObjectForJSON(account, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	
	
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String accountToUpdate) {
		Account updatedAccount = JSONUtil.getObjectForJSON(accountToUpdate, Account.class);
		Account accountFromDB = findAccount(id);
		if (accountToUpdate != null) {
			accountFromDB = updatedAccount;
			manager.merge(accountFromDB);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}




	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	
	






	
	
	
}
