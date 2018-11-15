package peristance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;


import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.util.JSONUtil;

import persistance.domain.Account;


@Transactional(SUPPORTS) // for table not changing like find
@Default 
public class AccountServiceDBImpl implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	public List<Account> findAllAccounts() {
        TypedQuery<Account> query = manager.createQuery("SELECT m FROM Account m ORDER BY m.account_number DESC", Account.class);
        return query.getResultList();
    }
	
	public Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}
	
	
	

	@Transactional(REQUIRED)
	public Account createAccount(Long id,Account createAccount) {
		manager.persist(createAccount);
		return createAccount;
	}
	
	@Transactional(REQUIRED)
	public Account updateAccount(Account updateAccount, long id) {
		Account oldAccount=manager.find(Account.class, id);
		oldAccount.setFirst_name(updateAccount.getFirst_name());
		oldAccount.setSurname(updateAccount.getSurname());
		
		//updateAccount()
		
		
		manager.merge(updateAccount);
		return updateAccount;
	}
	
	@Transactional(REQUIRED)
	public Account deleteAccount(Account deleteAccount, long id) {
		manager.remove(deleteAccount);
		return deleteAccount;
	}
	
	
}
