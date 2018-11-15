package peristance.repository;

import java.util.List;

import persistance.domain.Account;

public interface AccountRepository {

	//List<Account> findAllAccounts();
	
	//Account findAccount(Long id);
	
	Account createAccount(Long id, Account createAccount);
	
	Account updateAccount(Account updateAccount, long id);
	
	Account deleteAccount(Account deleteAccount, long id);
	
	
}
