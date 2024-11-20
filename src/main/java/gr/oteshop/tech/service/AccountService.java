package gr.oteshop.tech.service;

import gr.oteshop.tech.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    void transferFunds(Long fromAccountId, Long toAccountId, Double amount);
    Optional<Account> findUserAccount(String userName);
    boolean existsByBalanceGreaterThan(double amount);
}
