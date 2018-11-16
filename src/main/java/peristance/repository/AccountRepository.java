package peristance.repository;

import java.util.List;

import persistance.domain.Account;

public interface AccountRepository {

	String getAllAccounts();
	
	String addAccount(String account);
	
	String updateAccount(Long id, String accountToUpdate);
	
	String deleteAccount(Long id);
	
	
}
