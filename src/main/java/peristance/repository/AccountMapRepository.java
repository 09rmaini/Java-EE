package peristance.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import persistance.domain.Account;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class AccountMapRepository implements AccountRepository {
	
	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Account> accountMap;
	

	public AccountMapRepository() {
		this.accountMap = new HashMap<Long, Account>();
		
		initAccountMap();
	}


	public String getAllAccounts() {
		return JSONUtil.getJSONForObject(accountMap.values());
	}
	




	public Account createAccount(Long id, Account createAccount) {
		
		Account newAccount = JSONUtil.getObjectForJSON(createAccount, Account.class);
		accountMap.put(id, newAccount);
		return createAccount;
	}

	
	public Account updateAccount(Account updateAccount, long id) {
		Account newAccount = JSONUtil.getObjectForJSON(updateAccount, Account.class);
		accountMap.put(id, newAccount);
		return updateAccount;
	}

	
	public Account deleteAccount(Account deleteAccount, long id) {
		accountMap.remove(id);
		return deleteAccount;
	}

	private void initAccountMap() {
		Account account = new Account();
		accountMap.put(1L, account);
	}


	
	


	

}
