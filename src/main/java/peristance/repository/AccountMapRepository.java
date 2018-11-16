package peristance.repository;


import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;


import persistance.domain.Account;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class AccountMapRepository implements AccountRepository  {
	

	
	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Account> accountMap;
	private Long ID;
	
	


	public String getAllAccounts() {
		return JSONUtil.getJSONForObject(accountMap.values());
	}
	




	public String addAccount(String account) {
		ID++;
		Account newAccount = JSONUtil.getObjectForJSON(account, Account.class);
		accountMap.put(ID, newAccount);
		return account;
	}

	
	public String updateAccount(Long id, String accountToUpdate) {
		Account newAccount = JSONUtil.getObjectForJSON(accountToUpdate, Account.class);
		accountMap.put(id, newAccount);
		return accountToUpdate;
	}


	
	public String deleteAccount(Long id) {
		accountMap.remove(id);
		return "{\"message\": \"accout successfully \"}";
	}

	private void initAccountMap() {
		Account account = new Account();
		accountMap.put(1L, account);
	}


	


	


	
	


	

}
