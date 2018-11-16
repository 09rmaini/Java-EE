package com.qa.business;

import javax.inject.Inject;



import peristance.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	public String getAllAccounts() {
	
		return repo.getAllAccounts();
	}

	public String addAccount(String account) {
		return repo.addAccount(account);
	}

	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);

	}

	//public void setRepo(AccountRepository repo) {
	//	this.repo = repo;
	//}

	
	
}
